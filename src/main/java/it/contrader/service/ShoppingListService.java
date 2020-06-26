package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterShoppingList;
import it.contrader.dao.ShoppingListDAO;
import it.contrader.dto.ProductDTO;
import it.contrader.dto.ShoppingListDTO;
import it.contrader.model.ShoppingList;

public class ShoppingListService implements IShoppingListService<ShoppingListDTO>{

	private ShoppingListDAO shoppingListDAO;

	public ShoppingListService() {
		this.shoppingListDAO = new ShoppingListDAO();
	}

	public List<ShoppingListDTO> getAll() {
		return ConverterShoppingList.toListDTO(this.shoppingListDAO.getAllShoppingLists()) ;
	}

	public boolean insert(ShoppingListDTO shoppingListDTO) {
		return this.shoppingListDAO.insertShoppingList(ConverterShoppingList.toEntity(shoppingListDTO));
	}

	public ShoppingListDTO read(int shoppingListId) {
		return ConverterShoppingList.toDTO(this.shoppingListDAO.readShoppingList(shoppingListId));
	}

	public boolean update(ShoppingListDTO shoppingListDTO) {
		return this.shoppingListDAO.updateShoppingList(ConverterShoppingList.toEntity(shoppingListDTO));
	}

	public boolean delete(int shoppingListId) {
		return this.shoppingListDAO.deleteShoppingList(shoppingListId);
	}
	
	public ShoppingListDTO findByUserId(int userId) {
		return ConverterShoppingList.toDTO(this.shoppingListDAO.findByUserId(userId));
	}
}
