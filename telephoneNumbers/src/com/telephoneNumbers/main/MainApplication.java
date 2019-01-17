package com.telephoneNumbers.main;

import com.telephoneNumbers.methods.CheckNumber;
import com.telephoneNumbers.methods.ReturnNumber;

public class MainApplication {

	public static void main(String[] args) {

		CheckNumber num = new CheckNumber();
		ReturnNumber num1 = new ReturnNumber();
		
		boolean flag = true;

		do {

			System.out.println("Type in EXIT any time to exit the application.");
			System.out.println("Please enter your telephone number:");
			String telephoneNumber = num.saveTelephoneNumber();
			System.out.println("Checking if input matches criteria...");
			if (num.checkForDigits(telephoneNumber) == true) {
				System.out.println("Number contains only digits.");
				if (num.checkLengthOfInput(telephoneNumber) == true) {
					System.out.println("Sequence of inputed number is correct.");
					num1.validateCriteria(telephoneNumber);
				}
				
			}
			System.out.println();
		} while (flag == true);

	}

}
