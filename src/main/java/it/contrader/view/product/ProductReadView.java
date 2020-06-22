package it.contrader.view.product;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.ProductController;
import it.contrader.dto.ProductDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Product;
import it.contrader.view.View;

public class ProductReadView implements View {

	private ProductController productsController;
	private Request request;

	public ProductReadView() {
		this.productsController = new ProductController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int productsIdToRead;

		System.out.println("Inserisci l'ID del prodotto:");

		try {
			productsIdToRead = Integer.parseInt(getInput());
			ProductDTO productsDB = productsController.readProduct(productsIdToRead);

			System.out.println("Id: " + productsDB.getProdId());
			System.out.println("nome: " + productsDB.getName());
			System.out.println("descrizione: " + productsDB.getDescription());
			System.out.println("categoria: " + productsDB.getCategory());
			
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
