package com.telephoneNumbers.methods;

public class ReturnNumber {

	public ReturnNumber() {}
	
	SequenceNumber sequenceMethods = new SequenceNumber();
	
	// checks if the input meets all the criteria 
	public void validateCriteria(String userInput) {
		String userInputNoWhitespaces = ManageNumber.removeWhitespace(userInput);
		
		if ( (userInputNoWhitespaces.startsWith("210") || userInputNoWhitespaces.startsWith("69")) 
				&& userInputNoWhitespaces.length() == 10 ) {
			System.out.println("Success! You have entered a valid Greek telephone number.");
			SequenceNumber.possibleSequence(userInput);
		}
		else if (userInputNoWhitespaces.length() < 10) {
			System.out.println("Fail! The number you have entered is smaller than 10 digits.");
		}
		else {
			System.out.print("Inputed number requires sorting. ");
			String prefix = ManageNumber.saveNumberPreffix(userInput);
			if (prefix.equals("210") || prefix.equals("69")) {
				String result = sequenceMethods.shrinkNumber(userInput);
				System.out.println(prefix + result);
			}
			else if (prefix.equals("0030")) {
				userInput = userInput.replace(userInput.substring(0, 6), "").trim();
				String result = sequenceMethods.shrinkNumber(userInput);
				System.out.println(prefix + "-" + result);
			}
		}
	}

}
