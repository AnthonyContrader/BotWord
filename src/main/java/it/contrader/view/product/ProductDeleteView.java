package it.contrader.view.product;


import java.util.List;
import java.util.Scanner;

import com.mysql.cj.util.StringUtils;

import it.contrader.controller.Request;
import it.contrader.controller.ProductController;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Product;
import it.contrader.view.View;

public class ProductDeleteView implements View {

	private ProductController productController;
	private Request request;
	private static String usertype = "Admin" ;

	public ProductDeleteView() {
		this.productController = new ProductController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		//List<Product> products = productController.getAllUser();
		//String productId;
		
		System.out.println("Seleziona il prodotto da cancellare: ");
		//System.out.println();
		//products.forEach(product -> System.out.println(product.toString()));
		//System.out.println();
		System.out.println("Digita l'ID:");
		String productId = getInput();

		if (productId != null && StringUtils.isStrictlyNumeric(productId)) {
			productController.deleteProduct(Integer.parseInt(productId));
			
		} else {
			System.out.println("Valore inserito errato");
		}
	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		request.put("userType",usertype );
		MainDispatcher.getInstance().callAction("Product", "doControl", request);
	}

}
