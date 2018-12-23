package com.gmail.erofeev.st.alexei.homework4;

public class Main {

	public static void main(String[] args) {

		int[] arrayOne = { 1, 2, 3, 4 };
		int[] arrayTwo = { 2, 4, 6, 8 };
		int[] arrayThree = new int[8];
		arrayThree[0] = arrayOne[0];
		arrayThree[1] = arrayOne[1];
		arrayThree[2] = arrayOne[2];
		arrayThree[3] = arrayOne[3];
		arrayThree[4] = arrayTwo[0];
		arrayThree[5] = arrayTwo[1];
		arrayThree[6] = arrayTwo[2];
		arrayThree[7] = arrayTwo[3];

		int year = 1700;
		System.out.println("in " + year + " year was " + getTrueDaysInYear(year) + " days by wiki");
		System.out.println("in " + year + " year was " + getDaysInYear(year) + " days by homework");
		
		showTimeOfTheYear(1);
		showTimeOfTheYear(2);
		showTimeOfTheYear(3);
		showTimeOfTheYear(4);
		showTimeOfTheYear(5);

	}

	public static short getDaysInYear(int year) {
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

	public static short getTrueDaysInYear(int year) {
		if (year % 400 == 0) {
			return 366;
		}
		if (year % 100 == 0) {
			return 365;
		}
		if (year % 4 == 0) {
			return 366;
		} else {
			return 365;
		}
	}

	public static void showTimeOfTheYear(int season) {
		switch (season) {
		case 1:
			System.out.println("winter");
			break;
		case 2:
			System.out.println("spring mvc");
			break;
		case 3:
			System.out.println("summer");
			break;
		case 4:
			System.out.println("fall");
			break;

		default:
			System.out.println("wrong input data");
			break;
		}
	}

}
