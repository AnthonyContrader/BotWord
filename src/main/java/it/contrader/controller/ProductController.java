package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ProductDTO;
import it.contrader.service.ProductService;


@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "http://localhost:4200")
public class ProductController extends AbstractController<ProductDTO> {
	
	@Autowired
	private ProductService prodService;
	
	@GetMapping(value="/getForCategory/{category}")
	public List<ProductDTO> getProductsForCategory(@PathVariable(value = "category") String category){
		return prodService.findByCategory(category);
	}

}
