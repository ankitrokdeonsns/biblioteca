package com.twu28.biblioteca;

import java.io.ByteArrayOutputStream;
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
		Displayer displayer = new Displayer();
		displayer.displayBookList(library);
		Assert.assertEquals("1. book1\n2. book2\n3. book3\n4. book4\n5. book5\n", outputStream.toString());
		
	}
	
	@Test
	public void bookShouldNotBeReservedAlready()
	{
		Library library = new Library();
		Assert.assertFalse(library.isBookReserved("book1"));
	}
	
	@Test 
	public void bookShouldBeReserveBookIfNotAlreadyReserved()
	{
		Library library = new Library();
		Assert.assertFalse(library.isBookReserved("book1"));
		library.reserveBook("book1");
		Assert.assertTrue(library.isBookReserved("book1"));
	}
	
	@Test (expected = Exception.class)
	public void reserveBookShouldThrowExceptionIfBookIsAlreadyReserved()
	{
		Library library = new Library();
		library.reserveBook("book1");
		library.reserveBook("book1");
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
	
	@Test 
    public void libraryNumberShouldBeReturnedIfPersonExists()
    {
    	Library library = new Library();
    	Assert.assertEquals(1, library.checkLibraryNumber("person1"));
    	
    }
	
	@Test
	public void bookShouldNotRemainReservedWhenReturned()
	{
		Library library = new Library();
		library.reserveBook("book1");
		Assert.assertTrue(library.isBookReserved("book1"));
		library.returnBook("book1");
		Assert.assertFalse(library.isBookReserved("book1"));
	}
	
	@Test
	public void shouldReturnBookIfAlreadyIssued()
	{
		Library library = new Library();
		library.reserveBook("book1");
		library.returnBook("book1");
		Assert.assertFalse(library.isBookReserved("book1"));
	}
	
	@Test (expected = Exception.class)
	public void returnBookShouldThrowExceptionkIfBookIsNotAlreadyIssued()
	{
		Library library = new Library();
		library.returnBook("book1");
		
	}
	
}
