package com.twu28.biblioteca;

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

    public void displayList()
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
}
