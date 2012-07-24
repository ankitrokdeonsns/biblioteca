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

    private BiblioTecaMenu(String... items)
    {
        this.items = new ArrayList<String>();
        for(String item: items)
            this.items.add(item);

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
                "Logout",
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

    public User processOption(Main main, int optionNo, BufferedReader inputReader, Library library, User currentUser) throws IOException
    {
        if(main.isUserLoggedIn())
            return processOptionLoggedIn(main, optionNo, inputReader, library, currentUser);
        else
            return processOptionLoggedOut(main, optionNo, inputReader, library, currentUser);

    }

    private User processOptionLoggedOut(Main main, int optionNo, BufferedReader inputReader, Library library, User currentUser) throws IOException
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
                library.checkLibraryNumber(currentUser);
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
                currentUser = library.logIn(username, password);
                if(currentUser != null)
                    main.userLoggedIn();

                break;
            }
            case 6:
            {
                System.exit(0);
                break;
            }
        }
        return currentUser;
    }

    private User processOptionLoggedIn(Main main, int optionNo, BufferedReader inputReader, Library library, User currentUser) throws IOException
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
                library.checkLibraryNumber(currentUser);
                break;
            }
            case 4:
            {
                library.displayMovieList();
                break;
            }
            case 5:
            {
                library.logOut(currentUser);
                main.userLoggedOut();
                break;
            }
            case 6:
            {
                System.exit(0);
                break;
            }
        }
        return currentUser;
    }


}
