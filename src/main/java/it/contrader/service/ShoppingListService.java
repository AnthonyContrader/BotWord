package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterShoppingList;
import it.contrader.dao.ShoppingListDAO;
import it.contrader.dto.ShoppingListDTO;
import it.contrader.model.ShoppingList;

public class ShoppingListService {

	private ShoppingListDAO shoppingListDAO;

	public ShoppingListService() {
		this.shoppingListDAO = new ShoppingListDAO();
	}

	public List<ShoppingList> getAllShoppingList() {
		return this.shoppingListDAO.getAllShoppingLists();
	}

	public boolean insertShoppingList(ShoppingListDTO shoppingListDTO) {
		return this.shoppingListDAO.insertShoppingList(ConverterShoppingList.toEntity(shoppingListDTO));
	}

	public ShoppingListDTO readShoppingList(int shoppingListId) {
		return ConverterShoppingList.toDTO(this.shoppingListDAO.readShoppingList(shoppingListId));
	}

	public boolean updateShoppingList(ShoppingListDTO shoppingListDTO) {
		return this.shoppingListDAO.updateShoppingList(ConverterShoppingList.toEntity(shoppingListDTO));
	}

	public boolean deleteShoppingList(int shoppingListId) {
		return this.shoppingListDAO.deleteShoppingList(shoppingListId);
	}
}
