package it.contrader.converter;

import java.util.ArrayList;
import java.util.List;

import it.contrader.dto.ShoppingListDTO;
import it.contrader.model.ShoppingList;

public class ConverterShoppingList {

	public static ShoppingListDTO toDTO(ShoppingList shoppingList) {
		ShoppingListDTO shoppingListDTO = null;
		if (shoppingList != null) {
			shoppingListDTO = new ShoppingListDTO();
			shoppingListDTO.setShoppingListId(shoppingList.getShopListId());
			shoppingListDTO.setUserId(shoppingList.getUserId());
            shoppingListDTO.setTotalPrice(shoppingList.getTotalPrice());
			shoppingListDTO.setShoppingList(shoppingList.getShoppingList());
			shoppingListDTO.setData(shoppingList.getData());
		}
		return shoppingListDTO;
	}

	public static ShoppingList toEntity(ShoppingListDTO shoppingListDTO) {
		ShoppingList shoppingList = null;
		if (shoppingListDTO != null) {
			shoppingList = new ShoppingList();
			shoppingList.setShopListId(shoppingListDTO.getShoppingListId());;
			shoppingList.setUserId(shoppingListDTO.getUserId());
			shoppingList.setTotalPrice(shoppingListDTO.getTotalPrice());
			shoppingList.setShoppingList(shoppingListDTO.getShoppingList());
			shoppingList.setData(shoppingListDTO.getData());
		}
		return shoppingList;
	}

	public static List<ShoppingListDTO> toListDTO(List<ShoppingList> list) {
		List<ShoppingListDTO> listShoppingListDTO = new ArrayList<>();
		if (!list.isEmpty()) {
			for (ShoppingList shoppingList : list) {
				listShoppingListDTO.add(ConverterShoppingList.toDTO(shoppingList));
			}
		}
		return listShoppingListDTO;
	}

	public static List<ShoppingList> toListEntity(List<ShoppingListDTO> listShoppingListDTO) {
		List<ShoppingList> list = new ArrayList<>();
		if (!listShoppingListDTO.isEmpty()) {
			for (ShoppingListDTO shoppingListDTO : listShoppingListDTO) {
				list.add(ConverterShoppingList.toEntity(shoppingListDTO));
			}
		}
		return list;
	}
}
