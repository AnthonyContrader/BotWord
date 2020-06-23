package it.contrader.view.shopping_list;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.ShoppingListController;
import it.contrader.dto.ShoppingListDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.ShoppingList;
import it.contrader.view.View;

public class ShoppingListReadView implements View {

	private ShoppingListController shoppingListsController;
	private Request request;

	public ShoppingListReadView() {
		this.shoppingListsController = new ShoppingListController();
	}

	@Override
	public void showResults(Request request) {}

	@Override
	public void showOptions() {
		int shoppingListsIdToRead;

		System.out.println("Inserisci l'ID dell'ordine:");

		try {
			shoppingListsIdToRead = Integer.parseInt(getInput());
			ShoppingListDTO shoppingListsDB = shoppingListsController.readShoppingList(shoppingListsIdToRead);

			System.out.println("Id: " + shoppingListsDB.getShoppingListId());
			System.out.println("Id utente: " + shoppingListsDB.getUserId());
			System.out.println("Lista prodotti: " + shoppingListsDB.getShoppingList());

			//Wait to show
			System.out.println("Premi un tasto per continuare");
			try {
				getInput();
			} catch (Exception e) {

			}

		} catch (Exception e) {
			System.out.println("Valore inserito errato.");
		}

	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("Product", "doControl", request);
	}
}
