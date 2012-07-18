package com.twu28.biblioteca;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import junit.framework.Assert;

import org.junit.Test;

public class InputReaderTest 
{
	@Test
	public void shouldReadWithoutError() throws IOException
	{
		ByteArrayInputStream inputStream = new ByteArrayInputStream("message\n".getBytes());
		System.setIn(inputStream);
		InputReader reader = new InputReader();
		Assert.assertEquals(reader.readLine(), "message");
	}

}
