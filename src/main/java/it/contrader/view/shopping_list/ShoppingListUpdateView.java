package it.contrader.view.shopping_list;

import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.contrader.controller.Request;
import it.contrader.controller.ShoppingListController;
import it.contrader.dto.ShoppingListDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.ShoppingList;
import it.contrader.view.View;

public class ShoppingListUpdateView implements View {

	private ShoppingListController shoppingListsController;
	private Request request;

	public ShoppingListUpdateView() {
		this.shoppingListsController = new ShoppingListController();
	}

	@Override
	public void showResults(Request request) {}

	@Override
	public void showOptions() {
		int shoppingListIdToUpdate;
    String totalPrice;
    String shoppingList;

		System.out.println("\n----- Seleziona l'ordine da modificate  -----\n");

		ShoppingListDTO shoppingListDTO = new ShoppingListDTO();

		System.out.println("Digita l'Id dell'ordine da modificare:");
		try {
			shoppingListIdToUpdate = Integer.parseInt(getInput());
			if (shoppingListIdToUpdate != 0) {
				shoppingListDTO.setShoppingListId(shoppingListIdToUpdate);
				
				System.out.println("Digita il nuovo User ID: ");
				String userId = getInput();
				shoppingListDTO.setUserId(Integer.parseInt(userId));

        System.out.println("Digita la nuova lista dei prodotti:");
        shoppingList = getInput();
        if (!shoppingList.equals("")) {
        	JSONObject json = toJsonObject(shoppingList);
        shoppingListDTO.setShoppingList(json);
        }

				System.out.println("Digita il nuovo prezzo dell'ordine:");
				totalPrice = getInput();
				if (!totalPrice.equals(""))
					shoppingListDTO.setTotalPrice(Double.parseDouble(totalPrice));

				shoppingListsController.updateShoppingList(shoppingListDTO);

			}
		} catch (Exception e) {
			e.printStackTrace();
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
