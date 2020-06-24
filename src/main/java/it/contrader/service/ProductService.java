package it.contrader.service;

import java.util.List;

import it.contrader.converter.ConverterProduct;
import it.contrader.dao.ProductDAO;
import it.contrader.dto.ProductDTO;

public class ProductService implements Service<ProductDTO>{
	
	private ProductDAO prodDAO;
	
	public ProductService(){
		this.prodDAO = new ProductDAO();
	}
	
	public List<ProductDTO> getAll(){
		return ConverterProduct.toListDTO(this.prodDAO.getAllProducts());
	}
	
	public boolean insert(ProductDTO prodDTO){
		return this.prodDAO.insertProduct(ConverterProduct.toEntity(prodDTO));
	}
	
	public ProductDTO read(int prodId){
		return ConverterProduct.toDTO(this.prodDAO.findById(prodId));
	}
	
	public boolean update(ProductDTO prodDTO){
		return this.prodDAO.updateProduct(ConverterProduct.toEntity(prodDTO));
	}
	
	public boolean delete(int prodId){
		return this.prodDAO.deleteProduct(prodId);
	}	
}