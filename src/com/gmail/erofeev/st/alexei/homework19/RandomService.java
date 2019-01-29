package com.gmail.erofeev.st.alexei.homework19;

import com.gmail.erofeev.st.alexei.homework19.model.Person;

import java.util.List;

public interface RandomService {

    Integer[] getArray(int size, int start, int stop);

    public List<Person> generatePerson(int amount) ;
}
