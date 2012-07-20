package com.twu28.biblioteca;
import junit.framework.Assert;

import org.junit.Test;
public class OptionsTest 
{
	@Test 
	public void optionIsNotValidIfItIsNull()
	{
		Options options = new Options();
		Assert.assertFalse(options.isValidOption(null));
	}
	
	@Test (expected = Exception.class)
	public void optionIsNotValidIfItIsNotInteger()
	{
		Options options = new Options();
		options.isValidOption("abc");
	}
	
	@Test 
	public void optionIsNotValidIfItIsNotWithinOptionsRange()
	{
		Options options = new Options();
		options.isValidOption("-1");
		
	}
	
	@Test
	public void optionNo1IsFromGivenOptions()
	{
		Options options = new Options();
		Assert.assertFalse(options.isOptionNotFromGivenOptions(1));
	}
	
	@Test
	public void optionNo5IsFromGivenOptions()
	{
		Options options = new Options();
		Assert.assertTrue(options.isOptionNotFromGivenOptions(-1));
	}
	
	@Test 
	public void optionIsValidIfItIsWithinOptionsRange()
	{
		Options options = new Options();
		options.isValidOption("3");
	}
	
}
