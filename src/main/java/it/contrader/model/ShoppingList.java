package it.contrader.model;

import org.json.simple.JSONObject;

public class ShoppingList {
	public int getShopListId() {
		return shopListId;
	}

	public void setShopListId(int shopListId) {
		this.shopListId = shopListId;
	}

	private int shopListId;
	private int userId;
	private JSONObject shoppingList = new JSONObject();
	private Double totalPrice;

	public ShoppingList() {
	}

	public ShoppingList(int userId, JSONObject shoppingList, Double totalPrice) {
		this.userId = userId;
		this.shoppingList = shoppingList;
		this.totalPrice = totalPrice;
	}

	// shoppingList.add( new ShoppingItem( "Macbook Pro", 100000L ) );

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserId() {
		return userId;
	}

	public void setShoppingList(JSONObject shoppingList) {
		this.shoppingList = shoppingList;
	}

	public JSONObject getShoppingList() {
		return shoppingList;
	}

	public void setTotalPrice(Double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Double getTotalPrice() {
		return totalPrice;
	}
	
	@Override
	public String toString() {
		return "ID shopping List: " + this.getShopListId() + " Uder ID: " + this.getUserId() + " Prezzo totale: " + this.getTotalPrice()
		+ " Prodotti nel carrello: {\"ID prodotto\" : \"Quantita'\"} " + this.getShoppingList();
	}
}
