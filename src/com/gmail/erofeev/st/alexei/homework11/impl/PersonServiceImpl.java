package com.gmail.erofeev.st.alexei.homework11.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import com.gmail.erofeev.st.alexei.homework11.IPersonService;
import com.gmail.erofeev.st.alexei.homework11.model.Person;

public class PersonServiceImpl implements IPersonService {

	private Random random = new Random();

	private Person findYoungestPerson(Set<Person> list) {
		int minAge = Integer.MAX_VALUE;
		Person youngestPerson = null;
		Set<Person> people = new HashSet<Person>(list);
		for (Person person : people) {
			if (person.getYear() <= minAge) {
				minAge = person.getYear();
				youngestPerson = person;
			}
		}
		return youngestPerson;

	}

	@Override
	public Set<Person> generatePersons(int amount) {
		Set<Person> people = new HashSet<>();
		for (int i = 0; i < amount; i++) {
			people.add(new Person("Ivan" + 1, "Fool" + i, 1920 + random.nextInt(90)));
		}
		return people;
	}

	@Override
	public void showPeronsByYear(Set<Person> people) {
		Set<Person> persons = new HashSet<Person>(people);
		Iterator<Person> iterator = persons.iterator();
		while (!persons.isEmpty()) {
			iterator = persons.iterator();
			Person youngestPerson = this.findYoungestPerson(persons);
			while (iterator.hasNext()) {
				Person person = iterator.next();
				if (person.equals(youngestPerson)) {
					System.out.println(person);
					iterator.remove();
				}
			}
		}
	}

}
