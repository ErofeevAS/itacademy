package com.gmail.erofeev.st.alexei.homework7;

public class ArrayService {
	private ConsoleService consoleService = new ConsoleService();
	private int newRange;
	private int[] firstArray;
	private int[] secondArray;
	private int[] tempArray;

	private int[] filterArrayAndAddToSecondArray(int[] array) {
		int counter = 0;
		for (int element : array) {
			if (isElementInNewRange(element)) {
				counter++;
			}
		}
		counter += secondArray.length;
		tempArray = new int[counter];
		for (int i = 0; i < secondArray.length; i++) {
			tempArray[i] = secondArray[i];
		}
		counter = secondArray.length;
		for (int element : firstArray) {
			if (isElementInNewRange(element)) {
				tempArray[counter] = element;
				counter++;
			}
		}
		return tempArray;
	}

	private boolean isElementInNewRange(int element) {
		if ((element <= newRange) && (element >= -newRange)) {
			return true;
		}
		return false;
	}

	private void initArrays() {
		System.out.println("First array");
		firstArray = consoleService.generateRandomArry();
		System.out.println("Second array");
		secondArray = consoleService.generateRandomArry();
	}

	public void copyArray() {
		initArrays();
		System.out.println("Enter new range:");
		newRange = consoleService.getNumberFromConsole();
		System.out.println("Copy elements from first to second array");
		filterArrayAndAddToSecondArray(firstArray);
//		showArrays();
//		secondArray = tempArray;
	}

	public void showArrays() {
		for (int element : firstArray) {
			System.out.print(element + " ");
		}
		System.out.println();
		for (int element : secondArray) {
			System.out.print(element + " ");
		}
		System.out.println();
		for (int element : tempArray) {
			System.out.print(element + " ");
		}
		System.out.println();
	}

}
