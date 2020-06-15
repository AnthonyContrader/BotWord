package it.contrader.view.user;

import java.util.List;
import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class UserUpdateView implements View {

	private UserController usersController;
	private Request request;

	public UserUpdateView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		int userIdToUpdate;
		String username, usertype;

		/*
		 * List<User> users; Integer usersId; String password; users =
		 * usersController.getAllUsers();
		 */
		System.out.println("\n----- Seleziona l'utente da modificate  -----\n");
		// System.out.println();
		// users.forEach(us_type -> System.out.println(us_type.toString()));
		// System.out.println();
		UserDTO userDTO = new UserDTO();

		System.out.println("Digita l'Id dell'utente da modificare:");
		try {
			userIdToUpdate = Integer.parseInt(getInput());
			if (userIdToUpdate != 0) {
				userDTO.setUserId(userIdToUpdate);

				System.out.println("Digita la nuova username:");
				username = getInput();
				if (!username.equals(""))
					userDTO.setUsername(username);

				usersController.updateUser(userDTO);

			}
		} catch (Exception e) {
			System.out.println("Hai inserito un valore errato");
		}

	}

	@Override
	public String getInput() {
		Scanner scanner = new Scanner(System.in);
		return scanner.nextLine().trim();
	}

	@Override
	public void submit() {
		request = new Request();
		request.put("mode", "menu");
		request.put("choice", "");
		MainDispatcher.getInstance().callAction("User", "doControl", request);
	}

}
