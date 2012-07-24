package com.twu28.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main 
{
	public static void main(String[] args) throws IOException
	{
        displayWelcomeMessage();
        BiblioTecaMenu menu;
        Library library = new Library();
        boolean isUserLoggedIn = false;
        while (true)
        {
            if(isUserLoggedIn)
                menu = BiblioTecaMenu.loggedIn();
            else
                menu = BiblioTecaMenu.loggedOut();
            menu.display();
            BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Please provide a choice: ");
            String option = inputReader.readLine();
            try
            {

                int optionNo = Integer.parseInt(option);
                if(menu.isValidOption(optionNo))
                    isUserLoggedIn = menu.processOption(menu, optionNo, inputReader, library,isUserLoggedIn);
            }
            catch (Exception ignoreException)
            {}
        }
    }

    public static void displayWelcomeMessage()
    {
        System.out.println("Welcome!");
    }
}
