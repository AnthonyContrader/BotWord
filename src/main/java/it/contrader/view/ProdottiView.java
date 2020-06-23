package it.contrader.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.ProductController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Product;

public class ProdottiView implements View {

	private ProductController productController;
	private Request request;
	private String choice;
	private static String sub_package = "product.";

	public ProdottiView() {
		this.productController = new ProductController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {

		System.out.println("\n------ Lista Prodotti -------\n");

		System.out.println("ID\tNome");
		System.out.print("------------------------------------------------------");

		List<Product> products = productController.getAllProduct();

		/*
		 * List<String> products = new ArrayList<String>(); //start debug test
		 * 
		 * products.add(0, "frigorifero"); products.add(1, "lavastoviglie");
		 */ // fine debug test

		System.out.println();
		products.forEach(product -> System.out.println(product.getProdId() + "\t" + product.getName())); // creare in
																											// model

		// stampaList(products); //test debug

		System.out.println();

		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[L]Vedi prodotto [G]estione degli ordini [E]sci");
		try {
			this.choice = getInput();
		} catch (Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "");

	}

	/*
	 * private static void stampaList(List<String>products) { //start debug test for
	 * (int i =0; i<products.size(); i++) { String item = products.get(i);
	 * System.out.println(i+"\t"+item); }
	 * 
	 * }
	 */ // fine debug test

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		if (choice.equalsIgnoreCase("L")) {

			MainDispatcher.getInstance().callView(sub_package + "UserProductRead", null);
		}
		if (choice.equalsIgnoreCase("G")) {
			MainDispatcher.getInstance().callView("ShoppingList", null);
		}
		if (choice.equalsIgnoreCase("E")) {

			MainDispatcher.getInstance().callView("Login", null);
		} else {
			Request request = new Request();
			request.put("choice", choice);
			MainDispatcher.getInstance().callAction("Login", "doControl", request);
		}
	}

}
