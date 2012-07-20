package com.twu28.biblioteca;

import org.junit.Test;

import junit.framework.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class LibraryBookTest 
{
    @Test
    public void shouldDisplayBook()
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        LibraryBook book = new LibraryBook("book");
        book.displayInfo();

        Assert.assertEquals("book\n", outputStream.toString());
    }

    @Test
    public void shouldNotMatchBookName()
    {
        LibraryBook book = new LibraryBook("book");
        Assert.assertFalse(book.hasName("book1"));
    }

    @Test
    public void shouldMatchBookName()
    {
        LibraryBook book = new LibraryBook("book");
        Assert.assertTrue(book.hasName("book"));
    }

    @Test
    public void bookShouldNotBeAlreadyReserved()
    {
        LibraryBook book = new LibraryBook("book");
        Assert.assertFalse(book.isReserved());
    }

    @Test
    public void bookShouldBeReserved()
    {
        LibraryBook book = new LibraryBook("book");
        book.reserve();
        Assert.assertTrue(book.isReserved());
    }
}
