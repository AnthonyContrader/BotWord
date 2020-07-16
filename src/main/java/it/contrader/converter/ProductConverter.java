package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ProductDTO;
import it.contrader.model.Product;

@Component
public class ProductConverter extends AbstractConverter<Product, ProductDTO> {

	@Override
	public Product toEntity(ProductDTO prodDto) {
		Product prod = null;
		if(prodDto != null) {
			prod = new Product(prodDto.getId(),prodDto.getName(), 
					prodDto.getDescription(),
					prodDto.getAvailability(),
					prodDto.getPrice(),
					prodDto.getCategory()
					);
		}
		return prod;
	}

	@Override
	public ProductDTO toDTO(Product prod) {
		ProductDTO prodDto = null;
		if(prod != null) {
			prodDto = new ProductDTO(prod.getId(), prod.getName(),
					prod.getDescription(),
					prod.getAvailability(),
					prod.getPrice(),
					prod.getCategory()
					);
		}
		return prodDto;
	}

}
