package com.telephoneNumbers.methods;

import java.util.ArrayList;

public class ManageNumber {

	public ManageNumber() {}
	
	// removes all whitespace from the input
	public static String removeWhitespace(String userInput) {
		userInput = userInput.replaceAll("\\s+","");
		return userInput;
	}

	// splits given number to a list of substrings using whitespaces 
	public static ArrayList<String> splitNumberToSubstrings(String userInput) {
		char[] inputCharList = userInput.toCharArray();
		ArrayList<String> substringList = new ArrayList<String>();
		int length = 0;
		int counter = 0;
		for (int i = 0; i < userInput.length(); i++) {
			length++;
			if (Character.isSpaceChar(inputCharList[i]) || i == userInput.length() - 1) {
				String sub = userInput.substring(counter,length);
				counter = length;
				substringList.add(sub.trim());
			}
		}
		return substringList;
	}
	
	// returns the numbers prefix
	public static String saveNumberPreffix(String userInput) {
		ArrayList<String> substringList = new ArrayList<String>();
		substringList = splitNumberToSubstrings(userInput);

		String userInputNoWhitespaces = removeWhitespace(userInput);
		String prefix = null;
		try {
			if (userInputNoWhitespaces.startsWith("210")) {
				prefix = "210";
			}
			else if (userInputNoWhitespaces.startsWith("69")) {
				prefix = "69";
			}
			// valid for both inputs --> '00 30', '0 0 30'
			else if (substringList.get(1).endsWith("0")) {
				prefix = "0030";
			}
		} catch (Exception e) {
			System.out.println("Wrong prefix for given number.");
			e.printStackTrace();
		}
		return prefix;
	}
}
