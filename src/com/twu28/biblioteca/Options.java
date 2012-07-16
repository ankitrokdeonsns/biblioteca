package com.twu28.biblioteca;

import java.util.ArrayList;

public class Options
{
	private ArrayList<String> list;
	public Options()
	{
		list = new ArrayList<String>();
		list.add("List all Books");
		list.add("Reserve Book By Book Name");
		list.add("Reserve Book By Author Name");
		list.add("Check Library Number");
	}
	public void validateOption(Object object) 
	{
		if(object == null) throw new RuntimeException("Please provide a valid option");
		if(object.getClass() != Integer.class) throw new RuntimeException("Please provide a valid option");
		if(((Integer)object < 1) || ((Integer)object > this.list.size())) throw new RuntimeException("Please provide a valid option");
	}

	public ArrayList getListOfOptions() {
		
		return this.list;
	}
}
