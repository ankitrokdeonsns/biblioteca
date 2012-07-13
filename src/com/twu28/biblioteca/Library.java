package com.twu28.biblioteca;

import java.awt.print.Book;
import java.util.ArrayList;

/**
 * Created by IntelliJ IDEA.
 * User: ankitro
 * Date: 7/12/12
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class Library
{
    private class Book
    {
        private String name;
        private String authorName;

        public Book(String bookName, String authorName)
        {
            this.name = bookName;
            this.authorName = authorName;
        }

        public boolean hasName(Object bookName)
        {    //TODO does this function violate Tell Don't ask requirement
            return this.name.equals(bookName);  //To change body of created methods use File | Settings | File Templates.
        }
    }

    private ArrayList bookList;

    public Library()
    {
        bookList = new ArrayList();
        bookList.add(new Book("book1", "author1"));
        bookList.add(new Book("book2", "author2"));
        bookList.add(new Book("book3", "author3"));
        bookList.add(new Book("book4", "author4"));
        bookList.add(new Book("book5", "author5"));

    }
    
    public boolean reserveBookByBookName(Object bookName)
    {
        if(bookName == null)
            throw new RuntimeException("Please provide a book name to search");
        if(!bookName.getClass().equals(String.class))
            return false;
        return this.searchForBookUsingBookName(bookName);
    }

    private boolean searchForBookUsingBookName(Object bookName)
    {
        for(int idx = 0;idx < bookList.size();idx++)
        {
            Book book = (Book) bookList.get(idx);
            if(book.hasName(bookName))
                return true;
        }
        return false;
    }
}
