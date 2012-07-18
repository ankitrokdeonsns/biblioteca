package com.twu28.biblioteca;

public class Person 
{    
	private String name;
	private int number;
	public Person(String personName, int maxNumber) 
	{
		this.name = personName;
		this.number = maxNumber;
	}
	public String getName()
	{
		return this.name;
	}
	public int getNumber()
	{
		return this.number;
	}
    
}
