package com.gmail.erofeev.st.alexei.homework9.task1;

public class Rectangle extends Shape{	
	private double a;
	private double b;	
	
	public Rectangle(double a, double b) {	
		this.a = a;
		this.b = b;
	}
	
	public double getSquare() {
		return a*b;
	}
	
	public double getPerimeter() {		
		return 2*a*b;
	}

}
