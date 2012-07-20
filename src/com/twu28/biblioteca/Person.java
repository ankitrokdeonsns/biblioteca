package com.twu28.biblioteca;

public class Person 
{    
	private String name;
	private int number;
    private String password;
	public Person(String personName, int maxNumber, String password)
	{
		this.name = personName;
		this.number = maxNumber;
        this.password = password;
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
