package com.telephoneNumbers.methods;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CheckNumber {

	public CheckNumber () {}

	// asks the user to insert a telephone number
	public String saveTelephoneNumber() {
		String userInput;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String line = br.readLine();
			if (line.isEmpty() || line.matches("\\s+?")) {
				System.out.println("Your input is empty. Try again!");
			}
			else if (line.equalsIgnoreCase("EXIT")) { 
				System.exit(0);
			}
			else {
				userInput = line;
				return userInput;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// checks that the input contains only digits and/or whitespaces
	public boolean checkForDigits(String userInput) {
		boolean flag = true;
		char[] userInputCharList = userInput.toCharArray();
		for (int i = 0; i < userInput.length(); i++) {
			if (Character.isAlphabetic(userInputCharList[i])) {
				flag = false;
				break;
			}
			else {
				flag = true;
			}
		}
		return flag;
	}

	// checks if the input sequence is smaller than 3 characters long
	public boolean checkLengthOfInput(String userInput) {
		boolean flag = true;
		int length = 0;
		int counter = 0;
		char[] ch = userInput.toCharArray();
		for (int i = 0; i < userInput.length(); i++) {
			counter++;
			// makes sure characters after 'whitespace' are less than 3
			if (Character.isSpaceChar(ch[i])) {
				length = counter;
				counter = 0;
				if (length > 4) {
					System.out.println("Fail! Length of sequence of numbers is bigger than 3 numbers long.");
					flag = false;
					break;
				}
			}
			// makes sure characters at the start are less than 4
			else if (!Character.isSpaceChar(ch[i]) && counter > 3) {
				System.out.println("Fail! Length of sequence of numbers is bigger than 3 numbers long.");
				flag = false;
				break;
			}
			else {
				flag = true;
			}
		}
		return flag;
	}

}