package it.contrader.model;

public class ShoppingList {
	private int shopListId;
	private int userId;
  private ArrayList<ShoppingItem> shoppingList = new ArrayList<>();
  private Double totalPrice;

	public ShoppingList() {}

	public ShoppingList(int userId, ArrayList<ShoppingItem> shoppingList, Double totalPrice) {
		this.userId = userId;
    this.shoppingList = shoppingList;
    this.totalPrice = totalPrice;
	}
  
  // shoppingList.add( new ShoppingItem( "Macbook Pro", 100000L ) );

  public void setUserId(int userId){
    this.userId = userId;
  }

  public int getUserId(){
    return userId;
  }

  public void setShoppingList(ArrayList<ShoppingItem> shoppingList){
    this.shoppingList = shoppingList;
  }

  public ArrayList<ShoppingItem> getShoppingList(){
    return shoppingList;
  }

  public void setTotalPrice(Double totalPrice){
    this.totalPrice = totalPrice;
  }

  public Double getTotalPrice(){
    return totalPrice;
  }
}
