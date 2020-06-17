package it.contrader.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
//import it.contrader.controller.ProductController; //da sviluppare
import it.contrader.main.MainDispatcher;
//import it.contrader.model.Product; // da generare

public class ProdottiView implements View {

 	//private ProductController productController; // generare la classe ProductController
	private Request request;
	private String choice;
	
	public ProdottiView() {
		//this.productController = new ProductController();// generare la classe ProductController
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		
		System.out.println("\n------ Lista Prodotti -------\n");
		
		System.out.println("ID\tNome");
		System.out.print("------------------------------------------------------");
		
		//List<Product> products = productController.getAllProduct(); // generare in controller,service e model...
		
		List<String> products = new ArrayList<String>();
		
		products.add(0, "frigorifero");
		products.add(1, "lavastoviglie");
		
		
		System.out.println();
		//products.forEach(product -> System.out.println(product.toString())); // creare in model
		stampaList(products);
		
		System.out.println();
		
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[codice]Vedi prodotto [E]sci");
		try {
			this.choice = getInput();
		} catch(Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "");
	
	}
	
	private static void stampaList(List<String>products) {
		for (int i =0; i<products.size(); i++)
		{
			String item = products.get(i);
			System.out.println(i+"\t"+item);
		}
		
	}
                                                      
	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		    //MainDispatcher.getInstance().callAction("Product", "doControl", this.request);
	}

}
