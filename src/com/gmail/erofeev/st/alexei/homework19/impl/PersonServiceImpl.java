package com.gmail.erofeev.st.alexei.homework19.impl;

import com.gmail.erofeev.st.alexei.homework19.PersonService;
import com.gmail.erofeev.st.alexei.homework19.model.Person;
import com.gmail.erofeev.st.alexei.homework19.model.comparator.NameComparator;
import com.gmail.erofeev.st.alexei.homework19.model.comparator.SurNameComparator;
import com.gmail.erofeev.st.alexei.homework19.model.comparator.YearsComparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PersonServiceImpl implements PersonService {

    @Override
    public List<Person> getPersonSortedByName(List<Person> people) {
        Collections.sort(people, new NameComparator());
        List<Person> sortedPeople = new ArrayList<>(people);
        return sortedPeople;
    }

    @Override
    public List<Person> getPersonSortedBySurName(List<Person> people) {
        Collections.sort(people, new SurNameComparator());
        List<Person> sortedPeople = new ArrayList<>(people);
        return sortedPeople;
    }

    @Override
    public List<Person> getPersonSortedByYear(List<Person> people) {
        Collections.sort(people, new YearsComparator());
        List<Person> sortedPeople = new ArrayList<>(people);
        return sortedPeople;
    }
}
