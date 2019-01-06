package com.gmail.erofeev.st.alexei.homework9.task3;

public class Worker extends Employee{
	private float hourPrice;
	private float hours;		
	
	public Worker(String name, String surName, String position, String department, float hourPrice, float hours) {
		super(name, surName, position, department);
		this.hourPrice = hourPrice;
		this.hours = hours;
	}

	public float getHourPrice() {
		return hourPrice;
	}	

	public void setHourPrice(float hourPrice) {
		this.hourPrice = hourPrice;
	}

	public float getHours() {
		return hours;
	}

	public void setHours(float hours) {
		this.hours = hours;
	}
	
	public float getSalary() {		
		return hourPrice*hours;
	}

}
