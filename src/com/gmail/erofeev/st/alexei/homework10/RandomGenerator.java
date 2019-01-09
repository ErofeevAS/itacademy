package com.gmail.erofeev.st.alexei.homework10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGenerator {

	private Random random;
	private List<Integer> randomNumbers;

	public RandomGenerator(Random random) {
		this.random = random;
		randomNumbers = new ArrayList<>();
	}

	public void generateRandomNumbers(int amount, int startRange, int stopRAnge) {
		for (int i = 0; i < amount; i++) {
			int randomNumber = startRange + random.nextInt(stopRAnge - startRange);
			randomNumbers.add(randomNumber);
			System.out.print(randomNumber + " ");
		}
		System.out.println();
	}

	public void showTwoMaxNumber() {
		int firstMax = 0;
		int secondMax = 0;
		for (Integer number : randomNumbers) {
			if (number >= firstMax) {
				secondMax = firstMax;
				firstMax = number;
			}
			if ((number > secondMax) && (number != firstMax)) {
				secondMax = number;
			}
		}
		System.out.println("firstMax:" + firstMax + " ,secondMax:" + secondMax);
	}

}
