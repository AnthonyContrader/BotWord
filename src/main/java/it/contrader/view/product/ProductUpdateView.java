package it.contrader.view.product;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.ProductController;
import it.contrader.dto.ProductDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class ProductUpdateView implements View {

	private ProductController productsController;
	private Request request;

	public ProductUpdateView() {
		this.productsController = new ProductController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int productIdToUpdate;
		String upname, updescription, upprice, upquantity;

		/*
		 * List<Product> products; Integer productsId; String description; products =
		 * productsController.getAllProduct();
		 */
		System.out.println("\n----- Seleziona il prodotto da modificate  -----\n");
		// System.out.println();
		// products.forEach(.... -> System.out.println(....toString()));
		// System.out.println();
		ProductDTO productDTO = new ProductDTO();

		System.out.println("Digita l'Id del prodotto da modificare:");
		try {
			productIdToUpdate = Integer.parseInt(getInput());
			if (productIdToUpdate != 0) {
				productDTO.setProdId(productIdToUpdate);

				System.out.println("Digita il nuovo nome del prodotto:");
				upname = getInput();
				if (!upname.equals(""))
					productDTO.setName(upname);

				System.out.println("Digita la nuova descrizione del prodotto:");
				updescription = getInput();
				if (!updescription.equals(""))
					productDTO.setDescription(updescription);

				System.out.println("Digita la nuova quantita' del prodotto:");
				upquantity = getInput();
				if (!upquantity.equals(""))
					productDTO.setQuantity(Integer.parseInt(upquantity));

				System.out.println("Digita il nuovo prezzo del prodotto:");
				upprice = getInput();
				if (!upprice.equals(""))
					productDTO.setPrice(Double.parseDouble(upprice));

				productsController.updateProduct(productDTO);

			}
		} catch (Exception e) {
			// System.out.println("Hai inserito un valore errato");
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
		MainDispatcher.getInstance().callAction("Product", "doControl", request);
	}

}
