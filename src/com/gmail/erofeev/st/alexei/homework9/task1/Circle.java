package com.gmail.erofeev.st.alexei.homework9.task1;

public class Circle extends Shape{	
	private double r;	
	
	public Circle(double r) {		
		this.r = r;
	}

	public double getSquare() {
		return  Math.PI*r*r;
	}

	public double getPerimeter() {		
		return Math.PI*r*2;
	}
	

}
