package it.contrader.servlets;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.contrader.converter.ConverterStringToJson;
import it.contrader.dto.ShoppingListDTO;
import it.contrader.service.Service;
import it.contrader.service.ShoppingListService;

public class ShoppingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShoppingListServlet() {
	}

	public void updateList(HttpServletRequest request) {
		Service<ShoppingListDTO> service = new ShoppingListService();
		List<ShoppingListDTO> listDTO = service.getAll();
		request.setAttribute("list", listDTO);
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Service<ShoppingListDTO> service = new ShoppingListService();
		String mode = request.getParameter("mode");
		ShoppingListDTO dto;
		int id;
		boolean ans;

		switch (mode.toUpperCase()) {

		case "SHOPPINGLISTLIST":
			updateList(request);
			getServletContext().getRequestDispatcher("/shoppinglist/shoppingListManager.jsp").forward(request,
					response);
			break;

		case "READ":
			id = Integer.parseInt(request.getParameter("id"));
			dto = service.read(id);
			request.setAttribute("dto", dto);

			if (request.getParameter("update") == null) {
				getServletContext().getRequestDispatcher("/shoppinglist/readShoppingList.jsp").forward(request,
						response);

			}

			else
				getServletContext().getRequestDispatcher("/shoppinglist/updateShoppingList.jsp").forward(request,
						response);

			break;

		case "INSERT":
			String userId = request.getParameter("userId").toString();
			String shoppingList = request.getParameter("shoppingList").toString();
			String totalPrice = request.getParameter("totalPrice").toString();
			dto = new ShoppingListDTO(Integer.parseInt(userId), ConverterStringToJson.toJsonObject(shoppingList), Double.parseDouble(totalPrice));
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/shoppinglist/shoppingListManager.jsp").forward(request,
					response);
			break;

		case "UPDATE":
			userId = request.getParameter("userId");
			shoppingList = request.getParameter("shoppingList");
			totalPrice = request.getParameter("totalPrice");
			id = Integer.parseInt(request.getParameter("id"));
			dto = new ShoppingListDTO(Integer.parseInt(userId), ConverterStringToJson.toJsonObject(shoppingList), Double.parseDouble(totalPrice));
			dto.setShoppingListId(id);
			ans = service.update(dto);
			updateList(request);
			getServletContext().getRequestDispatcher("/shoppinglist/shoppingListManager.jsp").forward(request,
					response);
			break;

		case "DELETE":
			id = Integer.parseInt(request.getParameter("id"));
			ans = service.delete(id);
			request.setAttribute("ans", ans);
			updateList(request);
			getServletContext().getRequestDispatcher("/shoppinglist/shoppingListManager.jsp").forward(request,
					response);
			break;
		}
	}
}
