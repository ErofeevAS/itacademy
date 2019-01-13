package com.gmail.erofeev.st.alexei.homework11.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.gmail.erofeev.st.alexei.homework11.IRandom;

public class RandomImpl implements IRandom {

	private Random random = new Random();

	private int getAmountOfRepeat(List<Integer> randomNumbers, int number) {
		int repeat = 0;
		for (Integer randomNumber : randomNumbers) {
			if (randomNumber == number) {
				repeat++;
			}
		}
		return repeat;
	}

	@Override
	public List<Integer> generateRandomNumbers(int amount, int startRange, int stopRAnge) {
		List<Integer> randomNumbers = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			int randomNumber = startRange + random.nextInt(stopRAnge - startRange);
			randomNumbers.add(randomNumber);
			System.out.print(randomNumber + " ");
		}
		System.out.println();
		return randomNumbers;
	}

	@Override
	public void showNumbersAmount(List<Integer> randomNumbers) {
		Set<Integer> uniqNumbers = new HashSet<Integer>(randomNumbers);
		for (Integer number : uniqNumbers) {
			System.out.println(number + " repeat " + getAmountOfRepeat(randomNumbers, number) + " times.");
		}
	}

}
