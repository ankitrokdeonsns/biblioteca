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




    @Test
    public void shouldDisplayMovieList()
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Library library = new Library();
        library.displayMovieList();
        Assert.assertEquals("1. movie1 director1 ***\n2. movie2 director2 N/A\n", outputStream.toString());

    }

    @Test
    public void shouldBeAbleToLoginuser()
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Library library = new Library();
        library.logIn("111-1111", "person1");
        Assert.assertEquals("Login successful.\n", outputStream.toString());
        User user = new User("111-1111");
        Assert.assertTrue(library.isUserLoggedIn(user));
    }

    @Test
    public void shouldNotBeAbleToLoginuserForIncorrectPassword()
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Library library = new Library();
        library.logIn("111-1111", "person");
        Assert.assertEquals("Please provide proper username-password pair.\n", outputStream.toString());
    }

    @Test
    public void libraryNumberShouldBeDisplayedIfUserLoggedIn()
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        User user = new User("111-1111");
        Library library = new Library();
        library.logIn("111-1111", "person1");
        outputStream.reset();
        library.checkLibraryNumber(user);
        Assert.assertEquals("111-1111\n", outputStream.toString());

    }

    @Test
    public void messageShouldBeDisplayedIfUserNotLoggedIn()
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        User user = new User("111-1111");
        Library library = new Library();
        library.checkLibraryNumber(user);
        Assert.assertEquals("Please talk to Librarian. Thank you.\n", outputStream.toString());

    }

    @Test
    public void userShouldBeLoggedIn()
    {
        User user = new User("111-1111");
        Library library = new Library();
        library.logIn("111-1111", "person1");
        Assert.assertTrue(library.isUserLoggedIn(user));
    }

    @Test
    public void userShouldBeLoggedOut()
    {
        User user = new User("111-1111");
        Library library = new Library();
        library.logIn("111-1111", "person1");
        library.logOut(user);
        Assert.assertFalse(library.isUserLoggedIn(user));

    }

	
}
