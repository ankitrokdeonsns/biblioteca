package com.twu28.biblioteca;

import java.io.BufferedReader;
import java.io.OutputStreamWriter;

public class LibraryBook
{
    private String name;
    private boolean reserved;

    public LibraryBook(String bookName)
    {
        this.name = bookName;
        this.reserved = false;
    }
    /*
    @Override
    public boolean equals(Object book)
    {
    	if(book == null)	return false;
    	if(book.getClass() != this.getClass())	return false;
    	if(((LibraryBook)book).name != this.name)	return false;
    	return true;
    }
    public String getName()
    {    
        return this.name;  
    }
    */
    public void displayInfo()
    {
        System.out.println(this.name);
    }

    public boolean hasName(String bookName)
    {
        return this.name.equalsIgnoreCase(bookName);
    }

    public boolean isReserved()
    {
        return this.reserved;
    }

    public void reserve()
    {
        this.reserved = true;
    }
}
