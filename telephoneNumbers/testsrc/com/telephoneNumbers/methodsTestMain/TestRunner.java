package com.telephoneNumbers.methodsTestMain;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import com.telephoneNumbers.methodsTest.CheckNumberTest;
import com.telephoneNumbers.methodsTest.ManageNumberTest;
import com.telephoneNumbers.methodsTest.ReturnNumberTest;
import com.telephoneNumbers.methodsTest.SequenceNumberTest;

public class TestRunner {

	public static void main(String[] args) {

		Result checkNumber = JUnitCore.runClasses(CheckNumberTest.class);

		for (Failure failure : checkNumber.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(checkNumber.wasSuccessful());


		Result manageNumber = JUnitCore.runClasses(ManageNumberTest.class);

		for (Failure failure : manageNumber.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(manageNumber.wasSuccessful()); 

		Result returnNumber = JUnitCore.runClasses(ReturnNumberTest.class);

		for (Failure failure : returnNumber.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(returnNumber.wasSuccessful()); 
		
		Result sequenceNumber = JUnitCore.runClasses(SequenceNumberTest.class);

		for (Failure failure : sequenceNumber.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(sequenceNumber.wasSuccessful()); 

	}

}
