package it.contrader.view.user;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.controller.UserController;
import it.contrader.dto.UserDTO;
import it.contrader.main.MainDispatcher;
import it.contrader.view.View;

public class UserInsertView implements View {

	private UserController usersController;
	private Request request;

	public UserInsertView() {
		this.usersController = new UserController();
	}

	@Override
	public void showResults(Request request) {
	}

	@Override
	public void showOptions() {
		String username, usertype, password, name, surname, address;

		System.out.println("Inserisci i campi dell'utente:");
		System.out.println("Digita l'username: ");
		username = getInput();
		System.out.println("Inserisci la tipologia utente");
		usertype=getInput();
		System.out.println("Inserisci la password");
		password=getInput();
		System.out.println("Inserisci il nome dell'utente");
		name=getInput();
		System.out.println("Inserisci il cognome dell'utente");
		surname=getInput();
		System.out.println("Inserisci l'indirizzo dell'utente");
		address=getInput();
		if (!username.equals("") && !usertype.equals("")) {
			usersController.insertUser(new UserDTO(username, usertype, password, name, surname, address));
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
