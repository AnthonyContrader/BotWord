package it.contrader.dto;

public class ProductDTO {
	
	private int prodId;
	private String name;
	private String description;
	private Integer availability;
	private Double price;
	private String category;

	public ProductDTO() {
	}

	public ProductDTO(String name, String description, Integer availability, Double price, String category) {
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
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ID: " + this.getProdId() + " Nome: " + this.getName() + " Descrizione: " + this.getDescription()
				+ " Quantita': " + this.getAvailability() + " Prezzo: " + this.getPrice() + " Categoria: " + this.getCategory();
	}

}
