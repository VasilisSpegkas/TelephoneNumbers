package com.telephoneNumbers.methods;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.telephoneNumbers.methods.BasicLevelMethods;

public class BasicLevelMethodsTest {

	private BasicLevelMethods classUnderTest;
	
	private String testValueOne = "210 77 57 070";
	private String testValueTwo = "6 94 59 55 0 40";
	private String testValueThree = "0030 210 77 57 870";
	
	public BasicLevelMethodsTest() {} 
	
	@Before
	public void setUp() throws Exception {
		classUnderTest = new BasicLevelMethods();
	}
	
	@Test
	public void testSaveTelephoneNumber() {
		String expectedValueOne = testValueOne;
		assertEquals(expectedValueOne, testValueOne);
		
		String expectedValueTwo = testValueTwo;
		assertEquals(expectedValueTwo, testValueTwo);
		
		String expectedValueThree = testValueThree;
		assertEquals(expectedValueThree, testValueThree);
		
	}

	@Test
	public void testCheckForDigits() {
		String expectedValue = testValueOne;
		assertEquals(expectedValue, testValueOne);
		
		String expectedValueTwo = testValueTwo;
		assertEquals(expectedValueTwo, testValueTwo);
		
		String expectedValueThree = testValueThree;
		assertEquals(expectedValueThree, testValueThree);
		
	}

	
	@Test
	public void testCheckLengthOfInput() {
		String expectedValue = testValueOne;
		assertEquals(expectedValue, testValueOne);
		
		String expectedValueTwo = testValueTwo;
		assertEquals(expectedValueTwo, testValueTwo);
		
		String expectedValueThree = testValueThree;
		assertEquals(expectedValueThree, testValueThree);
		
	}
	
	
	@Test
	public void testRemoveWhitespace() {
		String expectedValue = testValueOne;
		assertEquals(expectedValue, testValueOne);
		
		String expectedValueTwo = testValueTwo;
		assertEquals(expectedValueTwo, testValueTwo);
		
		String expectedValueThree = testValueThree;
		assertEquals(expectedValueThree, testValueThree);
		
	}

	@Test
	public void testValidateCriteria() {
		String expectedValue = testValueOne;
		assertEquals(expectedValue, testValueOne);
		
		String expectedValueTwo = testValueTwo;
		assertEquals(expectedValueTwo, testValueTwo);
		
		String expectedValueThree = testValueThree;
		assertEquals(expectedValueThree, testValueThree);
		
	}

}
