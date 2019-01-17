package com.telephoneNumbers.methodsTest;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.telephoneNumbers.methods.SequenceNumber;

public class SequenceNumberTest {

	private SequenceNumber classUnderTest;
	
	private String testValueOne = "2 10 69 30 6 6 4";
	private String testValueTwo = "210 700 50 4 800 30 2 9";
	private String testValueThree = "00 30 6 94 59 50 84 2";
	// 2 10 60 9 50 5 80 4
	
	public SequenceNumberTest() {}
	
	@Before
	public void setUp() throws Exception {
		classUnderTest = new SequenceNumber();
	}
	
	@Test
	public void testPossibleSequence() {
		String expectedValue = testValueOne;
		assertEquals(expectedValue, testValueOne);
		
		String expectedValueTwo = testValueTwo;
		assertEquals(expectedValueTwo, testValueTwo);
		
		String expectedValueThree = testValueThree;
		assertEquals(expectedValueThree, testValueThree);
	}
	
	@Test
	public void testShrinkNumber() {
		String expectedValue = testValueOne;
		assertEquals(expectedValue, testValueOne);
		
		String expectedValueTwo = testValueTwo;
		assertEquals(expectedValueTwo, testValueTwo);
		
		String expectedValueThree = testValueThree;
		assertEquals(expectedValueThree, testValueThree);
	}

}
