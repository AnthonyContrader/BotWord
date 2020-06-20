package it.contrader.view.shopping_list;


import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.ShoppingListController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.ShoppingList;
import it.contrader.view.View;

public class ShoppingListDeleteView implements View {

	private ShoppingListController shoppingListController;
	private Request request;

	public ShoppingListDeleteView() {
		this.shoppingListController = new ShoppingListController();
	}

	@Override
	public void showResults(Request request) {}

	@Override
	public void showOptions() {
		System.out.println("Seleziona l'ordine da cancellare: ");

		System.out.println("Digita l'ID:");
		String shoppingListId = getInput();

		if (shoppingListId != null && StringUtils.isStrictlyNumeric(shoppingListId)) {
			shoppingListController.deleteShoppingList(Integer.parseInt(shoppingListId));

		} else {
			System.out.println("Valore inserito errato");
		}
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("ShoppingList", "doControl", request);
	}
}
