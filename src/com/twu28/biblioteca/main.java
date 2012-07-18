package com.twu28.biblioteca;

import java.io.Console;
import java.io.IOException;

public class main 
{
	public static void main(String[] args) throws IOException
	{
		Displayer displayer = new Displayer();
		Options options = new Options();
		InputReader reader = new InputReader();
		Library library = new Library();
		
		String choice = null;
		boolean optionIsValid = false;
		
		displayer.displayWelcomeMessage();
		while(true)
		{
			displayer.displayOptionsList(options);
			do
			{
				try
				{
					displayer.displayMessage("Please Enter a Choice: ");
					choice = reader.readLine();
					optionIsValid = options.isValidOption(choice);
				}
				catch(RuntimeException exception)
				{
					displayer.displayMessage(exception.toString() );
				}
			}while(!optionIsValid);
			try
			{
				processChoice(displayer, options, reader, library, choice);
			}
			catch(RuntimeException exception)
			{
				displayer.displayMessage(exception.toString());
			}
		}
		
	}

	private static void processChoice(Displayer displayer, Options options, InputReader reader, Library library, String choice) 
	{
		switch(Integer.parseInt(choice))
		{
			case 1:
			{
				displayer.displayBookList(library);
				break;
			}
			case 2:
			{
				displayer.displayBookList(library);
				try
				{
					displayer.displayMessage("Please Enter A Book Name: ");
					library.reserveBook(reader.readLine());
				}
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				break;
			}
			case 3:
			{
				try 
				{
					displayer.displayMessage("Please Enter Your Name: ");
					Integer libraryNumber = library.checkLibraryNumber(reader.readLine());
					displayer.displayMessage(libraryNumber.toString());
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
				break;
			}
			
		}
		
	}
}
