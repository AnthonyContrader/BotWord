package it.contrader.dto;

public class ProductDTO {
	
	private int prodId;
	private String name;
	private String description;
	private Integer quantity;
	private Double price;
	private String category;

	public ProductDTO() {
	}

	public ProductDTO(String name, String description, Integer quantity, Double price, String category) {
		this.name = name;
		this.description = description;
		this.quantity = quantity;
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
	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "ID: " + this.getProdId() + " Nome: " + this.getName() + " Descrizione: " + this.getDescription()
				+ " Quantita': " + this.getQuantity() + " Prezzo: " + this.getPrice() + " Categoria: " + this.getCategory();
	}

}
