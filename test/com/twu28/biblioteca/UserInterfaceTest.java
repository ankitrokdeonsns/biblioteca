package com.twu28.biblioteca;
import org.junit.Test;
public class UserInterfaceTest 
{
	@Test (expected = RuntimeException.class)
	public void validateOptionIfOptionIsNull()
	{
		String[] options = {"option1", "option2", "option3"};
		UserInterface userInterface = new UserInterface();
		//userInterface.getOption(options, null);
	}
	
	@Test (expected = RuntimeException.class)
	public void validateOptionIfOptionIsNotAnInteger()
	{
		String[] options = {"option1", "option2", "option3"};
		UserInterface userInterface = new UserInterface();
		//userInterface.getOption(options, "1");
	}
	
	@Test (expected = RuntimeException.class)
	public void validateOptionIfOptionIsNotFromGivenOptions()
	{
		String[] options = {"option1", "option2", "option3"};
		UserInterface userInterface = new UserInterface();
		//userInterface.getOption(options, -1);
	}
	
	@Test 
	public void validateOptionIfOptionIsFromGivenOptions()
	{
		String[] options = {"option1", "option2", "option3"};
		UserInterface userInterface = new UserInterface();
		//userInterface.getOption(options, 2);
	}
}
