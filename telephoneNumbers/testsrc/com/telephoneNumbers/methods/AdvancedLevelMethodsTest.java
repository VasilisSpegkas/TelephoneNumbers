package com.telephoneNumbers.methods;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.telephoneNumbers.methods.AdvancedLevelMethods;

public class AdvancedLevelMethodsTest {

	private AdvancedLevelMethods classUnderTest;
	
	private String testValueOne = "2 10 77 57 070";
	private String testValueTwo = "210 700 50 4 800 30 2 9";
	
	public AdvancedLevelMethodsTest() {}
	
	@Before
	public void setUp() throws Exception {
		classUnderTest = new BasicLevelMethods();
	}
	
	@Test
	public void TestcheckSequence() {
		String expectedValue = testValueOne;
		assertEquals(expectedValue, testValueOne);
		
		String expectedValueTwo = testValueTwo;
		assertEquals(expectedValueTwo, testValueTwo);
	}
	

}
