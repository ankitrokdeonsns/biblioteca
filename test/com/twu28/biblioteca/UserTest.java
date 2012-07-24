package com.twu28.biblioteca;

import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class UserTest
{
    @Test (expected = Exception.class)
    public void shouldNotEquateToNull()
    {
        new User("person").equals(null);
    }

    @Test
    public void shouldNotEquateToOtherDataType()
    {
        Assert.assertFalse(new User("person").equals("i am person"));
    }

    @Test
    public void shouldNotEquateToUserWithDifferentName()
    {
        Assert.assertFalse(new User("person1").equals(new User("person2")));
    }

    @Test
    public void shouldEquateToUserWithSameName()
    {
        Assert.assertTrue(new User("person").equals(new User("person")));
    }

}
