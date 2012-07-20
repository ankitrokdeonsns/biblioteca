package com.twu28.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class Options
{
	private List<String> list;
	public Options()
	{
		list = new ArrayList<String>();
		list.add("List all Books");
		list.add("Reserve Book");
		list.add("Check Library Number");
        list.add("Display Movie List");
        list.add("Login");
        list.add("Exit");
	}
	public boolean isValidOption(String option) 
	{
		if(option == null) return false;
		int optionIndex = Integer.parseInt(option) - 1;
		if(isOptionNotFromGivenOptions(optionIndex)) return false;
		return true;
	}

	public List getListOfOptions() 
	{
		return this.list;
	}
	public boolean isOptionNotFromGivenOptions(int optionIndex) 
	{
		
		return ((optionIndex < 0) || (optionIndex > (list.size() - 1)));
	}
}
