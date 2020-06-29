package it.contrader.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.ShoppingList;

public class ShoppingListDAO {

	private final String QUERY_ALL = "select * from shopping_lists";
	private final String QUERY_INSERT = "insert into shopping_lists (user_id, total_price, shopping_list) values (?,?, ?)";
	private final String QUERY_READ = "select * from shopping_lists where shopping_list_id=?";

	private final String QUERY_UPDATE = "UPDATE shopping_lists SET user_id = ?, total_price=?, shopping_list=? WHERE shopping_list_id=?";
	private final String QUERY_DELETE = "delete from shopping_lists where shopping_list_id=?";
	private final String FIND_BY_USERID = "select * from shopping_lists where user_id = ?";

	public ShoppingListDAO() {
	}

	public List<ShoppingList> getAllShoppingLists() {
		List<ShoppingList> shoppingsLists = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(QUERY_ALL);
			while (resultSet.next()) {
				int shoppingListId = resultSet.getInt("shopping_list_id");
				int userId = resultSet.getInt("user_id");
				Double totalPrice = resultSet.getDouble("total_price");
				String jsonString = resultSet.getString("shopping_list");
				JSONObject json = toJsonObject(jsonString);
				ShoppingList shoppingList = new ShoppingList(userId, json, totalPrice);
				shoppingList.setShopListId(shoppingListId);
				shoppingsLists.add(shoppingList);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return shoppingsLists;
	}

	public boolean insertShoppingList(ShoppingList shoppingList) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(QUERY_INSERT);
			preparedStatement.setInt(1, shoppingList.getUserId());
			preparedStatement.setDouble(2, shoppingList.getTotalPrice());
			preparedStatement.setString(3, shoppingList.getShoppingList().toString());
			int affectedRows = preparedStatement.executeUpdate();
			if(affectedRows > 0) {
			return true;
			}
			else
				return false;
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
			if(resultSet.next()) {
				String jsonString;
				int userId;
				Double price;
				userId = resultSet.getInt("user_id");
				price = resultSet.getDouble("total_price");
				jsonString = resultSet.getString("shopping_list");
				JSONObject json = toJsonObject(jsonString);
				ShoppingList shoppingList = new ShoppingList(userId, json, price);
				shoppingList.setShopListId(shoppingListId);
				return shoppingList;
			}
			else
			return null;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}

	}

	public boolean updateShoppingList(ShoppingList shoppingListToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();

		// Check if id is present
		if (shoppingListToUpdate.getShopListId() == 0)
			return false;

		ShoppingList shoppingListRead = readShoppingList(shoppingListToUpdate.getShopListId());
		if (!shoppingListRead.equals(shoppingListToUpdate)) {
			try {
				// Fill the userToUpdate object
				if (shoppingListToUpdate.getUserId() < 0) {
					shoppingListToUpdate.setUserId(shoppingListRead.getUserId());
				}

				if (shoppingListToUpdate.getShoppingList() == null || shoppingListToUpdate.getShoppingList().toString().equals("{}")) {
					shoppingListToUpdate.setShoppingList(shoppingListRead.getShoppingList());
				}

				if (shoppingListToUpdate.getTotalPrice() == null || shoppingListToUpdate.getTotalPrice() < 0.0) {
					shoppingListToUpdate.setTotalPrice(shoppingListRead.getTotalPrice());
				}

				// Update the user
				PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY_UPDATE);
				preparedStatement.setInt(1, shoppingListToUpdate.getUserId());
				preparedStatement.setDouble(2, shoppingListToUpdate.getTotalPrice());
				preparedStatement.setString(3, shoppingListToUpdate.getShoppingList().toString());
				preparedStatement.setInt(4, shoppingListToUpdate.getShopListId());
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
	
	public ShoppingList findByUserId(int userId) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_USERID);
			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				String jsonString;
				Double price;
				int shoppingListId;
				shoppingListId = resultSet.getInt("shopping_list_id");
				userId = resultSet.getInt("user_id");
				price = resultSet.getDouble("total_price");
				jsonString = resultSet.getString("shopping_list");
				JSONObject json = toJsonObject(jsonString);
				ShoppingList shoppingList = new ShoppingList(userId, json, price);
				shoppingList.setShopListId(shoppingListId);
				return shoppingList;
			}
			else
			return null;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

	public JSONObject toJsonObject(String jsonString) {
		JSONParser parser = new JSONParser();
		JSONObject json = new JSONObject();
		try {
			json = (JSONObject) parser.parse(jsonString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return json;
	}
}
