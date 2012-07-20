package com.twu28.biblioteca;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.Assert;

import org.junit.Test;

public class DisplayerTest 
{
	@Test
	public void shouldDisplayWelcomeMessage()
	{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		Displayer displayer = new Displayer();
		displayer.displayWelcomeMessage();
		Assert.assertEquals("Welcome\n", outputStream.toString());
	}
	
	@Test
	public void shouldDisplayOptionsList()
	{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		Displayer displayer = new Displayer();
		Options options = new  Options();
		displayer.displayOptionsList(options);
		Assert.assertEquals("1. List all Books\n2. Reserve Book\n3. Check Library Number\n4. Display Movie List\n5. Login\n6. Exit\n", outputStream.toString());
	}
}
