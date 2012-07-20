package com.twu28.biblioteca;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import junit.framework.Assert;
import org.junit.Test;

import com.twu28.biblioteca.Library;

public class LibraryTest
{
	@Test
	public void shouldDisplayBookList()
	{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		Library library = new Library();
		library.displayBookList();
		Assert.assertEquals("1. book1\n2. book2\n3. book3\n4. book4\n5. book5\n", outputStream.toString());
		
	}

	@Test
	public void shouldbeAbleToReserveBook() throws IOException
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Library library = new Library();
		library.reserveBook("book1");

        Assert.assertEquals("Thank You! Enjoy the book.\n", outputStream.toString());
        outputStream.flush();
        outputStream.close();
	}

	@Test
	public void bookShouldNotBeReservedIfAlreadyReserved() throws IOException
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Library library = new Library();
		library.reserveBook("book1");
        outputStream.reset();
        library.reserveBook("book1");
        Assert.assertEquals("Sorry we don't have that book yet.\n", outputStream.toString());
        outputStream.flush();
        outputStream.close();
	}

    @Test
    public void shouldBeAbleToCheckLibraryNumber() throws IOException
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Library library = new Library();
        library.checkLibraryNumber("person1");
        Assert.assertEquals("Please talk to Librarian. Thank you.\n", outputStream.toString());
        outputStream.flush();
        outputStream.close();

    }

	@Test (expected = Exception.class)
	public void reserveBookShouldThrowExceptionIfBookIsNotInLibrary()
	{
		Library library = new Library();
		
		library.reserveBook("book");
	}
	
	@Test (expected = RuntimeException.class)
    public void reserveBookShouldThrowExceptionIfBookNameIsNull()
    {
        Library library = new Library();
        library.reserveBook(null);
    }
	
	@Test (expected = Exception.class)
    public void checkLibraryNumberShouldThrowExceptionIfPersonNameIsNull()
    {
    	Library library = new Library();
    	library.checkLibraryNumber(null);
    	
    }
	
	@Test (expected = Exception.class)
    public void checkLibraryNumberShouldThrowExceptionIfPersonDoesNotExist()
    {
    	Library library = new Library();
    	library.checkLibraryNumber("i am person");
    }

	
}
