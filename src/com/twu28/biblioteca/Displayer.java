package com.twu28.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Displayer 
{
	public void displayWelcomeScreen() 
	{
		this.displayWelcomeMessage();
		Options options = new Options();
		this.displayOptions(options.getListOfOptions());
	}

	private void displayOptions(List options) 
	{
		
	}

	private void displayWelcomeMessage() 
	{
		System.out.println("Welcome");
	}
}
