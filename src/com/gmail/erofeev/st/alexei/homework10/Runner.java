package com.gmail.erofeev.st.alexei.homework10;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		RandomGenerator randomGenerator = new RandomGenerator(random);
		randomGenerator.generateRandomNumbers(10, 2, 98);
		randomGenerator.showTwoMaxNumber();

		StringManager stringManager = new StringManager(scanner);
		stringManager.addNewStrings(5);
		stringManager.replacePluses();

		List<Person> people = new ArrayList<>();
		for (int i = 15; i < 30; i++) {
			Person person = new Person("Ivan" + i, "Fool" + i, random.nextInt(30 - 15) + 15);
			people.add(person);
			System.out.println(person);
		}

	}

}
