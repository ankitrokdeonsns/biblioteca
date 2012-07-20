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

    public String getName()
    {
        return this.name;
    }

    public String getDirector()
    {
        return this.directorName;
    }

    public String getRating()
    {
        if(this.rating == 0)    return "N/A";
        String ratingString = "";
        for(int idx = 0; idx < this.rating; idx++)
            ratingString+="*";
        return ratingString;
    }
}
