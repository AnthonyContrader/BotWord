package it.contrader.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.User;

/**
 *
 * @author Vittorio
 *
 *Per i dettagli della classe vedi Guida sez 6: DAO
 */
public class LoginDAO {

	private final String QUERY_LOGIN = "SELECT * FROM users WHERE user_user = ? AND user_password = ?";


	public User login (String username, String password) {

		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement statement = connection.prepareStatement(QUERY_LOGIN);

			statement.setString(1, username);
			statement.setString(2, password);


			ResultSet resultSet = statement.executeQuery();

			if(resultSet.next()) {
				String usertype = resultSet.getString("user_type");
				int id = resultSet.getInt("user_id");
				User user = new User(id, username, password, usertype);

				return user;
			}

			return null;
		}

		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
