package com.gmail.erofeev.st.alexei.homework7;

import java.util.Random;
import java.util.Scanner;

public class ConsoleService {
	private Scanner scanner = new Scanner(System.in);
	private Random random = new Random();

	public int getNumberFromConsole() {
		int number = 0;
		while (true) {
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
				if (number > 0) {
					break;
				} else {
					System.out.println("Plz enter not negative number");
				}
			}
			scanner.nextLine();
			System.out.println("Plz enter integer value!!");
		}
		return number;
	}

	public int[] generateRandomArry() {
		System.out.println("Enter array size:");
		int arraySize = getNumberFromConsole();
		System.out.println("Enter range:");
		int range = getNumberFromConsole();
		int[] randomArray = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			randomArray[i] = random.nextInt(2 * range + 1) - range;
			System.out.print(randomArray[i] + " ");
		}
		System.out.println();
		return randomArray;
	}

}
