package it.contrader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.contrader.converter.ProductConverter;
import it.contrader.dao.ProductRepository;
import it.contrader.dto.ProductDTO;
import it.contrader.model.Product;

@Service
public class ProductService extends AbstractService<Product, ProductDTO> {
	
	@Autowired
	private ProductConverter converter;
	
	@Autowired
	private ProductRepository repository;
	
	public List<ProductDTO> findByCategory(String category) {
		return converter.toDTOList(repository.findByCategory(category));
	}

}
