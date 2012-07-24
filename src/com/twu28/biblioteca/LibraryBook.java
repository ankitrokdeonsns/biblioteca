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
