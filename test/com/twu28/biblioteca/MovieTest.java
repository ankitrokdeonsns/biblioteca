package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
    public void shouldDisplayMovieInfoWithRating()
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Movie movie = new Movie("movie", "director", 3);
        movie.displayInfo();

        Assert.assertEquals("movie director ***\n", outputStream.toString());
    }

    @Test
    public void shouldDisplayMovieInfoWithNoRating()
    {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Movie movie = new Movie("movie", "director", 0);
        movie.displayInfo();

        Assert.assertEquals("movie director N/A\n", outputStream.toString());
    }

}
