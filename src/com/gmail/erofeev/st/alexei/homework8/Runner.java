package com.gmail.erofeev.st.alexei.homework8;

import java.util.Scanner;

public class Runner {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// showCharIndex();
		// showCatsAndDogs();
		removeWhiteSpaces();

	}

	public static void showCharIndex() {
		System.out.println("Enter line:");
		String line = scanner.nextLine();
		char[] charArray = line.toCharArray();
		char lastChar = line.charAt(line.length() - 1);
		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == lastChar) {
				System.out.print(i);
				System.out.print(" ");
			}
		}
		System.out.println();
	}

	public static void showCatsAndDogs() {
		int counterNotCatsDogs = 0;
		while (true) {
			System.out.println("---Enter line---");
			String line = scanner.nextLine();
			if (line.equals("stop")) {
				System.out.print("Number of lines not containing cat or dog: ");
				System.out.println(counterNotCatsDogs);
				break;
			} else {
				if (line.contains("cat") || (line.contains("dog"))) {
					System.out.println(line);
					System.out.print("String length: ");
					System.out.println(line.length());
				} else {
					counterNotCatsDogs++;
					System.out.println("not cat or dog");
				}
			}
		}
	}

	public static void removeWhiteSpaces() {
		System.out.println("Enter phrase");
		String str = scanner.nextLine();

		char[] array = str.toCharArray();
		int indexOfSecondQuestion = 0;
		int indexOfThirdQuestion = 0;
		int counterQuestion = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '?') {
				counterQuestion++;
			}
			if (counterQuestion == 2) {
				indexOfSecondQuestion = i;
			}
			if (counterQuestion == 3) {
				indexOfThirdQuestion = i;
			}
		}
		String s1 = str.substring(0, indexOfSecondQuestion);
		String s2 = str.substring(indexOfSecondQuestion, indexOfThirdQuestion);
		String s3 = str.substring(indexOfThirdQuestion, str.length());
		s2 = s2.replaceAll(" ", "");
		System.out.println(s1 + s2 + s3);

	}

}
