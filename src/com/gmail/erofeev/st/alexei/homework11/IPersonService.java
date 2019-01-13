package com.gmail.erofeev.st.alexei.homework11;

import java.util.Set;

import com.gmail.erofeev.st.alexei.homework11.model.Person;

public interface IPersonService {

	public Set<Person> generatePersons(int amount);

	public void showPeronsByYear(Set<Person> people);

}
