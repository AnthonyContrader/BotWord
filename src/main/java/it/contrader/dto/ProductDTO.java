package it.contrader.dto;

public class ProductDTO {
	
	private int prodId;
	private String name;
	private String description;
	private Integer quantity;
	private Double price;

	public ProductDTO() {
	}

	public ProductDTO(String name, String description, Integer quantity, Double price) {
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
				+ "Quantità: " + this.getQuantity() + "Prezzo: " + this.getPrice() + " €";
	}

}
