package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
	
	private Long id;
	
	private String name;
	private String description;
	private Integer availability;
	private Double price;
	private String category;

}
