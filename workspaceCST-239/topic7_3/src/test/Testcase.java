package test;

import org.junit.Assert;
import org.junit.Test;

public class Testcase {
	
	@Test
	public void testAssertions()
	{
		//Test Data
		String str1 = new String ("abc");
		String str2 = new String("abd");
		String str3 =null;
		String str4 = "abc";
		String str5="abc";
		
		int val1 = 5;
		int val2=6;
		
		String [] expectedArray = {"One", "two","three"};
		String [] resultArray = {"One", "two","three"};
		
		//Check that two objects are equal
		Assert.assertEquals(str1, str2);
		
		//Check that a condition is true
		Assert.assertTrue(val1 < val2);;
		//check that a condition is false
		Assert.assertFalse(val1 > val2);
		//check that an object is null
		Assert.assertNotNull(str1);
		//check that an object is null
		Assert.assertNull(str3);
		//check if two object referances point to the same object
		Assert.assertSame(str4, str5);
		//check if two object refernces not point ot the same object
		Assert.assertNotSame(str1, str3);
		//check whether two arrays are equal to each other
		Assert.assertArrayEquals(expectedArray, resultArray);
		
		
		
		
	}
	
}