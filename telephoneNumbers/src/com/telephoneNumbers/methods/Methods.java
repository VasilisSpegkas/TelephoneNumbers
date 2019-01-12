package com.telephoneNumbers.methods;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Methods {

	public Methods () {}

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
	public String removeWhitespace(String userInput) {
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

	// Checks the size of the inputed number for extra 0's and removes them in an attempt 
	// to reach size of given number equal to 10(size of Greek landline numbers).
	// Only work for numbers starting with '210'
	// Example: 210 70 7 50 7 0 70 (size 12) --> 2107757070 (size 10)
	// Example: 210 700 50 4 800 30 2 9 (size 16) --> 2107548329 (size 10)
	public void checkSequence(String userInput) {
		ArrayList<String> substringList = new ArrayList<String>();
		ArrayList<String> ambiguitiesList = new ArrayList<String>();
		int length = 0;
		int counter = 0;
		char[] inputCharList = userInput.toCharArray();

		// creates a 'char' type list with substrings of given numbers separated by 'whitespaces'
		for (int i = 0; i < userInput.length(); i++) {
			length++;
			if (Character.isSpaceChar(inputCharList[i]) || i == userInput.length() - 1) {
				String sub = userInput.substring(counter,length);
				counter = length;
				substringList.add(sub.trim());
			}
		}
		// use the 'removeWhitespace' method to check the length of the given number
		String userInputSize = removeWhitespace(userInput);

		// if given number size smaller than 10 stop
		if (userInputSize.length() > 10) {
			System.out.println("Attempting to sort landline number.");

			int userInputCounter = userInputSize.length();
			for (String index : substringList) {
				
				// doesn't replace 0 inside '210'
				if (!index.equals("210")) {

					// replaces double zero's when found with next numbers and checks if size still bigger than 10
					if (index.endsWith("00") && userInputCounter > 10) {
						index = index.substring(0, index.length() - 2);
						index.replaceFirst("0", index.substring(index.length()));
						index.replace("0", index.substring(index.length()));
						userInputCounter = userInputCounter - 2;
						System.out.println("Double zero removed.");
					}

					// replaces single zero's when found with the next number and checks if size still bigger than 10
					else if (index.length() > 1 && index.endsWith("0") && userInputCounter > 10) {					
						index = index.substring(0, index.length() - 1);
						index.replace("0", index.substring(index.length()));
						userInputCounter--;
						System.out.println("Single zero removed.");
					}

				}

				// stores changes in new list
				ambiguitiesList.add(index);

			}

			// checks final list size. If list size equals to 10 'Success'
			int finalNumberSize = 0;
			for (String index : ambiguitiesList) {
				finalNumberSize = finalNumberSize + index.length();	
			}
			if (finalNumberSize == 10) {
				System.out.println("Success! After handling ambiguities given number is: ");
				for (String index : ambiguitiesList) {
					System.out.print(index);
				}
			}
			else {
				System.out.println("Fail. List size is " + ambiguitiesList.size());
			}
		}
		else {
			System.out.println("Success! No ambiguities found. Given number is: " + userInputSize);
		}
		System.out.println();
	}
}