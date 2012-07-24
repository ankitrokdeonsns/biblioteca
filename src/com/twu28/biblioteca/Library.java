package com.twu28.biblioteca;

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
    private List<User> userList;
	private List<Movie> movieList;
    private Map<String, String> loginMap;
    private List<User> loggedInUsers;


    public Library()
    {
        bookList = new ArrayList<LibraryBook>();
        bookList.add(new LibraryBook("book1"));
        bookList.add(new LibraryBook("book2"));
        bookList.add(new LibraryBook("book3"));
        bookList.add(new LibraryBook("book4"));
        bookList.add(new LibraryBook("book5"));
        

        userList = new ArrayList<User>();
        
        userList.add(new User("person1"));
        userList.add(new User("person2"));
        userList.add(new User("person3"));
        
        movieList = new ArrayList<Movie>();
        movieList.add(new Movie("movie1", "director1", 3));
        movieList.add(new Movie("movie2", "director2", 0));

        this.loginMap = new HashMap<String, String>();
        loginMap.put("111-1111", "person1");
        loginMap.put("111-1112", "person2");
        loginMap.put("111-1113", "person3");

        this.loggedInUsers = new ArrayList<User>();

    }

    public void checkLibraryNumber(User user)
    {
        if(isUserLoggedIn(user))
        {
            System.out.println(user.getUserName());
            return;
        }
        System.out.println("Please talk to Librarian. Thank you.");
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
            if(book.hasName(bookName))
            {
                if(book.isReserved())
            	{
                	System.out.println("Sorry we don't have that book yet.");
                	return;
            	}
                book.reserve();
                System.out.println("Thank You! Enjoy the book.");
                return;
            }
        }
        throw new RuntimeException("Book does not exist");
		
	}

    public void displayBookList()
    {
        int index = 1;
        for(LibraryBook book: this.bookList)
        {
            System.out.print(index + ". ");
            book.displayInfo();
            index++;
        }
    }



    public void displayMovieList()
    {
        int index = 1;
        for(Movie movie: this.movieList)
        {
            System.out.print(index + ". ");
            movie.displayInfo();
            index++;
        }
    }

    public User logIn(String userName, String password)
    {
        if(this.loginMap.get(userName).equals(password))
        {
            User user = new User(userName);
            this.loggedInUsers.add(user);
            System.out.println("Login successful.");
            return user;
        }
        System.out.println("Please provide proper username-password pair.");
        return null;
    }

    public boolean isUserLoggedIn(User user)
    {
        for(User loggedInUser: this.loggedInUsers)
            if(loggedInUser.equals(user))
                return true;
        return false;
    }

    public void logOut(User user)
    {
        int index = 0;
        for(User loggedInUser: this.loggedInUsers)
        {
            if(loggedInUser.equals(user))
                break;
            index++;
        }
        this.loggedInUsers.remove(index);
        user = null;

    }
}
