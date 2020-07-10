package it.contrader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.ShoppingListDTO;
import it.contrader.service.ShoppingListService;

@RestController
@RequestMapping("/shoppinglist")
@CrossOrigin(origins = "http://localhost:4200")
public class ShoppingListController extends AbstractController<ShoppingListDTO> {
	
	@Autowired
	private ShoppingListService slService;
	
	@GetMapping(value="/getbyuserid/{userId}")
	public List<ShoppingListDTO> getShopListByUserId(@PathVariable(value = "userId") Long userId){
		return slService.findByUserId(userId);
		
	}

}
