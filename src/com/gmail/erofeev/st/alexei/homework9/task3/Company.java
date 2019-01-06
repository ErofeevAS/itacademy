package com.gmail.erofeev.st.alexei.homework9.task3;

public class Company {
	private String name;
	private String address;
	private Employee[] employees = new Employee[100];

	private int getNumberOfEmployee() {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i] == null) {
				return i;
			}
		}
		return employees.length;
	}

	public Company(String name, String address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee[] getEmployees() {
		return employees;
	}

	public void setEmployees(Employee[] employees) {
		this.employees = employees;
	}

	public void addEmployee(Employee employee) {
		employees[getNumberOfEmployee()] = employee;
	}

}
