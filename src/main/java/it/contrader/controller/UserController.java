package it.contrader.controller;

import java.util.List;

import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.model.User;
import it.contrader.service.UserService;

public class UserController implements Controller {

	private static String sub_package = "user.";
	private UserService usersService;
	private Request request;

	public UserController() {
		this.usersService = new UserService();
	}

	public List<User> getAllUser() {
		return this.usersService.getAllUser();
	}

	public UserDTO readUser(int userId) {
		return this.usersService.readUser(userId);
	}

	public boolean insertUser(UserDTO usersDTO) {
		return this.usersService.insertUser(usersDTO);
	}

	public boolean updateUser(UserDTO usersDTO) {
		return this.usersService.updateUser(usersDTO);
	}

	public boolean deleteUser(Integer usersId) {
		return this.usersService.deleteUser(usersId);
	}

	@Override
	public void doControl(Request request) {
		String mode = (String) request.get("mode");
		String choice = (String) request.get("choice");

		if (mode == "menu") {
			MainDispatcher.getInstance().callView("User", null);
		} else {
			switch (choice.toUpperCase()) {
			case "L":
				MainDispatcher.getInstance().callView(sub_package + "UserRead", null);
				break;
			case "I":
				MainDispatcher.getInstance().callView(sub_package + "UserInsert", null);
				break;
			case "M":
				MainDispatcher.getInstance().callView(sub_package + "UserUpdate", null);
				break;
			case "C":
				MainDispatcher.getInstance().callView(sub_package + "UserDelete", null);
				break;
			case "E":
				MainDispatcher.getInstance().callView("Login", null);
				break;
			default:
				MainDispatcher.getInstance().callView("Login", null);
				break;
			}
		}
	}

}
