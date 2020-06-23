package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ShoppingListDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.ShoppingList;
import it.contrader.service.ShoppingListService;

public class ShoppingListController implements Controller {

	private static String sub_package = "shopping_list.";
	private ShoppingListService shoppingListsService;
	private Request request;

	public ShoppingListController() {
		this.shoppingListsService = new ShoppingListService();
	}

	public List<ShoppingList> getAllShoppingList() {
		return this.shoppingListsService.getAllShoppingList();
	}

	public ShoppingListDTO readShoppingList(int shoppingListId) {
		return this.shoppingListsService.readShoppingList(shoppingListId);
	}

	public boolean insertShoppingList(ShoppingListDTO shoppingListsDTO) {
		return this.shoppingListsService.insertShoppingList(shoppingListsDTO);
	}

	public boolean updateShoppingList(ShoppingListDTO shoppingListsDTO) {
		return this.shoppingListsService.updateShoppingList(shoppingListsDTO);
	}

	public boolean deleteShoppingList(Integer shoppingListsId) {
		return this.shoppingListsService.deleteShoppingList(shoppingListsId);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("ShoppingList", null);
		} else {
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "ShoppingListRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "ShoppingListInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "ShoppingListUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "ShoppingListDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

}
