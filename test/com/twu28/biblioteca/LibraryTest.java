package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

import com.twu28.biblioteca.Library;

public class LibraryTest
{
    @Test (expected = RuntimeException.class)
    public void canPersonReserveBookByBookNameIfBookNameIsNull()
    {
        Library library = new Library();
        library.reserveBookByBookName(null);
    }    

    @Test
    public void canPersonReserveBookByBookNameIfBookNameIsNotString()
    {
        Library library = new Library();
        Assert.assertFalse(library.reserveBookByBookName(15));
    }

    @Test
    public void canPersonReserveBookByBookNameIfBookListIsEmpty()
    {
        Library library = new Library();
        Assert.assertFalse(library.reserveBookByBookName("head first java"));
    }

    @Test
    public void canPersonReserveBookByBookNameIfBookListIsNotEmptyAndBookDoesNotExist()
    {
        Library library = new Library();
        Assert.assertFalse(library.reserveBookByBookName("head first java"));
    }

    @Test
    public void canPersonReserveBookByBookNameIfBookListIsNotEmptyAndBookExists()
    {
        Library library = new Library();
        Assert.assertTrue(library.reserveBookByBookName("book3"));
    }
    
    @Test (expected = Exception.class)
    public void testCheckLibraryNumberIfPersonNameIsNull()
    {
    	Library library = new Library();
    	library.checkLibraryNumber(null);
    	
    }
    
    @Test (expected = Exception.class)
    public void testCheckLibraryNumberIfLibraryNumberIfPersonNameIsNotString()
    {
    	Library library = new Library();
    	library.checkLibraryNumber(5);
    	
    }
    
    @Test (expected = Exception.class)
    public void testCheckLibraryNumberIfLibraryNumberIfPersonNameDoesNotExist()
    {
    	Library library = new Library();
    	library.checkLibraryNumber("i am person");
    	
    }
    
    @Test 
    public void testCheckLibraryNumberIfLibraryNumberIfPersonNameExists()
    {
    	Library library = new Library();
    	Assert.assertEquals(1, library.checkLibraryNumber("person1"));
    	
    }
    
}
