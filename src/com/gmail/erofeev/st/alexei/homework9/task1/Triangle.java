package com.gmail.erofeev.st.alexei.homework9.task1;

public class Triangle extends Shape{	
	private double a;
	private double b;	
	private double c;	
	
	public Triangle(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}
	public double getSquare() {		
		double p = (a+b+c)/2;
		double s = Math.sqrt(p*(p-a)*(p-b)*(p-c));
		return s;
	}
	
	public double getPerimeter() {		
		return a+b+c;
	}

}
