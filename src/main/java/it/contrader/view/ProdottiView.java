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
		
		List<Product> products = productController.getAllProduct(); // generare in controller,service e model...
		
	/*	List<String> products = new ArrayList<String>(); //start test
		
		products.add(0, "frigorifero");
		products.add(1, "lavastoviglie");*/ //fine test
		
		
		System.out.println();
		products.forEach(product -> System.out.println(product.toString())); // creare in model
		//stampaList(products); //test
		
		System.out.println();
		
		System.out.println("Scegli l'operazione da effettuare:");
		System.out.println("[L]Vedi prodotto [E]sci");
		try {
			this.choice = getInput();
		} catch(Exception e) {
			this.choice = "";
		}
		request = new Request();
		request.put("choice", choice);
		request.put("mode", "");
	
	}
	
/*	private static void stampaList(List<String>products) {  //start test
		for (int i =0; i<products.size(); i++)
		{
			String item = products.get(i);
			System.out.println(i+"\t"+item);
		}
		
	}*/  //fine test
                                                      
	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		if (choice.equalsIgnoreCase("P")||choice.equalsIgnoreCase("E")) {
			
			MainDispatcher.getInstance().callAction("Product", "doControl", this.request);
	        }
	
	}

}
