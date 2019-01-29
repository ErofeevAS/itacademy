package com.gmail.erofeev.st.alexei.homework19.impl;

import com.gmail.erofeev.st.alexei.homework19.RandomService;
import com.gmail.erofeev.st.alexei.homework19.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomServiceImpl implements RandomService {
    private Random random = new Random();
    private static volatile RandomService instance = null;
    private static final int BIRTHDAY_OLDEST_MAN = 1890;
    private static final int CURRENT_YEAR = 2019;

    private RandomServiceImpl() {
    }

    public static RandomService getInstance() {
        if (instance == null) {
            synchronized (RandomService.class) {
                if (instance == null) {
                    instance = new RandomServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public Integer[] getArray(int size, int start, int stop) {
        Integer[] randomArray = new Integer[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = getInt(start, stop);
        }
        return randomArray;
    }

    @Override
    public List<Person> generatePerson(int amount) {
        List<Person> people = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            Person person = Person.newBuilder().name("Vaska" + i).surName("Pupkin" + i).year(getInt(BIRTHDAY_OLDEST_MAN, CURRENT_YEAR)).build();
            people.add(person);
        }
        return people;
    }

    private int getInt(int start, int stop) {
        return random.nextInt(stop - start) + start;
    }


}
