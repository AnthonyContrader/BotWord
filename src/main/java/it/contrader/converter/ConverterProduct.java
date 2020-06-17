package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ProductDTO;
import it.contrader.model.Product;

public class ConverterProduct {

	public static ProductDTO toDTO(Product product) {
		ProductDTO productDTO = null;
		if (product != null) {
			productDTO = new ProductDTO();
			productDTO.setProductId(product.getProductId());
			productDTO.setName(product.getName());
      productDTO.setDescription(product.getDescription());
      productDTO.setQuantity(product.getQuantity());
			productDTO.setPrice(product.getPrice());
		}
		return productDTO;
	}

	public static Product toEntity(ProductDTO productDTO) {
		Product product = null;
		if (productDTO != null) {
			user = new User();
			user.setProductId(productDTO.getProductId());
			user.setName(productDTO.getName());
      user.setDescription(productDTO.getDescription());
      user.setQuantity(productDTO.getQuantity());
			user.setPrice(productDTO.getPrice());
		}
		return product;
	}

	public static List<ProductDTO> toListDTO(List<Product> list) {
		List<ProductDTO> listProductDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (Product product : list) {
				listProductDTO.add(ConverterProduct.toDTO(product));
			}
		}
		return listProductDTO;
	}

	public static List<Product> toListEntity(List<ProductDTO> listProductDTO) {
		List<Product> list = new ArrayList<>();
		if (!listProductDTO.isEmpty()) {
			for (ProductDTO productDTO : listProductDTO) {
				list.add(ConverterProduct.toEntity(productDTO));
			}
		}
		return list;
	}
}
