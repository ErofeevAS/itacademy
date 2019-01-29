package com.gmail.erofeev.st.alexei.homework19;

import com.gmail.erofeev.st.alexei.homework19.model.Person;

import java.util.List;

public interface PersonService {

    List<Person> getPersonSortedByName(List<Person> people);

    List<Person> getPersonSortedBySurName(List<Person> people);

    List<Person> getPersonSortedByYear(List<Person> people);
}
