ackage it.contrader.view;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.ShoppingListController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.ShoppingList;

public class ShoppingListView implements View {

	private ShoppingListController shoppingListsController;
	private Request request;
	private String choice;

	public UserView() {
		this.shoppingListsController = new ShoppingListController();
	}

	@Override
	public void showResults(Request request) {}

	@Override
	public void showOptions() {

		System.out.println("\n------ Gestione Ordini -------\n");

		System.out.println("ID\tUserId\tPrezzoTotale\tListaProdotti");
		System.out.print("------------------------------------------------------");
		List<ShoppingList> shoppingLists = shoppingListsController.getAllShoppingList();
		System.out.println();
		users.forEach(shoppingList -> System.out.println(shoppingList.toString()));
		System.out.println();

		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[L]eggi [I]nserisci [M]odifica [C]ancella [E]sci");
		try {
			this.choice = getInput();
		} catch(Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "");
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		    MainDispatcher.getInstance().callAction("User", "doControl", this.request);
	}
}
