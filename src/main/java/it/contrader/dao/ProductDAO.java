package it.contrader.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.contrader.controller.GestoreEccezioni;
import it.contrader.main.ConnectionSingleton;
import it.contrader.model.Product;

public class ProductDAO {

	// VERIFICARE NOME TABELLA E TUTTI I CAMPI, IO LI STO IPOTIZZANDO

	private final String FIND_ALL = "select * from products";
	private final String FIND_BY_ID = "select * from products where prod_id = ?";
	private final String INSERT_QUERY = "insert into products (name, decription, quantity, price) "
			+ "values (?,?,?,?)";
	private final String UPDATE_QUERY = "update products set name = ?, description = ?, quantity = ?, price = ?";
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
				int prodId = resultSet.getInt("prod_id"); // controllare campi tabella
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
			
			if(resultSet.next()) {
			Product	product = createProduct(resultSet);
			product.setProdId(resultSet.getInt("prod_id")); // controllare campi	
			return product;
			}
			else 
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
			preparedStatement.setInt(3, product.getQuantity());
			preparedStatement.setDouble(4, product.getPrice());
			return true;
		}
		catch (SQLException e) {
			GestoreEccezioni.getInstance().gestisciEccezione(e);
			return false;
		}
	}
	
	public boolean updateProduct(Product productToUpdate) {
		Connection connection = ConnectionSingleton.getInstance();
		if(productToUpdate.getProdId() == 0) {
			return false;
		}
		Product productRead = findById(productToUpdate.getProdId());
		if(!productRead.equals(productToUpdate)) {
			try {
				
				if (productToUpdate.getName() == null || productToUpdate.getName().equals("")) {
					productToUpdate.setName(productRead.getName());
				}
				
				if (productToUpdate.getDescription() == null || productToUpdate.getDescription().equals("")) {
					productToUpdate.setDescription(productRead.getDescription());
				}
				
				if(productToUpdate.getQuantity() <= 0) {
					productToUpdate.setQuantity(productRead.getQuantity());
				}
				
				if(productToUpdate.getPrice() <= 0.0) {
					productToUpdate.setPrice(productRead.getPrice());
				}
				PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_QUERY);
				preparedStatement.setString(1, productToUpdate.getName());
				preparedStatement.setString(2, productToUpdate.getDescription());
				preparedStatement.setInt(3, productToUpdate.getQuantity());
				preparedStatement.setDouble(4, productToUpdate.getPrice());
				int affectedRows = preparedStatement.executeUpdate();
				if(affectedRows > 0)
					return true;
				else
					return false;
				
			} catch (SQLException e) {
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
			if(affectedRows > 0) 
				return true;
			else 
				return false;
		} catch (SQLException e) {
			return false;
		}
	}


	private Product createProduct(ResultSet rs) throws SQLException {
		return new Product(rs.getString("name"), // controllare i campi
				rs.getString("description"), 
				rs.getInt("quantity"), 
				rs.getDouble("price"));
	}
}
