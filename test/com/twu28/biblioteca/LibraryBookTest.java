package com.twu28.biblioteca;

import org.junit.Test;

import junit.framework.Assert;

public class LibraryBookTest 
{
	@Test
	public void shouldNotEquateToNull()
	{
		LibraryBook book = new LibraryBook("book");
		Assert.assertFalse(book.equals(null));
	}
	
	@Test
	public void shouldNotEquateToObjectOfAnotherType()
	{
		LibraryBook book = new LibraryBook("book");
		Assert.assertFalse(book.equals(15));
	}
	
	@Test
	public void shouldEquateToBookWithSameName()
	{
		LibraryBook book1 = new LibraryBook("book");
		LibraryBook book2 = new LibraryBook("book");
		Assert.assertTrue(book1.equals(book2));
	}
	
	@Test
	public void shouldNotEquateToBookWithDifferentName()
	{
		LibraryBook book1 = new LibraryBook("book1");
		LibraryBook book2 = new LibraryBook("book2");
		Assert.assertFalse(book1.equals(book2));
	}
}
