package it.contrader.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.ProductController; 
import it.contrader.main.MainDispatcher;
import it.contrader.model.Product;

public class ProductAdminView implements View {

 	private ProductController productController;
	private Request request;
	private String choice;
	
	public ProductAdminView() {
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
		
	
		
		System.out.println();
		products.forEach(product -> System.out.println(product.toString())); // creare in model

		
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
