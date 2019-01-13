package com.gmail.erofeev.st.alexei.homework10.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.gmail.erofeev.st.alexei.homework10.model.Person;

public class PersonGenerator {

	private Random random = new Random();

	public List<Person> generatePeople(int amount, int startYear, int stopYear) {
		List<Person> people = new ArrayList<>();
		for (int i = 0; i < amount; i++) {
			Person person = new Person("Ivan" + i, "Fool" + i, random.nextInt(stopYear - startYear) + startYear);
			people.add(person);
		}
		return people;

	}

}
