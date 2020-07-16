package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ProductDTO;
import it.contrader.model.Product;

@Component
public class ProductConverter extends AbstractConverter<Product, ProductDTO> {

	@Override
	public Product toEntity(ProductDTO dto) {
		Product prod = null;
		if (dto != null) {
			prod = new Product(dto.getId(), dto.getName(), dto.getDescription(),  dto.getAvailability(), dto.getPrice(),
					dto.getCategory());
		}
		return prod;
	}

	@Override
	public ProductDTO toDTO(Product entity) {
		ProductDTO dto = null;
		if (entity != null) {
			dto = new ProductDTO(entity.getId(), entity.getName(), entity.getDescription(), entity.getAvailability(),
					entity.getPrice(), entity.getCategory());
		}
		return dto;
	}

}
