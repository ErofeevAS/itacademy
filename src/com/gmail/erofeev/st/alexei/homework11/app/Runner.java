package com.gmail.erofeev.st.alexei.homework11.app;

import java.util.List;
import java.util.Scanner;
import java.util.Set;

import com.gmail.erofeev.st.alexei.homework11.ICatAndDogRemover;
import com.gmail.erofeev.st.alexei.homework11.IConsoleService;
import com.gmail.erofeev.st.alexei.homework11.IPersonService;
import com.gmail.erofeev.st.alexei.homework11.IRandom;
import com.gmail.erofeev.st.alexei.homework11.impl.CatAndDogRemoverImpl;
import com.gmail.erofeev.st.alexei.homework11.impl.ConsoleServiceImpl;
import com.gmail.erofeev.st.alexei.homework11.impl.PersonServiceImpl;
import com.gmail.erofeev.st.alexei.homework11.impl.RandomImpl;
import com.gmail.erofeev.st.alexei.homework11.model.Person;

public class Runner {

	public static void main(String[] args) {
		IRandom randomGenerator = new RandomImpl();
		List<Integer> randomNumbers = randomGenerator.generateRandomNumbers(20, 10, 15);
		randomGenerator.showNumbersAmount(randomNumbers);
		
		Scanner scanner = new Scanner(System.in);
		IConsoleService consoleService = new ConsoleServiceImpl(scanner);
		Set<String> lines = consoleService.getSetFromConsole();
		ICatAndDogRemover remover = new CatAndDogRemoverImpl();
		Set<String> linesWithOutCatDog = remover.removeCatAndDog(lines);
		System.out.println(linesWithOutCatDog);
		
		IPersonService personGenerator = new PersonServiceImpl();
		Set<Person> people = personGenerator.generatePersons(20);
		IPersonService personSerivce = new PersonServiceImpl();
		personSerivce.showPeronsByYear(people);
		
		
	}

}
