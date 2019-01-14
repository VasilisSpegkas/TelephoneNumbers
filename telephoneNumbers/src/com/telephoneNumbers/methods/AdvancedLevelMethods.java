package com.telephoneNumbers.methods;

import java.util.ArrayList;

public class AdvancedLevelMethods {

	public AdvancedLevelMethods() {}
	
	// Checks the size of the inputed number for extra 0's and removes them in an attempt 
	// to reach size of given number equal to 10(size of Greek landline numbers).
	// Example: 2 10 70 7 50 7 0 70 (size 12) --> 2107757070 (size 10)
	// Example: 210 700 50 4 800 30 2 9 (size 16) --> 2107548329 (size 10)
	public void checkSequence(String userInput) {
		userInput = userInput.trim();
		ArrayList<String> substringList = new ArrayList<String>();
		ArrayList<String> ambiguitiesList = new ArrayList<String>();
		int length = 0;
		int counter = 0;
		char[] inputCharList = userInput.toCharArray();

		// creates a 'char' type list with substrings of given numbers separated by 'whitespaces'
		for (int i = 0; i < userInput.length(); i++) {
			length++;
			// splits list to substrings using whitespaces. 
			if (Character.isSpaceChar(inputCharList[i]) || i == userInput.length() - 1) {
				String sub = userInput.substring(counter,length);
				counter = length;
				substringList.add(sub.trim());
			}
		}
		// use the 'removeWhitespace' method to check the length of the given number
		String userInputNoWhitespaces = BasicLevelMethods.removeWhitespace(userInput);

		// if given number size smaller than 10 stop
		if (userInputNoWhitespaces.length() > 10) {
			System.out.println("Attempting to sort landline number.");
			int userInputCounter = userInputNoWhitespaces.length();
			int counter2 = 0;

			for (String index : substringList) {
				counter2++;
				// doesn't replace 0 inside '210'
				if (!index.equals("210") && !(index.equals("10") && counter2 == 2)  ) {

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
			System.out.println("Success! No ambiguities found. Given number is: " + userInputNoWhitespaces);
		}
		System.out.println();
	}

}
