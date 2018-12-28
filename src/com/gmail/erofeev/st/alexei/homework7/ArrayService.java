package com.gmail.erofeev.st.alexei.homework7;

public class ArrayService {
	private ConsoleService consoleService = new ConsoleService();
	private int newRange;
	private int[] firstArray;
	private int[] secondArray;

	private int[] filterArrayAndAddToSecondArray(int[] array) {
		int counter = 0;
		for (int element : array) {
			if (isElementInNewRange(element)) {
				counter++;
			}
		}
		counter += secondArray.length;
		int[] tempArray = new int[counter];
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
		secondArray = tempArray;
		return secondArray;
	}

	private boolean isElementInNewRange(int element) {
		if ((element <= newRange) && (element >= -newRange)) {
			return true;
		}
		return false;
	}

	private void initArrays() {
		System.out.println("creating first array");
		firstArray = consoleService.generateRandomArry();
		System.out.println("creating second array");
		secondArray = consoleService.generateRandomArry();
	}

	public void copyArray() {
		initArrays();
		System.out.println("Enter new range:");
		newRange = consoleService.getNumberFromConsole();
		filterArrayAndAddToSecondArray(firstArray);
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
	}

}
