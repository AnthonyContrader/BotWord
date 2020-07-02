package it.contrader.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ShoppingListDTO {

	private Long id;

	private Long userId;

	private Long productId;

	private int quantity;

	private Double totalPrice;

	private Data date;
}
