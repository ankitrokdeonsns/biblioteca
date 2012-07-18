package com.twu28.biblioteca;

import java.io.BufferedReader;
import java.io.OutputStreamWriter;

public class LibraryBook
{
    private String name;
    
    public LibraryBook(String bookName)
    {
        this.name = bookName;
    }
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
    
}
