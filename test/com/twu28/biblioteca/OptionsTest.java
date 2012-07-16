package com.twu28.biblioteca;
import junit.framework.Assert;

import org.junit.Test;
public class OptionsTest 
{
	@Test (expected = RuntimeException.class)
	public void validateOptionIfOptionChoiceAsNull()
	{
		Options options = new Options();
		options.validateOption(null);
	}
	
	@Test (expected = RuntimeException.class)
	public void validateOptionIfOptionChoiceIsNotInteger()
	{
		Options options = new Options();
		options.validateOption("1");
	}
	
	@Test (expected = RuntimeException.class)
	public void validateOptionIfOptionIsNotFromGivenOptions()
	{
		Options options = new Options();
		options.validateOption(-1);
	}
	
	@Test 
	public void validateOptionIfOptionIsFromGivenOptions()
	{
		Options options = new Options();
		options.validateOption(3);
	}
	
}
