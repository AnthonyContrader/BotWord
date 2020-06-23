/**
 * Client view
 */

package it.contrader.view;

import java.util.Scanner;

import it.contrader.controller.Request;
import it.contrader.main.MainDispatcher;


public class HomeBOView implements View {

    private String choice;

    public void showResults(Request request) {
    	System.out.println("Benvenuto in WMES "+request.get("nomeUtente").toString());
    	
    }


    public void showOptions() {
        System.out.println("-------MENU-------\n");
        System.out.println("Seleziona cosa vuoi fare:");
        System.out.println("[P]rodotti [E]sci");
        this.choice = this.getInput();
    }

    public void submit() {
        if (choice.equalsIgnoreCase("P")) {
        	MainDispatcher.getInstance().callView("Prodotti", null);
        }
        
        if (choice.equalsIgnoreCase("E"))
            MainDispatcher.getInstance().callAction("Login", "doControl", null);
        else {
            Request request = new Request();
            request.put("choice", choice);
            MainDispatcher.getInstance().callAction("Login", "doControl", request);
        }
    }


    public String getInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


}
