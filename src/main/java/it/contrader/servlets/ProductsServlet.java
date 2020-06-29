package it.contrader.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.contrader.dto.ProductDTO;
import it.contrader.dto.ShoppingListDTO;
import it.contrader.dto.UserDTO;
import it.contrader.service.ProductService;
import it.contrader.service.Service;
import it.contrader.service.IShoppingListService;
import it.contrader.service.ShoppingListService;

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
		String name, description, category;
		final HttpSession session = request.getSession();
		UserDTO userDto = (UserDTO) session.getAttribute("user");
		ProductDTO prodDto;
		IShoppingListService<ShoppingListDTO> serviceShop = new ShoppingListService();
		ShoppingListDTO slExisting = serviceShop.findByUserId(userDto.getUserId());
		session.setAttribute("ordine", slExisting);
		int id;
		boolean ans;
		if (userDto.getUsertype().equals("user")) {
			switch (mode.toUpperCase()) {

			case "PRODUCTSLIST":
				updateList(request);
				getServletContext().getRequestDispatcher("/product/productListUser.jsp").forward(request, response);
				break;
			case "READ":
				id = Integer.parseInt(request.getParameter("id"));
				prodDto = service.read(id);
				request.setAttribute("dto", prodDto);
				if (slExisting == null) {
					getServletContext().getRequestDispatcher("/product/readProductForNewOrder.jsp").forward(request,
							response);
				} else {
					request.setAttribute("dto", prodDto);
					getServletContext().getRequestDispatcher("/product/readProductForUpdateOrder.jsp").forward(request,
							response);
				}
				break;
			}
		} else if (userDto.getUsertype().equals("admin")) {
			switch (mode.toUpperCase()) {

			case "PRODUCTSLIST":
				updateList(request);
				getServletContext().getRequestDispatcher("/product/productListAdmin.jsp").forward(request, response);
				break;
			case "READ":
				id = Integer.parseInt(request.getParameter("id"));
				prodDto = service.read(id);
				request.setAttribute("dto", prodDto);
				if (request.getParameter("update") == null && slExisting == null) {
					getServletContext().getRequestDispatcher("/product/readProductForNewOrder.jsp").forward(request,
							response);
				} else {
					if (request.getParameter("update") != null)
						getServletContext().getRequestDispatcher("/product/updateProduct.jsp").forward(request,
								response);
					if (slExisting != null)
						getServletContext().getRequestDispatcher("/product/readProductForUpdateOrder.jsp")
								.forward(request, response);
				}
				break;
			case "INSERT":
				name = request.getParameter("name");
				description = request.getParameter("description");
				Integer quantity = Integer.parseInt(request.getParameter("quantity"));
				Double price = Double.parseDouble(request.getParameter("price"));
				category = request.getParameter("category");
				prodDto = new ProductDTO(name, description, quantity, price, category);
				ans = service.insert(prodDto);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/product/productListAdmin.jsp").forward(request, response);
				break;
			case "UPDATE":
				name = request.getParameter("name");
				description = request.getParameter("description");
				quantity = Integer.parseInt(request.getParameter("quantity"));
				price = Double.parseDouble(request.getParameter("price"));
				category = request.getParameter("category");
				id = Integer.parseInt(request.getParameter("id"));
				prodDto = new ProductDTO(name, description, quantity, price, category);
				prodDto.setProdId(id);
				ans = service.update(prodDto);
				updateList(request);
				getServletContext().getRequestDispatcher("/product/productListAdmin.jsp").forward(request, response);
				break;
			case "DELETE":
				id = Integer.parseInt(request.getParameter("id"));
				ans = service.delete(id);
				request.setAttribute("ans", ans);
				updateList(request);
				getServletContext().getRequestDispatcher("/product/productListAdmin.jsp").forward(request, response);
				break;
			}
		}

	}

}
