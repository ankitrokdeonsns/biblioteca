package com.twu28.biblioteca;

import javax.management.RuntimeErrorException;

public class UserInterface {
	
	private String[] welcomeScreenOptions = {"Enter", "Exit"};
	
	public void displayWelcomeScreen() {
		// TODO Auto-generated method stub
		this.displayWelcomeMessage();
		this.displayOptions(welcomeScreenOptions);
		//TODO "getOption" method here
	}

	

	private void getOption(String[] options, Object option) {
		// TODO Auto-generated method stub
		if(option == null) throw new RuntimeException("Please select a valid option");
		if(option.getClass() != Integer.class) throw new RuntimeException("Selected Option must be an integer");
		if((((Integer)option) > options.length) || (((Integer)option) < 1)) throw new RuntimeException("Please select a valid option");
	}



	private void displayOptions(String[] options) {
		// TODO Auto-generated method stub
		for(int i = 0; i < options.length; i++)
			System.out.println((i + 1) + options[i]);
	}



	private void displayWelcomeMessage() {
		// TODO Auto-generated method stub
		System.out.println("Welcome");
	}



	

}
