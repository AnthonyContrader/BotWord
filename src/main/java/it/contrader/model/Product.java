package it.contrader.model;

public class Product {

	private int prodId;
	private String name;
	private String description;
	private Integer quantity;
	private Double price;

	public Product() {
	}

	public Product(String name, String description, Integer quantity, Double price) {
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.price = price;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ID: " + this.getProdId() + "Nome: " + this.getName() + "Descrizione: " + this.getDescription()
				+ "Quantit�: " + this.getQuantity() + "Prezzo: " + this.getPrice() + " �";
	}

	public boolean equals(Product prodCompare) {
		if (!this.getName().equals(prodCompare.getName()))
			return false;
		if (!this.getDescription().equals(prodCompare.getDescription()))
			return false;
		if (!this.getQuantity().equals(prodCompare.getQuantity()))
			return false;
		if (!this.getPrice().equals(prodCompare.getPrice()))
				return false;

		return true;
	}
}
