package com.twu28.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
    private boolean isUserLoggedIn;


    public static void main(String[] args) throws IOException
	{
        Main main = new Main();
        displayWelcomeMessage();
        BiblioTecaMenu menu;
        Library library = new Library();
        User currentUser = null;
        main.userLoggedOut();
        while (true)
        {
            if(main.isUserLoggedIn())
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
                    currentUser = menu.processOption(main, optionNo, inputReader, library, currentUser);
            }
            catch (Exception ignoreException)
            {}
        }
    }

    public static void displayWelcomeMessage()
    {
        System.out.println("Welcome!");
    }

    public void userLoggedIn()
    {
        this.isUserLoggedIn = true;
    }

    public void userLoggedOut()
    {
        isUserLoggedIn = false;
    }

    public boolean isUserLoggedIn()
    {
        return isUserLoggedIn;
    }




}
