package com.twu28.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputReader implements IReader 
{

	@Override
	public String readLine() throws IOException 
	{
		// TODO Auto-generated method stub
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        return inputReader.readLine();
	}

}
