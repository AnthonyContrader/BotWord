package it.contrader.dto;

import org.json.simple.JSONObject;

public class ShoppingListDTO {

  private int shoppingListId;
	private int userId;
    private JSONObject shoppingList = new JSONObject();
	private Double totalPrice;

	public ShoppingListDTO() {}

	public ShoppingListDTO(int userId, JSONObject shoppingList, Double totalPrice) {
		this.userId = userId;
		this.shoppingList = shoppingList;
		this.totalPrice = totalPrice;
	}

	public int getShoppingListId() {
		return shoppingListId;
	}

	public void setShoppingListId(int shoppingListId) {
		this.shoppingListId = shoppingListId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public JSONObject getShoppingList() {
		return shoppingList;
	}

	public void setShoppingList(JSONObject shoppingList) {
		this.shoppingList = shoppingList;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		return "ID: " + this.getShoppingListId() + "User id: " + this.getUserId() + "Lista ordie: " + this.getShoppingList()
				+ "Prezzo: " + this.getTotalPrice() + " �";
	}

}
