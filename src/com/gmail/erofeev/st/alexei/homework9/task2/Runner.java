package com.gmail.erofeev.st.alexei.homework9.task2;

public class Runner {

	public static void main(String[] args) {
		Automobile car1 = new RussianAutomobile();
		Automobile car2 = new GermanyAutomobile();
		Automobile car3 = new EnglandAutomobile();

		Automobile[] cars = { car1, car2, car3 };
		for (Automobile automobile : cars) {
			System.out.println(automobile.getDescription());
		}
	}

}
