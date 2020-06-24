package it.contrader.main;

import it.contrader.dao.ProductDAO;
import it.contrader.model.Product;

public class Prova {

	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		Product prod = new Product();
		prod.setCategory("c");
		prod.setProdId(1);
		prod.setName("n");
		prod.setDescription("d");
		prod.setPrice(3.0);
		prod.setQuantity(2);
		dao.updateProduct(prod);
	}

}
