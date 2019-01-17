package com.telephoneNumbers.methods;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {

	public static void main(String[] args) {

		Result basicMethods = JUnitCore.runClasses(BasicLevelMethodsTest.class);
		
		for (Failure failure : basicMethods.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(basicMethods.wasSuccessful());

		
		Result advancedMethods = JUnitCore.runClasses(AdvancedLevelMethodsTest.class);
		
		for (Failure failure : advancedMethods.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(advancedMethods.wasSuccessful()); 
		
	}

}
