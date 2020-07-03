package it.contrader.converter;

import org.springframework.stereotype.Component;

import it.contrader.dto.ShoppingListDTO;
import it.contrader.model.ShoppingList;

@Component
public class ShoppingListConverter extends AbstractConverter<ShoppingList, ShoppingListDTO> {

	@Override
	public ShoppingList toEntity(ShoppingListDTO shoppingListDTO) {
		ShoppingList shoppingList = null;
		if (shoppingListDTO != null) {
			shoppingList = new ShoppingList(shoppingListDTO.getId(), shoppingListDTO.getUserId(), shoppingListDTO.getProductId(), shoppingListDTO.getQuantity(),
					shoppingListDTO.getTotalPrice(), shoppingListDTO.getDate());
		}
		return shoppingList;
	}

	@Override
	public ShoppingListDTO toDTO(ShoppingList shoppingList) {
		System.out.print(shoppingList);
		ShoppingListDTO shoppingListDTO = null;
		if (shoppingList != null) {
			shoppingListDTO = new ShoppingListDTO(shoppingList.getId(), shoppingList.getUserId(), shoppingList.getProductId(), shoppingList.getQuantity(),
					shoppingList.getTotalPrice(), shoppingList.getDate());

		}
		return shoppingListDTO;
	}
}
