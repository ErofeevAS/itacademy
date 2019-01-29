package com.gmail.erofeev.st.alexei.homework19.model.comparator;

import com.gmail.erofeev.st.alexei.homework19.model.Person;

import java.util.Comparator;

public class YearsComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (p1.getYear() < p2.getYear()) {
            return -1;
        }
        if (p1.getYear() > p2.getYear()) {
            return 1;
        }
        return 0;
    }
}
