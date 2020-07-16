package it.contrader.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.contrader.dao.ProductRepository;
import it.contrader.dto.ProductDTO;
import it.contrader.model.Product;

@Service
public class ProductService extends AbstractService<Product, ProductDTO> {
	
	//CRUD methods ok
	
	public List<ProductDTO> findByCategory(String category){
		return converter.toDTOList(((ProductRepository) repository).findByCategory(category));

	}

}
