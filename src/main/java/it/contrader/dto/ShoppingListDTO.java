package it.contrader.dto;

import org.json.simple.JSONObject;
import java.util.Date;

public class ShoppingListDTO {

  private int shoppingListId;
	private int userId;
    private JSONObject shoppingList = new JSONObject();
	private Double totalPrice;
	private Date data;

	public ShoppingListDTO() {}

	public ShoppingListDTO(int userId, JSONObject shoppingList, Double totalPrice) {
		this.userId = userId;
		this.shoppingList = shoppingList;
		this.totalPrice = totalPrice;
	}
	
	public ShoppingListDTO(int userId, JSONObject shoppingList, Double totalPrice, Date data) {
		this.userId = userId;
		this.shoppingList = shoppingList;
		this.totalPrice = totalPrice;
		this.data = data;
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
	

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ID: " + this.getShoppingListId() + "User id: " + this.getUserId() + "Lista ordine: " + this.getShoppingList()
				+ "Prezzo: " + this.getTotalPrice() + "Data ordine: " + this.getData();
	}

}
