package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.contrader.utils.GestoreEccezioni;
import it.contrader.utils.ConnectionSingleton;
import it.contrader.model.Product;

public class ProductDAO {


	private final String FIND_ALL = "select * from products";
	private final String FIND_BY_ID = "select * from products where prod_id = ?";
	private final String INSERT_QUERY = "insert into products (name, description, availability, price, category) "
			+ "values (?,?,?,?,?)";
	private final String UPDATE_QUERY = "update products set name = ?, description = ?, availability = ?, price = ?, category = ? where prod_id = ?";
	private final String DELETE_QUERY = "delete from products where prod_id = ?";

	public ProductDAO() {

	}

	public List<Product> getAllProducts() {
		List<Product> productList = new ArrayList<>();
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL);
			ResultSet resultSet = preparedStatement.executeQuery();
			Product product;
			while (resultSet.next()) {
				int prodId = resultSet.getInt("prod_id"); 
				product = createProduct(resultSet);
				product.setProdId(prodId);
				productList.add(product);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}

	public Product findById(int prodId) {
		Connection connection = ConnectionSingleton.getInstance();

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
			preparedStatement.setInt(1, prodId);
			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				Product product = createProduct(resultSet);
				product.setProdId(resultSet.getInt("prod_id")); 
				return product;
			} else
				return null;
		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return null;
		}
	}

	public boolean insertProduct(Product product) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);
			preparedStatement.setString(1, product.getName());
			preparedStatement.setString(2, product.getDescription());
			preparedStatement.setInt(3, product.getAvailability());
			preparedStatement.setDouble(4, product.getPrice());
			preparedStatement.setString(5, product.getCategory());
			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows > 0)
				return true;
			else
				return false;

		} catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}

	public boolean updateProduct(Product productToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		if (productToUpdate.getProdId() == 0) {
			return false;
		}
		Product productRead = findById(productToUpdate.getProdId());
		if (!productRead.equals(productToUpdate)) {
			try {

				if (productToUpdate.getName() == null || productToUpdate.getName().equals("")) {
					productToUpdate.setName(productRead.getName());
				}

				if (productToUpdate.getDescription() == null || productToUpdate.getDescription().equals("")) {
					productToUpdate.setDescription(productRead.getDescription());
				}

				if (productToUpdate.getAvailability() == null || productToUpdate.getAvailability() <= 0) {
					productToUpdate.setAvailability(productRead.getAvailability());
				}

				if (productToUpdate.getPrice() == null || productToUpdate.getPrice() <= 0.0) {
					productToUpdate.setPrice(productRead.getPrice());
				}
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
				preparedStatement.setString(1, productToUpdate.getName());
				preparedStatement.setString(2, productToUpdate.getDescription());
				preparedStatement.setInt(3, productToUpdate.getAvailability());
				preparedStatement.setDouble(4, productToUpdate.getPrice());
				preparedStatement.setString(5, productToUpdate.getCategory());
				preparedStatement.setInt(6, productToUpdate.getProdId());
				int affectedRows = preparedStatement.executeUpdate();
				if (affectedRows > 0)
					return true;
				else
					return false;

			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}

	public boolean deleteProduct(int id) {
		Connection connection = ConnectionSingleton.getInstance();
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY);
			preparedStatement.setInt(1, id);
			int affectedRows = preparedStatement.executeUpdate();
			if (affectedRows > 0)
				return true;
			else
				return false;
		} catch (SQLException e) {
			return false;
		}
	}

	private Product createProduct(ResultSet rs) throws SQLException {
		return new Product(rs.getString("name"), 
				rs.getString("description"), rs.getInt("availability"), rs.getDouble("price"), rs.getString("category"));
	}
}
