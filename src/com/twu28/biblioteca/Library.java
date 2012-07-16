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
        {    
            return this.name.equals(bookName);  
        }
    }
    
    private class Person
    {
    	private String name;
    	private int number;
    	public Person(String personName, int maxNumber) 
    	{
    		this.name = personName;
    		this.number = maxNumber;
		}
		public boolean hasName(Object personName) {
			return this.name.equals(personName);
		}
		public int getNumber() {
			return this.number;
		}
    }

    private ArrayList bookList;
    private ArrayList personList;
    private static int maxNumber;

    public Library()
    {
        bookList = new ArrayList();
        bookList.add(new Book("book1", "author1"));
        bookList.add(new Book("book2", "author2"));
        bookList.add(new Book("book3", "author3"));
        bookList.add(new Book("book4", "author4"));
        bookList.add(new Book("book5", "author5"));
        
        maxNumber = 1;
        personList = new ArrayList();
        
        this.addPerson("person1");
        this.addPerson("person2");
        this.addPerson("person3");
        
        

    }
    
    private void addPerson(String personName) 
    {
		personList.add(new Person(personName, this.maxNumber));
		this.maxNumber++;
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

	public int checkLibraryNumber(Object personName) 
	{
		if(personName == null)	throw new RuntimeException();
		if(personName.getClass() != String.class)	throw new RuntimeException();
		for(int idx = 0; idx < this.personList.size(); idx++)
		{
			Person person = (Person) this.personList.get(idx);
			if(person.hasName(personName))
				return person.getNumber();
		}
		throw new RuntimeException("Please Talk To Librarian");
	}
}
