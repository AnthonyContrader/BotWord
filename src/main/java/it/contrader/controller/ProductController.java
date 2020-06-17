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

	public List<Product> getAllProduct() {
		return this.productsService.getAllProduct();
	}

	public ProductDTO readProduct(int prodId) {
		return this.productsService.findByID(prodId);
	}

	public boolean insertProduct(ProductDTO productsDTO) {
		return this.productsService.insertProduct(productsDTO);
	}

	public boolean updateProduct(ProductDTO productsDTO) {
		return this.productsService.updateProduct(productsDTO);
	}

	public boolean deleteProduct(Integer productsId) {
		return this.productsService.deleteProduct(productsId);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("Product", null);
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
			}
		}
	}

}
