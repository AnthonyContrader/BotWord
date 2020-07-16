package it.contrader.dao;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.User;

/**
 *
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class UserDAO implements DAO<User> {

	private final String QUERY_ALL = "SELECT * FROM users";
	private final String QUERY_CREATE = "INSERT INTO users (user_user, user_password, user_type) VALUES (?,?,?)";
	private final String QUERY_READ = "SELECT * FROM users WHERE user_id=?";
	private final String QUERY_UPDATE = "UPDATE users SET user_user=?, user_password=?, user_type=? WHERE user_id=?";
	private final String QUERY_DELETE = "DELETE FROM users WHERE user_id=?";

	public UserDAO() {

	}

	public List<User> getAll() {
		List<User> usersList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			User user;
			while (resultSet.next()) {
				int id = resultSet.getInt("user_id");
				String username = resultSet.getString("user_user");
				String password = resultSet.getString("user_password");
				String usertype = resultSet.getString("user_type");
				user = new User(username, password, usertype);
				user.setUserId(id);
				usersList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return usersList;
	}

	public boolean insert(User userToInsert) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_CREATE);
			preparedStatement.setString(1, userToInsert.getUsername());
			preparedStatement.setString(2, userToInsert.getUserPassword());
			preparedStatement.setString(3, userToInsert.getUsertype());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			return false;
		}

	}

	public User read(int userId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {


			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
			String username, password, usertype;

			username = resultSet.getString("user_user");
			password = resultSet.getString("user_password");
			usertype = resultSet.getString("user_type");
			User user = new User(username, password, usertype);
			user.setUserId(resultSet.getInt("user_id"));

			return user;
		} catch (SQLException e) {
			return null;
		}

	}

	public boolean update(User userToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (userToUpdate.getUserId() == 0)
			return false;

		User userRead = read(userToUpdate.getUserId());
		if (!userRead.equals(userToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (userToUpdate.getUsername() == null || userToUpdate.getUsername().equals("")) {
					userToUpdate.setUsername(userRead.getUsername());
				}

				if (userToUpdate.getUserPassword() == null || userToUpdate.getUserPassword().equals("")) {
					userToUpdate.setUserPassword(userRead.getUserPassword());
				}

				if (userToUpdate.getUsertype() == null || userToUpdate.getUsertype().equals("")) {
					userToUpdate.setUsertype(userRead.getUsertype());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setString(1, userToUpdate.getUsername());
				preparedStatement.setString(2, userToUpdate.getUserPassword());
				preparedStatement.setString(3, userToUpdate.getUsertype());
				preparedStatement.setInt(4, userToUpdate.getUserId());
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

	public boolean delete(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_DELETE);
			preparedStatement.setInt(1, id);
			int n = preparedStatement.executeUpdate();
			if (n != 0)
				return true;

		} catch (SQLException e) {
		}
		return false;
	}


}
