package com.gmail.erofeev.st.alexei.homework19.app;

import com.gmail.erofeev.st.alexei.homework19.ListFactory;
import com.gmail.erofeev.st.alexei.homework19.PersonService;
import com.gmail.erofeev.st.alexei.homework19.RandomService;
import com.gmail.erofeev.st.alexei.homework19.enums.ListType;
import com.gmail.erofeev.st.alexei.homework19.impl.ListFactoryImpl;
import com.gmail.erofeev.st.alexei.homework19.impl.PersonServiceImpl;
import com.gmail.erofeev.st.alexei.homework19.impl.RandomServiceImpl;
import com.gmail.erofeev.st.alexei.homework19.model.Person;

import java.util.List;

public class Runner {
    public static void main(String[] args) {


        //task1
        ListFactory factory = new ListFactoryImpl(50, 0, 20);
        List<Integer> arrayList = factory.generateList(ListType.ARRAY_LIST);
        List<Integer> linkedList = factory.generateList(ListType.LINKED_LIST);
        System.out.println(arrayList.getClass().getSimpleName() + " " + arrayList.toString());
        System.out.println(linkedList.getClass().getSimpleName() + " " + linkedList.toString());
        System.out.println();

        //task2
        PersonService personService = new PersonServiceImpl();
        List<Person> people = RandomServiceImpl.getInstance().generatePerson(10);
        System.out.println("Sorted by name:");
        System.out.println(personService.getPersonSortedByName(people).toString());
        System.out.println("Sorted by surname:");
        System.out.println(personService.getPersonSortedBySurName(people).toString());
        System.out.println("Sorted by year:");
        System.out.println(personService.getPersonSortedByYear(people).toString());

    }
}
