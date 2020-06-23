package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.User;

public class UserDAO {

	private final String QUERY_ALL = "select * from users";
	private final String QUERY_INSERT = "insert into users (user_user, user_type, user_password, user_name, user_surname, user_address) values (?,?,?,?,?,?)";
	private final String QUERY_READ = "select * from users where user_id=?";

	private final String QUERY_UPDATE = "UPDATE users SET user_user=?, user_type=? WHERE user_id=?";
	private final String QUERY_DELETE = "delete from users where user_id=?";

	public UserDAO() {

	}

	public List<User> getAllUser() {
		List<User> usersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			User user;
			while (resultSet.next()) {
				int userId = resultSet.getInt("user_id");
				String username = resultSet.getString("user_user");
				String usertype = resultSet.getString("user_type");
				String password = resultSet.getString("user_password");
				String name = resultSet.getString("user_name");
				String surname = resultSet.getString("user_surname");
				String address = resultSet.getString("user_address");
				user = new User(username, usertype, password, name, surname, address);
				user.setUserId(userId);
				usersList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public boolean insertUser(User user) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, user.getUsername());
			preparedStatement.setString(2, user.getUsertype());
			preparedStatement.setString(3, user.getUserPassword());
			preparedStatement.setString(4, user.getName());
			preparedStatement.setString(5, user.getSurname());
			preparedStatement.setString(6, user.getAddress());


			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public User readUser(int userId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String username, usertype;

			username = resultSet.getString("user_user");
			usertype = resultSet.getString("user_type");
			String password = resultSet.getString("user_password");
			String name = resultSet.getString("user_name");
			String surname = resultSet.getString("user_surname");
			String address = resultSet.getString("user_address");
			User user = new User(username, usertype, password, name, surname, address);
			user.setUserId(resultSet.getInt("user_id"));

			return user;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateUser(User userToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (userToUpdate.getUserId() == 0)
			return false;

		User userRead = readUser(userToUpdate.getUserId());
		if (!userRead.equals(userToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (userToUpdate.getUsername() == null || userToUpdate.getUsername().equals("")) {
					userToUpdate.setUsername(userRead.getUsername());
				}
				
				
				if (userToUpdate.getUsertype() == null || userToUpdate.getUsertype().equals("")) {
					userToUpdate.setUsertype(userRead.getUsertype());
				}
				
				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, userToUpdate.getUsername());
				preparedStatement.setString(2, userToUpdate.getUsertype());
				preparedStatement.setInt(3, userToUpdate.getUserId());
				int a = preparedStatement.executeUpdate();
				if (a > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				return false;
			}
		}

		return false;
		
	}

	public boolean deleteUser(Integer id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n == 1)
				return true;
			else 
				return false;
		} catch (SQLException e) {
			return false;
		}
		
	}
}
