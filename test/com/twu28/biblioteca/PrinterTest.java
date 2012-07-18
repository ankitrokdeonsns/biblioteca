package com.twu28.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import junit.framework.Assert;

import org.junit.Test;

public class PrinterTest 
{
	@Test
	public void printlnShouldWork()
	{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		Printer printer = new Printer();
		printer.println("message");
		Assert.assertEquals("message\n", outputStream.toString());
	}
	
	@Test
	public void printShouldWork()
	{
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
		Printer printer = new Printer();
		printer.print("message");
		Assert.assertEquals("message", outputStream.toString());
	}
}
