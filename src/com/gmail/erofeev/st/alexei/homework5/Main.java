package com.gmail.erofeev.st.alexei.homework5;

public class Main {

	public static void main(String[] args) {
		showDaysInRangeOfYears(2000, 2010);
		showSquareNumbers(10, 20);
		showNumberDividedByThreeNotFive(0, 50);
	}

	private static short getDaysInYear(int year) {
		if (year % 400 == 0) {
			return 365;
		}
		if (year % 100 == 0) {
			return 366;
		}
		if (year % 4 == 0) {
			return 366;
		} else {
			return 365;
		}
	}

	public static void showDaysInRangeOfYears(int start, int stop) {
		for (int i = start; i <= stop; i++) {
			System.out.print(i);
			System.out.print(" year has ");
			System.out.print(getDaysInYear(i));
			System.out.println(" days.");
		}
	}

	public static void showSquareNumbers(int start, int stop) {
		for (int i = start; i <= stop; i++) {
			System.out.println(i * i);
		}
	}

	public static void showNumberDividedByThreeNotFive(int start, int stop) {
		for (int i = start; i < stop; i++) {
			if (i % 3 == 0) {
				if (i % 5 != 0) {
					System.out.print(i);
					System.out.print(" ");
				}
			}
		}
		System.out.println();
	}
}
