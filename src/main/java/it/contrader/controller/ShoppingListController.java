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

import java.util.Date;

@Controller
@RequestMapping("/shoppinglist")
public class ShoppingListController {

	@Autowired
	private ShoppingListService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "shoppinglists";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "shoppinglists";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updateshoppinglist";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("userId") Long userId,
			@RequestParam("productId") Long productId, @RequestParam("quantity") int quantity, @RequestParam("totalPrice") Double totalPrice, @RequestParam("date") Date date) {

		ShoppingListDTO dto = new ShoppingListDTO();
		dto.setUserId(userId);
		dto.setProductId(productId);
		dto.setQuantity(quantity);
		dto.setTotalPrice(totalPrice);
		dto.setDate(date);
		service.update(dto);
		setAll(request);
		return "shoppinglists";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("userId") Long userId,
			@RequestParam("productId") Long productId, @RequestParam("quantity") int quantity, @RequestParam("totalPrice") Double totalPrice, @RequestParam("date") Date date) {
		ShoppingListDTO dto = new ShoppingListDTO();
		dto.setUserId(userId);
		dto.setProductId(productId);
		dto.setQuantity(quantity);
		dto.setTotalPrice(totalPrice);
		dto.setDate(date);
		service.insert(dto);
		setAll(request);
		return "shoppinglists";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readshoppinglist";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
