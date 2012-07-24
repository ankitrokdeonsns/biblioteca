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
        menu.display();

        Assert.assertEquals(
                "1. Display book list\n" +
                "2. Reserve Book\n" +
                "3. Check library number\n" +
                "4. Display movie list\n" +
                "5. Logout\n" +
                "6. Exit\n", outputStream.toString());
    }

    @Test
    public void optionValidationTest()
    {
        BiblioTecaMenu menu = BiblioTecaMenu.loggedIn();
        Assert.assertFalse(menu.isValidOption(-1));
        Assert.assertFalse(menu.isValidOption(8));
        Assert.assertTrue(menu.isValidOption(1));
    }
}
