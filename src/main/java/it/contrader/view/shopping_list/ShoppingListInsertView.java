package it.contrader.view.shopping_list;

import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.contrader.controller.Request;
import it.contrader.controller.ShoppingListController;
import it.contrader.dto.ShoppingListDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class ShoppingListInsertView implements View {

	private ShoppingListController shoppingListsController;
	private Request request;

	public ShoppingListInsertView() {
		this.shoppingListsController = new ShoppingListController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String shoppingListUserId;
		String totalPrice;
		String shoppingList;

		System.out.println("Inserisci i campi del carrello:");
		System.out.println("Digita l'id dell'user ");
		shoppingListUserId = getInput();
		System.out.println("Inserisci la la lista dei prodotti");
		shoppingList = getInput();
		System.out.println("Digita il prezzo totale (Double 0.00): ");
		totalPrice = getInput();

		if (!shoppingListUserId.equals("") && !totalPrice.equals("") && !shoppingList.equals("")) {
			shoppingListsController.insertShoppingList(new ShoppingListDTO(Integer.parseInt(shoppingListUserId),
					toJsonObject(shoppingList), Double.parseDouble(totalPrice)));
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
		MainDispatcher.getInstance().callAction("ShoppingList", "doControl", request);
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
