package com.gmail.erofeev.st.alexei.homework19.model.comparator;

import com.gmail.erofeev.st.alexei.homework19.model.Person;

import java.util.Comparator;

public class SurNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return p1.getSurName().compareToIgnoreCase(p2.getSurName());
    }
}
