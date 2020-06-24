package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.dto.ProductDTO;
import it.contrader.service.ProductService;
import it.contrader.service.Service;

public class ProductsServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public ProductsServlet() {
	}
	
	public void updateList(HttpServletRequest request) {
		Service<ProductDTO> service = new ProductService();
		List<ProductDTO> listDto = service.getAll();
		request.setAttribute("list", listDto);
	}
	
	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ProductDTO> service = new ProductService();
		String mode = request.getParameter("mode");
		ProductDTO prodDto;
		int id;
		boolean ans;
		switch (mode.toUpperCase()) {
		
		case "PRODUCTSLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/product/productList.jsp").forward(request, response);
			break;
		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			prodDto = service.read(id);
			request.setAttribute("dto", prodDto);
			 getServletContext().getRequestDispatcher("/product/readProduct.jsp").forward(request, response);
			break;
		}
		
	}

}
