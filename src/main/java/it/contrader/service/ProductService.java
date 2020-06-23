package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterProduct;
import it.contrader.dao.ProductDAO;
import it.contrader.dto.ProductDTO;
import it.contrader.model.Product;

public class ProductService {
	
	private ProductDAO prodDAO;
	
	public ProductService(){
		this.prodDAO = new ProductDAO();
	}
	
	public List<Product> getAllProduct(){
		return this.prodDAO.getAllProducts();
	}
	
	public boolean insertProduct(ProductDTO prodDTO){
		return this.prodDAO.insertProduct(ConverterProduct.toEntity(prodDTO));
	}
	
	public ProductDTO findByID(int prodId){
		return ConverterProduct.toDTO(this.prodDAO.findById(prodId));
	}
	
	public boolean updateProduct(ProductDTO prodDTO){
		return this.prodDAO.updateProduct(ConverterProduct.toEntity(prodDTO));
	}
	
	public boolean deleteProduct(int prodId){
		return this.prodDAO.deleteProduct(prodId);
	}	
}