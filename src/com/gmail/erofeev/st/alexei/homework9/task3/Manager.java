package com.gmail.erofeev.st.alexei.homework9.task3;

public class Manager extends Employee {
	private float percentFromSales;
	private float sales;

	public Manager(String name, String surName, String position, String department, float percentFromSales,
			float sales) {
		super(name, surName, position, department);
		this.percentFromSales = percentFromSales;
		this.sales = sales;
	}

	public float getPercentFromSales() {
		return percentFromSales;
	}

	public void setPercentFromSales(float percentFromSales) {
		this.percentFromSales = percentFromSales;
	}

	public float getSalary() {
		return percentFromSales * sales / 100;
	}

}
