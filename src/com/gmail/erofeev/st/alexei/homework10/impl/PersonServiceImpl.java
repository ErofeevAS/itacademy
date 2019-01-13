package com.gmail.erofeev.st.alexei.homework10.impl;

import java.util.List;

import com.gmail.erofeev.st.alexei.homework10.IPersonService;
import com.gmail.erofeev.st.alexei.homework10.model.Person;

public class PersonServiceImpl implements IPersonService {
	final static int ADULT_AGE = 18;

	@Override
	public void showPersons(List<Person> persons) {
		for (Person person : persons) {
			if (person.getAge() >= ADULT_AGE) {
				System.out.println("Adult:" + person);
			}
			if (person.getAge() < ADULT_AGE) {
				System.out.println("Infant:" + person);
			}
		}

	}

}
