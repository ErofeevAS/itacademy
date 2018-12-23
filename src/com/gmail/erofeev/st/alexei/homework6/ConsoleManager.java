package com.gmail.erofeev.st.alexei.homework6;

import java.util.Random;
import java.util.Scanner;

public class ConsoleManager {
	private Scanner scaner = new Scanner(System.in);
	private Random random = new Random();

	public void showAmountOfDigitsAndSum() {
		int amountOfDigits = 0;
		int sum = 0;
		System.out.println("Plz enter number:");
		int number = scaner.nextInt();
		while (number != 0) {
			amountOfDigits++;
			sum += number % 10;
			number /= 10;
		}
		System.out.println("amount of digits: " + amountOfDigits);
		System.out.println("sum: " + sum);
	}

	public void showEvenNumbers() {
		int evenNumbersCounter = 0;
		System.out.println("Enter array size:");
		int sizeOfArray = scaner.nextInt();
		int[] arrayOfRandomNumbers = new int[sizeOfArray];
		System.out.println("Enter the beginning of random numbers range");
		int start = scaner.nextInt();
		System.out.println("Enter the end of random numbers range");
		int stop = scaner.nextInt() + 1;
		for (int i = 0; i < sizeOfArray; i++) {
			arrayOfRandomNumbers[i] = random.nextInt(stop - start) + start;
			if (arrayOfRandomNumbers[i] % 2 == 0) {
				evenNumbersCounter++;
			}
			System.out.print(arrayOfRandomNumbers[i]);
			System.out.print(" ");
		}
		System.out.println();
		System.out.println("Amount of even numbers: " + evenNumbersCounter);
	}

	public void showRandomNumberFromRange() {
		System.out.println("Enter the border of random numbers range");
		int n = scaner.nextInt();
		System.out.print(random.nextInt(2 * n + 1) - n + " ");
	}
}
