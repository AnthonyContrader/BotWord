public class ShoppingItem {
    private String name;
    private int quantity;
    private Double price;

    public ShoppingItem(String name, Double price, int quantity)
    {
        this.name = name;
        this.quantity = quantity;
        this.priceInCents = priceInCents;
    }

    public String getName(){
        return name;
    }

    public void setName( String name ){
        this.name = name;
    }

    public Double getPriceInCents(){
        return price;
    }

    public void setPriceInCents( Double price ){
        this.price = price;
    }

    public int getQuantity(){
      return quantity;
    }

    public void setQuantity(int quantity)){
      this.quantity = quantity;
    }
}
