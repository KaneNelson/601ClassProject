package org.kane.seis601class.controllers;

import java.io.*;

import org.kane.seis601class.models.Session;
import org.kane.seis601class.models.User;
import org.kane.seis601class.views.*;

public class MainViewController implements SessionControllerInterface{
	
	@Override
	public void startSession(User user) {
		currentSession = new Session();//TODO this is a temp logic will need to create a session via sessionRepo
		currentSession.loginUser(user);
		currentView = new MainMenuView();
		System.out.println("You are currently logged in! ");
	}

	@Override
	public void stopSession() {
		// TODO Auto-generated method stub
		
	}
	private ViewInterface currentView;
	private boolean shouldExit;
	private Session currentSession;
	
	public MainViewController(){
		shouldExit = false;
		currentView = new AuthView(this);
	}
	
	public void run(){
		while(shouldExit == false){
			currentView.display();
			System.out.print(">> ");
			String input = readUserInput();
			checkForExit(input);
			if(!shouldExit){
				currentView.processUserInput(input);
		
			}
		}System.out.println("exiting...");

	}

		
	
	public void checkForExit(String input){
		if(input.equals("q")||input.equals("Q"))
			shouldExit = true;
		
	}
	public String readUserInput(){
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = reader.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return input;
	}
}
