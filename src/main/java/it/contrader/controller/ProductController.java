package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.ProductDTO;
import it.contrader.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService service;

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "product/productlist";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "product/readproduct";
	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("availability") Integer availability,
			@RequestParam("price") Double price, @RequestParam("category") String category) {
		ProductDTO prodDto = new ProductDTO();
		prodDto.setName(name);
		prodDto.setDescription(description);
		prodDto.setAvailability(availability);
		prodDto.setPrice(price);
		prodDto.setCategory(category);
		service.insert(prodDto);
		setAll(request);
		return "product/productlist";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "product/updateproduct";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("name") String name,
			@RequestParam("description") String description, @RequestParam("availability") Integer availability,
			@RequestParam("price") Double price, @RequestParam("category") String category) {
		ProductDTO prodDto = new ProductDTO();
		prodDto.setId(id);
		prodDto.setName(name);
		prodDto.setDescription(description);
		prodDto.setAvailability(availability);
		prodDto.setPrice(price);
		prodDto.setCategory(category);
		service.update(prodDto);
		setAll(request);
		return "product/productlist";
	}
	
	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "product/productlist";
	}
	
	@GetMapping("/category")
	public String readCategory(HttpServletRequest request, @RequestParam("category") String category) {
		request.getSession().setAttribute("listdto", service.findByCategory(category));
		return "product/readproductcategory";
	}

	private void setAll(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.setAttribute("productlist", service.getAll());
	}
}
