package com.twu28.biblioteca;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: ankitro
 * Date: 7/12/12
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
public class Library
{
        
    

    private List<LibraryBook> bookList;
    private List<Person> personList;
	private List<LibraryBook> reservedBookList;
    private static int maxNumber;
    private List<Movie> movieList;
    private Map<Integer, String> userMap;

    public Library()
    {
        bookList = new ArrayList<LibraryBook>();
        bookList.add(new LibraryBook("book1"));
        bookList.add(new LibraryBook("book2"));
        bookList.add(new LibraryBook("book3"));
        bookList.add(new LibraryBook("book4"));
        bookList.add(new LibraryBook("book5"));
        
        maxNumber = 1;
        personList = new ArrayList<Person>();
        
        personList.add(new Person("person1", 1111111, "person1"));
        personList.add(new Person("person2", 1111112, "person2"));
        personList.add(new Person("person3", 1111113, "person3"));
        
        reservedBookList = new ArrayList<LibraryBook>();
        
        movieList = new ArrayList<Movie>();
        movieList.add(new Movie("movie1", "director1", 3));
        movieList.add(new Movie("movie2", "director2", 0));

        this.userMap = new HashMap<Integer, String>();
        userMap.put(1111111, "person1");
        userMap.put(1111112, "person2");
        userMap.put(1111113, "person3");
    }
    
    
    
	public int checkLibraryNumber(String personName) 
	{
		if(personName == null)	throw new RuntimeException();
		for(int idx = 0; idx < this.personList.size(); idx++)
		{
			Person person = (Person) this.personList.get(idx);
			if(person.getName().equals(personName))
				return person.getNumber();
		}
		throw new RuntimeException("Please Talk To Librarian");
	}

	public List<LibraryBook> getBookList() {
		return this.bookList;
	}

	public void reserveBook(String  bookName) 
	{
		if(bookName == null) 
		{
			System.out.println("Sorry the book does not exist");
			throw new RuntimeException("Book does not exist");
		}
		for(LibraryBook book: this.bookList)
        {
            if(book.getName().equalsIgnoreCase(bookName))
            {
                if(this.isBookReserved(bookName)) 
            	{
                	System.out.println("Sorry the book is already reserved");
                	throw new RuntimeException("Book is alsready Reserved");
            	}
                this.reservedBookList.add(book);
                System.out.println("Congratulations you have the book");
                return;
            }
        }
        throw new RuntimeException("Book does not exist");
		
	}

	public boolean isBookReserved(String bookName) 
	{
		for(LibraryBook book: this.reservedBookList)
        {
            if(book.getName().equalsIgnoreCase(bookName))
            {
                return true;
            }
        }
		return false;
	}



	public void returnBook(String bookName) 
	{
		for(LibraryBook book: this.reservedBookList)
        {
            if(book.getName().equalsIgnoreCase(bookName))
            {
            	this.reservedBookList.remove(book);
                return;
            }
        }
		throw new RuntimeException();
		
	}

    public List<Movie> getMovieList()
    {
        return this.movieList;
    }

    public String login(int username, String password)
    {

        if(userMap.get(username).equals(password))   return "logged in";
        return "talk to librarian";
    }
}
