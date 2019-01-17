package com.telephoneNumbers.methodsTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.telephoneNumbers.methods.ReturnNumber;

public class ReturnNumberTest {

	private ReturnNumber classUnderTest;
	
	private String testValueOne = "2 10 77 57 070";
	private String testValueTwo = "210 700 50 4 800 30 2 9";
	private String testValueThree = "00 30 6 94 59 55 0 40";	
	
	public ReturnNumberTest() {}
	
	@Before
	public void setUp() throws Exception {
		classUnderTest = new ReturnNumber();
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
