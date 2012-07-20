package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class BiblioTecaMenuTest
{
    @Test
    public void shouldDisplayMenu()
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        BiblioTecaMenu menu = BiblioTecaMenu.loggedIn();
        menu.displayList();

        Assert.assertEquals(
                "1. Display book list\n" +
                "2. Check library number\n" +
                "3. Display movie list\n" +
                "4. Logout\n" +
                "5. Exit\n", outputStream.toString());
    }

    @Test
    public void optionValidationTest()
    {
        BiblioTecaMenu menu = BiblioTecaMenu.loggedIn();
        Assert.assertFalse(menu.isValidOption(-1));
        Assert.assertFalse(menu.isValidOption(6));
        Assert.assertTrue(menu.isValidOption(1));
    }
}
