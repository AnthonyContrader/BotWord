package it.contrader.view.shopping_listt;

	import java.util.Scanner;
	import java.lang.*;

	import it.contrader.controller.Request;
	import it.contrader.controller.ShoppingListController;
	import it.contrader.dto.ShoppingListDTO;
  import it.contrader.model.ShoppingListItem;
	import it.contrader.main.MainDispatcher;
	import it.contrader.view.View;

	public class ShoppingListInsertView implements View {

		private ShoppingListController shoppingListsController;
		private Request request;

		public ShoppingListInsertView() {
			this.shoppingListsController = new ShoppingListController();
		}

		@Override
		public void showResults(Request request) {}

		@Override
		public void showOptions() {
			int shoppingListUserId;
      Double totalPrice;
      ArrayList<ShoppingListItem> shoppingList;
      // , productdescription, productquantity, productprice;

			System.out.println("Inserisci i campi del prodotto:");
			System.out.println("Digita l'id dell'utente ");
			shoppingListUserId = getInput();
			System.out.println("Inserisci la la lista dei prodotti");
			shoppingList = getInput();
			System.out.println("Digita il prezzo (Double 0.00): ");
			totalPrice = getInput();

			if (!shoppingListUserId.equals("") && !totalPrice.equals("") && !shoppingList.equals("")) {
				shoppingListsController.insertShoppingList(new ShoppingListDTO(Integer.parseInt(shoppingListUserId), Double.parseDouble(totalPrice), Object.parseobject(shoppingList)));
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

	}
