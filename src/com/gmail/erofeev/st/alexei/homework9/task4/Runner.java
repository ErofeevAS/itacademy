package com.gmail.erofeev.st.alexei.homework9.task4;

public class Runner {

	public static void main(String[] args) {
		IPositionPrinter worker = new Worker();
		IPositionPrinter director = new Director();
		IPositionPrinter accountant = new Accountant();

		IPositionPrinter[] employees = { worker, director, accountant };
		for (IPositionPrinter employee : employees) {
			employee.showEmployeePosition();
		}

	}

}
