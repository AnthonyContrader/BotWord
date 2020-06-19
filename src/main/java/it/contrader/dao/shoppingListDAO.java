package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.ShoppingList;
import it.contrader.model.ShoppingItem;

public class ShoppingListDAO {

	private final String QUERY_ALL = "select * from shopping_lists";
	private final String QUERY_INSERT = "insert into shopping_lists (user_id, total_price, shopping_list) values (?,?, ?)";
	private final String QUERY_READ = "select * from shopping_lists where shopping_list_id=?";

	private final String QUERY_UPDATE = "UPDATE shopping_lists SET total_price=?, shopping_list=? WHERE shopping_list_id=?";
	private final String QUERY_DELETE = "delete from user where shopping_list_id=?";

	public ShoppingListDAO() {}

	public List<ShoppingList> getAllShoppingLists() {
		List<ShoppingList> shoppingsLists = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			ShoppingList ShoppingLists;
			while (resultSet.next()) {
				int shoppingListId = resultSet.getInt("shopping_list_id");
				int userId= resultSet.getString("user_id");
				Double totalPrice = resultSet.getString("total_price");
        ArrayList<ShoppingItem> shoppingList =  resultSet.getString("shopping_list");
				shoppingList = new ShoppingList(userId, totalPrice, shoppingList);
				user.setShoppingListId(shoppingListId);
				shoppingListsList.add(shoppingList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shoppingLists;
	}

	public boolean insertShoppingList(ShoppingList shoppingList) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setString(1, shoppingList.getUserId());
      preparedStatement.setString(3, shoppingList.getTotalPrice());
			preparedStatement.setString(3, shoppingList.getShoppingList());
			preparedStatement.execute();
			return true;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}

	}

	public ShoppingList readShoppingList(int shoppingListId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_READ);
			preparedStatement.setInt(1, shoppingListId);
			ResultSet resultSet = preparedStatement.executeQuery();
			resultSet.next();
      int userId;
      Double totalPrice;
      ArrayList<ShoppingItem> shoppingList;

			userId = resultSet.getString("user_id");
			Double resultSet.getString("total_price");
			ShoppingList shoppingList = new ShoppingList(userId, totalPrice, shoppingList);
			user.setShoppingListId(resultSet.getInt("shopping_list_id"));

			return shoppingList;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateShoppingList(ShoppingList shoppingListToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (shoppingListToUpdate.getShoppingListId() == 0)
			return false;

		ShoppingList shoppingListRead = readShoppingList(userToUpdate.getShoppingListId());
		if (!ShoppingListRead.equals(shoppingListToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (shoppingListToUpdate.getUserId() == null || shoppingListToUpdate.getUserId().equals("")) {
					shoppingListToUpdate.setUserId(shoppingListRead.getUserId());
				}

        if (shoppingListToUpdate.getShoppingList() == null || shoppingListToUpdate.getShoppingList().equals("")) {
					shoppingListToUpdate.setTShoppingList(shoppingListRead.getTShoppingList());
				}

				if (shoppingListToUpdate.getTotalPrice() == null || shoppingListToUpdate.getTotalPrice().equals("")) {
					shoppingListToUpdate.setTotalPrice(shoppingListRead.getTotalPrice());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setObject(1, shoppingListToUpdate.getShoppingList());
				preparedStatement.setDouble(3, shoppingListToUpdate.getTotalPrice());
				preparedStatement.setInt(4, shoppingListToUpdate.getUserId());
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

	public boolean deleteShoppingList(Integer id) {
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
