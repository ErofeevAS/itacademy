package com.gmail.erofeev.st.alexei.homework9.task3;

public class Director extends Employee {
	private float monthlyRate;
	private float percentFromSales;
	private float sales;

	public Director(String name, String surName, String position, String department, float monthlyRate,
			float percentFromSales, float sales) {
		super(name, surName, position, department);
		this.monthlyRate = monthlyRate;
		this.percentFromSales = percentFromSales;
		this.sales = sales;
	}

	public float getMonthlyRate() {
		return monthlyRate;
	}

	public void setMonthlyRate(float monthlyRate) {
		this.monthlyRate = monthlyRate;
	}

	public float getPercentFromSales() {
		return percentFromSales;
	}

	public void setPercentFromSales(float percentFromSales) {
		this.percentFromSales = percentFromSales;
	}

	public float getSales() {
		return sales;
	}

	public void setSales(float sales) {
		this.sales = sales;
	}

	public float getSalary() {
		return monthlyRate + percentFromSales * sales / 100;
	}

}
