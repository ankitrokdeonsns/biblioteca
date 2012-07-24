package com.twu28.biblioteca;

/**
 * Created with IntelliJ IDEA.
 * User: ankit
 * Date: 19/7/12
 * Time: 8:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Movie
{

    private String name;
    private String directorName;
    private int rating;

    public Movie(String name, String directorName, int rating)
    {
        this.name = name;
        this.directorName = directorName;
        this.rating = rating;
    }

    public void displayInfo()
    {
        System.out.print(this.name + " " + this.directorName + " ");
        for(int index = 0; index < this.rating; index++)
            System.out.print("*");
        if(this.rating == 0)
            System.out.print("N/A");
        System.out.println();
    }
}
