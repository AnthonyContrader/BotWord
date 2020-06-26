package it.contrader.servlets;

import java.util.List;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

import it.contrader.converter.ConverterStringToJson;
import it.contrader.dto.ShoppingListDTO;
import it.contrader.dto.UserDTO;
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
		final HttpSession session = request.getSession();
		UserDTO userDto = (UserDTO) session.getAttribute("user");
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
			Integer userId = userDto.getUserId();
			String prodID = request.getParameter("prodID").toString();
			String quantity = request.getParameter("quantity");
			String shoppingList = "{\""+ prodID +"\":\"" +quantity +"\"}";
			Double price = Double.parseDouble(request.getParameter("prezzo").toString());
			Double totalPrice = price * Double.parseDouble(quantity);
			dto = new ShoppingListDTO(userId, ConverterStringToJson.toJsonObject(shoppingList), totalPrice);
			ans = service.insert(dto);
			request.setAttribute("ans", ans);
			updateList(request);
			if(userDto.getUsertype().equals("admin"))
			getServletContext().getRequestDispatcher("/shoppinglist/shoppingListManager.jsp").forward(request,
					response);
			else {
				request.setAttribute("dto", dto);
				getServletContext().getRequestDispatcher("/shoppinglist/readShoppingListUser.jsp").forward(request,
						response);
			}
			break;

		case "UPDATE":
			//supponiamo solo aggiunta di un prodotto nuovo
			prodID = request.getParameter("prodID").toString();
			price = Double.parseDouble(request.getParameter("prezzo").toString());
			dto = (ShoppingListDTO) session.getAttribute("ordine");
			JSONObject jsonShoppingList = dto.getShoppingList();
			userId = userDto.getUserId();
			Double totalPriceOld = dto.getTotalPrice();
			id = Integer.parseInt(request.getParameter("id"));
			quantity = request.getParameter("quantity");
			Integer quant = Integer.parseInt(quantity);
			Double totalPriceNew = totalPriceOld;
			if(jsonShoppingList.containsKey(prodID)){
			String quantOldstr = jsonShoppingList.get(prodID).toString();
			Integer quantOld = Integer.parseInt(quantOldstr);
			if(quant == quantOld) {
				dto.setTotalPrice(totalPriceOld);
			}
			else {
				if(quant > quantOld) {
					totalPriceNew += price * quant;
					dto.setTotalPrice(totalPriceNew);
				}else {
					totalPriceNew = totalPriceOld - price * (quantOld - quant);
				    dto.setTotalPrice(totalPriceNew);
				}
			}
			}
			else {
				totalPriceNew = totalPriceOld + price * quant;
				dto.setTotalPrice(totalPriceNew);
			}
			jsonShoppingList.put(prodID, quantity);
			dto.setShoppingList(jsonShoppingList);
			ans = service.update(dto);
			updateList(request);
			request.setAttribute("dto", dto);
			getServletContext().getRequestDispatcher("/shoppinglist/readShoppingListUser.jsp").forward(request,
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
