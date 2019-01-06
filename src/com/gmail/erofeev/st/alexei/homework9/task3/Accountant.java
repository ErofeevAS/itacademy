package com.gmail.erofeev.st.alexei.homework9.task3;

public class Accountant extends Employee {
	private float monthlyRate;

	public Accountant(String name, String surName, String position, String department, float monthlyRate) {
		super(name, surName, position, department);
		this.monthlyRate = monthlyRate;
	}

	@Override
	public float getSalary() {
		return monthlyRate;
	}

}
