package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ShoppingListDTO;
import it.contrader.service.ShoppingListService;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/shoppinglist")
public class ShoppingListController {

	@Autowired
	private ShoppingListService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "shopping_list/shoppinglists";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "shopping_list/shoppinglists";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "shopping_list/updateshoppinglist";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("userId") Long userId,
			@RequestParam("productId") Long productId, @RequestParam("quantity") Integer quantity, @RequestParam("totalPrice") Double totalPrice) {

		ShoppingListDTO dto = new ShoppingListDTO();
		dto.setUserId(userId);
		dto.setProductId(productId);
		dto.setQuantity(quantity);
		dto.setTotalPrice(totalPrice);
		dto.setDate(new Date());
		service.update(dto);
		setAll(request);
		return "shopping_list/shoppinglists";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("userId") Long userId,
			@RequestParam("productId") Long productId, @RequestParam("quantity") int quantity, @RequestParam("totalPrice") Double totalPrice) {
		
		ShoppingListDTO dto = new ShoppingListDTO();
		dto.setUserId(userId);
		dto.setProductId(productId);
		dto.setQuantity(quantity);
		dto.setTotalPrice(totalPrice);
		dto.setDate(new Date());
		service.insert(dto);
		setAll(request);
		return "shopping_list/shoppinglists";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "shopping_list/readshoppinglist";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
