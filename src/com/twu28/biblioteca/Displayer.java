package com.twu28.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Displayer implements IPrinter 
{

	@Override
	public void print(String string)
	{
		System.out.print(string);
	}

	@Override
	public void println(String string)
	{
		System.out.println(string);
	}

	public void displayWelcomeMessage() 
	{
		System.out.println("Welcome");
		
	}

	public void displayOptionsList(Options options) 
	{
		List<String> listOfOptions = options.getListOfOptions();
		int index = 1;
		for(String option: listOfOptions)
		{
			System.out.println(index + ". " + option);
			index++;
		}
		
	}

	public void displayBookList(Library library)  
	{
		List<LibraryBook> bookList = library.getBookList();
		int index = 1;
		for(LibraryBook book: bookList)
		{
			System.out.println(index + ". " + book.getName());
			index++;
		}
		
	}

	public void displayMessage(String message) 
	{
		System.out.println(message);
		
	}


    public void displayMovieList(Library library)
    {
        List<Movie> movieList = library.getMovieList();
        int index = 1;
        for(Movie movie: movieList)
        {
            System.out.println(index + ". " + movie.getName() + " " +movie.getDirector() + " " +movie.getRating());
            index++;
        }
    }
}
