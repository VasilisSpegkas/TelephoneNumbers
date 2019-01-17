package com.telephoneNumbers.methods;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class SequenceNumber {

	public SequenceNumber() {}

	// finds two digit inputs and depending on the number either removes a '0' or adds on in between
	public static String possibleSequence(String userInput) {
		String userInputNoWhitespaces = ManageNumber.removeWhitespace(userInput);
		ArrayList<String> ambiguitiesList = new ArrayList<String>();
		ArrayList<String> substringList = new ArrayList<String>();
		substringList = ManageNumber.splitNumberToSubstrings(userInput);
		int userInputLength =  userInputNoWhitespaces.length();
		int mobileCounter = 0;
		int counter = 0;
		int counter2 = 0;
		int changes = 0;	//used to stop changes after two times
		
		// checks if number contains any zeros besides '210' to proceed
		if (userInputNoWhitespaces.substring(3, userInputNoWhitespaces.length()).contains("0") ) {
			for (String index : substringList) {
				index.trim();
				mobileCounter++;
				// ignores index '210', '10', single digits, mobile number '6 90 *' 
				// and can only add one '0' and remove one '0'
				if ( !(index.equals("210") ) 
						&& !( index.equals("10") )
						&& ( !(index.startsWith("9") && mobileCounter == 2) )
						&& ( index.length() > 1 )
						&& !(changes == 2) )
				{

					if ( !index.contains("0") && counter == 0 ) {
						index = index.substring(0, index.length() - 1).concat("0").concat(index.substring(1, index.length()));
						counter = 1;
						counter2 = 0;
						changes++;
						userInputLength++;
					}
					
					else if ( index.endsWith("0") && 
							counter2 == 0 &&
							!index.equals(substringList.get(substringList.size() - 1)) ) {
						index = index.replace("0","");
						counter2 = 1;
						counter = 0;
						changes++;
						userInputLength--;
					}
				}
				ambiguitiesList.add(index);
			}
		}
		
		// if numbers remain the same after changes do not print
		String result = ambiguitiesList.stream()
				.map(Object::toString)
				.collect(Collectors.joining(""));
		if ( (userInputLength == 10 && userInput.matches(result) ) || changes == 2) {
			System.out.println("Possible sequence of given number are: ");
			System.out.println(userInput.replaceAll(" ", ""));
			System.out.println(result);
		}
		else {
			System.out.println("Only one possible sequence.");
			return userInput.replaceAll(" ", "");
		}
		return null;
	}

	// Checks the size of the inputed number for extra 0's and removes them in an attempt 
	// to reach size of given number equal to 10(size of Greek numbers) starting from left to right.
	// Example: 2 10 70 7 50 7 0 70 (size 12) --> 2107757070 (size 10)
	// Example: 210 700 50 4 800 30 2 9 (size 16) --> 2107548329 (size 10)
	public String shrinkNumber(String userInput) {
		ArrayList<String> substringList = new ArrayList<String>();
		ArrayList<String> ambiguitiesList = new ArrayList<String>();

		substringList = ManageNumber.splitNumberToSubstrings(userInput);

		System.out.println("Attempting to sort given number...");

		// use the 'removeWhitespace' method to store the length of the given number
		int userInputLength = ManageNumber.removeWhitespace(userInput).length();
		int counter = 0;

		for (String index : substringList) {
			counter++;
			// ignores 0 for '210' and '2 10'
			if ( !(index.equals("210") && counter == 1) 
					&& !(index.equals("10") && counter == 2) ) {

				// removes double zero's when found with next numbers and checks if size still bigger than 10
				if (index.endsWith("00") && userInputLength > 10) {
					index = index.substring(0, index.length() - 2);
					userInputLength = userInputLength - 2;
				}

				// replaces single zero's when found with the next number and checks if size still bigger than 10
				else if (index.length() > 1 && index.endsWith("0") && userInputLength > 10) {	
					index = index.substring(0, index.length() - 1);
					userInputLength--;
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
			String shrinkedNumber =  ambiguitiesList.stream()
					.map(Object::toString)
					.collect(Collectors.joining(" "));
			String result = possibleSequence(shrinkedNumber);
			return result;
		}
		else {
			System.out.println("Fail. Telephone number size remains bigger than 10 digits even after "
					+ "removing all extra zero's: " 
					+ ambiguitiesList.stream()
					.map(Object::toString)
					.collect(Collectors.joining("")) 
					);
		}
		return null;
	}

}
