package com.gmail.erofeev.st.alexei.homework9.task3;

public abstract class Employee {
	private String name;
	private String surName;
	private String position;
	private String department;
	
	public Employee(String name, String surName, String position, String department) {	
		this.name = name;
		this.surName = surName;
		this.position = position;
		this.department = department;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurName() {
		return surName;
	}
	public void setSurName(String surName) {
		this.surName = surName;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public abstract float getSalary();
	
	

}
