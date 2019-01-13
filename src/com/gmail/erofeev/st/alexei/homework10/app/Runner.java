package com.gmail.erofeev.st.alexei.homework10.app;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import com.gmail.erofeev.st.alexei.homework10.IPersonService;
import com.gmail.erofeev.st.alexei.homework10.impl.PersonGenerator;
import com.gmail.erofeev.st.alexei.homework10.impl.PersonServiceImpl;
import com.gmail.erofeev.st.alexei.homework10.impl.RandomGenerator;
import com.gmail.erofeev.st.alexei.homework10.impl.StringManager;
import com.gmail.erofeev.st.alexei.homework10.model.Person;

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
		System.out.println(stringManager.getLines());

		PersonGenerator personGenerator = new PersonGenerator();
		List<Person> people = personGenerator.generatePeople(20, 15, 30);
		IPersonService personService = new PersonServiceImpl();
		personService.showPersons(people);

	}

}
