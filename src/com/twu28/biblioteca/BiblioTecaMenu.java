package com.twu28.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ankit
 * Date: 20/7/12
 * Time: 4:14 PM
 * To change this template use File | Settings | File Templates.
 */
public class BiblioTecaMenu
{
    List<String> items;
    User loggedInUser;
    private BiblioTecaMenu(String... items)
    {
        this.items = new ArrayList<String>();
        for(String item: items)
            this.items.add(item);
        this.loggedInUser = null;

    }

    public void display()
    {
        int index = 1;
        for(String item: this.items)
        {
            System.out.println(index + ". " + item);
            index++;
        }
    }

    public static BiblioTecaMenu loggedIn()
    {
        return new BiblioTecaMenu(
                "Display book list",
                "Reserve Book",
                "Check library number",
                "Display movie list",
                "Exit");
    }

    public static BiblioTecaMenu loggedOut()
    {
        return new BiblioTecaMenu(
                "Display book list",
                "Reserve book",
                "Check library number",
                "Display movie list",
                "Login",
                "Exit");
    }

    public boolean isValidOption(int option)
    {
        if((option < 1) || (option > this.items.size())) return false;
        return true;
    }

    public boolean processOption(BiblioTecaMenu menu, int optionNo, BufferedReader inputReader, Library library, boolean isUserLoggedIn) throws IOException
    {
        if(isUserLoggedIn)
            return processOptionLoggedIn(menu, optionNo, inputReader, library, isUserLoggedIn);
        return processOptionLoggedOut(menu, optionNo, inputReader, library, isUserLoggedIn);

    }

    private boolean processOptionLoggedOut(BiblioTecaMenu menu, int optionNo, BufferedReader inputReader, Library library, boolean isUserLoggedIn) throws IOException
    {
        switch (optionNo)
        {
            case 1:
            {
                library.displayBookList();
                break;
            }
            case 2:
            {
                library.displayBookList();
                System.out.println("Please provide a book name to reserve: ");
                String bookName = inputReader.readLine();
                library.reserveBook(bookName);
                break;
            }
            case 3:
            {
                library.checkLibraryNumber(this.loggedInUser);
                break;
            }
            case 4:
            {
                library.displayMovieList();
                break;
            }
            case 5:
            {
                System.out.println("Please provide username:");
                String username = inputReader.readLine();
                System.out.println("Please provide password:");
                String password = inputReader.readLine();
                this.loggedInUser = library.logIn(username, password);
                if(this.loggedInUser != null)
                    isUserLoggedIn = true;
                break;
            }
            case 6:
            {
                System.exit(0);
                break;
            }
        }
        return isUserLoggedIn;
    }

    private boolean processOptionLoggedIn(BiblioTecaMenu menu, int optionNo, BufferedReader inputReader, Library library, boolean isUserLoggedIn) throws IOException
    {
        switch (optionNo)
        {
            case 1:
            {
                library.displayBookList();
                break;
            }
            case 2:
            {
                library.displayBookList();
                System.out.println("Please provide a book name to reserve: ");
                String bookName = inputReader.readLine();
                library.reserveBook(bookName);
                break;
            }
            case 3:
            {
                library.checkLibraryNumber(this.loggedInUser);
                break;
            }
            case 4:
            {
                library.displayMovieList();
                break;
            }
            case 5:
            {
                System.exit(0);
                break;
            }
        }
        return isUserLoggedIn;
    }


}
