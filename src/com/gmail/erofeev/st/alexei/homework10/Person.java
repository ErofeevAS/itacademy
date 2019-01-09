package com.gmail.erofeev.st.alexei.homework10;

public class Person {
	final static int ADULT_AGE = 18;

	private String name;
	private String surName;
	private int age;

	public Person(String name, String surName, int age) {
		this.name = name;
		this.surName = surName;
		this.age = age;
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		if (this.age >= ADULT_AGE) {
			return "Adult: " + name + " " + surName + " " + age;
		} else {
			return "Infant: " + name + " " + surName + " " + age;
		}
	}

}
