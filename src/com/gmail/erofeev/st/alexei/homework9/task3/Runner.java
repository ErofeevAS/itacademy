package com.gmail.erofeev.st.alexei.homework9.task3;

public class Runner {

	public static void main(String[] args) {

		Company company = new Company("SolarSystem", "MilkyWay");
		PaySheet paySheet = new PaySheet();
		
		Employee worker1 = new Worker("Vaska", "Pupkin", "Slave", "Sector#1", 1f, 180f);
		Employee worker2 = new Worker("Petr", "Koval", "Slave", "Sector#2", 0.9f, 182f);
		Employee manager1 = new Manager("Dzmitri", "Brown", "manager", "Sector#1", 1f, 10000000f);
		Employee accountant = new Accountant("Natalia", "Pertova", "accountant", "Sector#2", 500);
		Employee director = new Director("John", "Gold", "God", "Sector#1", 2000, 50f, 10000000f);
		
		company.addEmployee(worker1);
		company.addEmployee(worker2);
		company.addEmployee(manager1);
		company.addEmployee(accountant);
		company.addEmployee(director);
		
		paySheet.showPaySheet(company.getEmployees());
		
		
		
	}

}
