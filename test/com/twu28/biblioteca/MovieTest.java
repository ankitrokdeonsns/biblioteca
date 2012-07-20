package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: ankit
 * Date: 19/7/12
 * Time: 8:45 PM
 * To change this template use File | Settings | File Templates.
 */
public class MovieTest
{
    @Test
    public void shouldMatchMovieName()
    {
        Movie movie = new Movie("movie", "director", 5);
        Assert.assertEquals("movie", movie.getName());
    }

    @Test
    public void shouldMatchDirectorName()
    {
        Movie movie = new Movie("movie", "director", 5);
        Assert.assertEquals("director", movie.getDirector());
    }

    @Test
    public void shouldMatchRating()
    {
        Movie movie = new Movie("movie", "director", 5);
        Assert.assertEquals("*****", movie.getRating());
    }

    @Test
    public void shouldMatchNAForNoRating()
    {
        Movie movie = new Movie("movie", "director", 0);
        Assert.assertEquals("N/A", movie.getRating());
    }
}
