package com.telephoneNumbers.methods;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BasicLevelMethods extends AdvancedLevelMethods{

	public BasicLevelMethods () {}

	// asks the user to insert a telephone number and stores it in an instance variable (userInput)
	public String saveTelephoneNumber() {
		String userInput;
		System.out.println("Type in EXIT any time to exit the application.");
		System.out.println("Please enter your telephone number");
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
				//this.userInput = line;
				userInput = line;
				return userInput;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "The saveTelephoneNumber() method failed.";
	}

	// checks that the input contains only digits and/or whitespaces
	public void checkForDigits(String userInput) {
		boolean flag = true;
		char[] ch = userInput.toCharArray();
		for(int i = 0; i < userInput.length(); i++){
			if (Character.isAlphabetic(ch[i])) {
				flag = false;
				break;
			}
		}
		if (flag == true) {
			System.out.println("Success! The inputed number does not contain any alphabetical characters.");
		}
		else {
			System.out.println("Fail! The inputed number must contain only digits and/or whitespaces.");
		}
	}

	// checks if the input sequence is smaller than 3 characters long
	public void checkLengthOfInput(String userInput) {
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
		}
		if (flag == true) {
			System.out.println("Success! The sequence of numbers is correct.");
		}
	}

	// removes all whitespace from the input
	public static String removeWhitespace(String userInput) {
		userInput = userInput.replaceAll("\\s+","");
		return userInput;
	}

	// checks if the input meets all the criteria 
	public void validateCriteria(String userInput) {
		String userInputNoWhitespace = removeWhitespace(userInput);
		if (userInputNoWhitespace.startsWith("210") && userInputNoWhitespace.length() == 10) {
			System.out.println("Success! You have entered a valid Greek landline telephone number.");
			System.out.print("The number you have inputed is: " + userInputNoWhitespace + "\n");
		}
		else if (userInputNoWhitespace.startsWith("69") && userInputNoWhitespace.length() == 10) {
			System.out.println("Success! You have entered a valid Greek mobile telephone number.");
			System.out.print("The number you have inputed is: " + userInputNoWhitespace + "\n");
		}
		else if ((userInputNoWhitespace.startsWith("00302") || userInputNoWhitespace.startsWith("003069")) && userInputNoWhitespace.length() == 14){
			System.out.println("Success! You have entered a valid Greek telephone number with its country code.");
			System.out.print("The number you have inputed is: " + userInputNoWhitespace + "\n");
		}
		else {
			System.out.println("Fail! The number you have entered doesnt match the required criteria.");
		}
	}

	
}