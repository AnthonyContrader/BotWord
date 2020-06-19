package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ShoppingListbDTO;
import it.contrader.model.ShoppingList;

public class ConverterShoppingList {

	public static ShoppingListDTO toDTO(ShoppingList shoppingList) {
		ShoppingListDTO shoppingListDTO = null;
		if (shoppingList != null) {
			shoppingListDTO = new ShoppingListDTO();
			shoppingListDTO.setShoppingListId(shoppingList.getShoppingListId());
			shoppingListDTO.setShoppingListUserId(shoppingList.getShoppingListUserId());
      shoppingListDTO.setShoppingListTotalPrice(shoppingList.getShoppingListTotalPrice());
			shoppingListDTO.setShoppingListShoppingList(shoppingList.getShoppingListShoppingList());
		}
		return shoppingListDTO;
	}

	public static ShoppingList toEntity(ShoppingListDTO shoppingListDTO) {
		ShoppingList shoppingList = null;
		if (shoppingListDTO != null) {
			shoppingList = new ShoppingList();
      shoppingListDTO.setShoppingListId(shoppingList.getShoppingListId());
			shoppingListDTO.setShoppingListUserId(shoppingList.getShoppingListUserId());
      shoppingListDTO.setShoppingListTotalPrice(shoppingList.getShoppingListTotalPrice());
			shoppingListDTO.setShoppingListShoppingList(shoppingList.getShoppingListShoppingList());
		}
		return shoppingList;
	}

	public static List<ShoppingListDTO> toListDTO(List<ShoppingList> list) {
		List<ShoppingListDTO> listShoppingListDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (ShoppingList shoppingList : list) {
				listUserDTO.add(ConverterUser.toDTO(shoppingList));
			}
		}
		return listShoppingListDTO;
	}

	public static List<ShoppingList> toListEntity(List<ShoppingListDTO> listShoppingListDTO) {
		List<ShoppingList> list = new ArrayList<>();
		if (!listShoppingListDTO.isEmpty()) {
			for (ShoppingListDTO shoppingListDTO : listShoppingListDTO) {
				list.add(ConverterUser.toEntity(shoppingListDTO));
			}
		}
		return list;
	}
}
