package it.contrader.controller;

import java.util.List;

import it.contrader.dto.ProductDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.Product;
import it.contrader.service.ProductService;

public class ProductController implements Controller {

	private static String sub_package = "product.";
	private ProductService productsService;
	private Request request;

	public ProductController() {
		this.productsService = new ProductService();
	}

	public List<ProductDTO> getAllProduct() {
		return this.productsService.getAll();
	}

	public ProductDTO readProduct(int prodId) {
		return this.productsService.read(prodId);
	}

	public boolean insertProduct(ProductDTO productsDTO) {
		return this.productsService.insert(productsDTO);
	}

	public boolean updateProduct(ProductDTO productsDTO) {
		return this.productsService.update(productsDTO);
	}

	public boolean deleteProduct(Integer productsId) {
		return this.productsService.delete(productsId);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");
		String tipoutente = (String) request.get("userType");
		
		System.out.println("tipo User = "+ tipoutente);

		if (mode == "menu") {
			 if (tipoutente == "Admin") 
	                MainDispatcher.getInstance().callView("ProductAdmin", null);
	           else
			        MainDispatcher.getInstance().callView("Prodotti", null);
			 
		} else {
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "ProductRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "ProductInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "ProductUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "ProductDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

}
