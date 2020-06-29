package it.contrader.model;

public class Product {

	private int prodId;
	private String name;
	private String description;
	private Integer availability;
	private Double price;
	private String category;

	public Product() {
	}

	public Product(String name, String description, Integer availability, Double price, String category) {
		this.name = name;
		this.description = description;
		this.availability = availability;
		this.price = price;
		this.category = category;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
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

	public Integer getAvailability() {
		return availability;
	}

	public void setAvailability(Integer availability) {
		this.availability = availability;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ID: " + this.getProdId() + " Nome: " + this.getName() + " Descrizione: " + this.getDescription()
				+ " Disponibilita': " + this.getAvailability() + " Prezzo: " + this.getPrice() + " Categoria: " + this.getCategory();
	}

	public boolean equals(Product prodCompare) {
		if (!this.getName().equals(prodCompare.getName()))
			return false;
		if (!this.getDescription().equals(prodCompare.getDescription()))
			return false;
		if (!this.getAvailability().equals(prodCompare.getAvailability()))
			return false;
		if (!this.getPrice().equals(prodCompare.getPrice()))
				return false;
		if(!this.getCategory().equals(prodCompare.getCategory()))
			return false;

		return true;
	}
}
