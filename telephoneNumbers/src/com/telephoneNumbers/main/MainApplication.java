package com.telephoneNumbers.main;

import com.telephoneNumbers.methods.BasicLevelMethods;

public class MainApplication {

	public static void main(String[] args) {

		BasicLevelMethods num = new BasicLevelMethods();
		
		boolean flag = true;

		do {

			String telephoneNumber = num.saveTelephoneNumber();
			num.checkForDigits(telephoneNumber);
			num.checkLengthOfInput(telephoneNumber);
			num.validateCriteria(telephoneNumber);
			num.checkSequence(telephoneNumber);

		} while (flag == true);

	}

}
