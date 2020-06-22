package it.contrader.view.product;

	import java.util.Scanner;
	import java.lang.*;
	
	import it.contrader.controller.Request;
	import it.contrader.controller.ProductController;
	import it.contrader.dto.ProductDTO;
	import it.contrader.main.MainDispatcher;
	import it.contrader.view.View;

	public class ProductInsertView implements View {

		private ProductController productsController;
		private Request request;

		public ProductInsertView() {
			this.productsController = new ProductController();
		}

		@Override
		public void showResults(Request request) {
		}

		@Override
		public void showOptions() {
			String productname, productdescription, productquantity, productprice, productCategory;

			System.out.println("Inserisci i campi del prodotto:");
			System.out.println("Digita il nome: ");
			productname = getInput();
			System.out.println("Inserisci la descrizione articolo prodotto");
			productdescription = getInput();
			System.out.println("Digita il prezzo (Double 0.00): ");
			productprice = getInput();
			System.out.println("Inserisci la disponibilita del prodotto");
			productquantity = getInput();
			System.out.println("Inserisci la categoria del prodotto");
			productCategory = getInput();
			
			if (!productname.equals("") && !productdescription.equals("") && !productprice.equals("") && !productquantity.equals("")) {
				productsController.insertProduct(new ProductDTO(productname, productdescription, Integer.parseInt(productquantity), Double.parseDouble(productprice), productCategory));
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

