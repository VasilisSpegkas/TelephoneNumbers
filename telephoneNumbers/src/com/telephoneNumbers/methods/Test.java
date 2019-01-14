package com.telephoneNumbers.methods;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> myList = Arrays.asList("2", "10", "70", "7", "50", "7", "8", "70");
		//String number = "210 70 7 50 7 8 70";

		BasicLevelMethods num = new BasicLevelMethods();
		String result = num.saveTelephoneNumber();
		char[] inputCharList = result.toCharArray();
		int length = 0;
		int counter = 0;
		ArrayList<String> substringList = new ArrayList<String>();

		for (int i = 0; i < inputCharList.length; i++) {
			length++;
			if (Character.isSpaceChar(inputCharList[i]) || i == result.length() - 1) {
				String sub = result.substring(counter,length);
				//System.out.println(sub);
				counter = length;
				Stream.of(sub)
					.filter(s -> s.endsWith("0"))
					.forEach(s -> System.out.println(s));
			}
		}

	}

}
