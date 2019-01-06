package com.gmail.erofeev.st.alexei.homework9.task1;

public class Runner {

	public static void main(String[] args) {
		Shape circle1 = new Circle(5);
		Shape circle2 = new Circle(5);
		Shape triangle = new Triangle(1, 2, 2);
		Shape rectangle1 = new Rectangle(2, 3);
		Shape rectangle2 = new Rectangle(5, 10);
		Shape[] shapes = { circle1, circle2, triangle, rectangle1, rectangle2 };
		int summSquare = 0;
		int summPerimeters = 0;
		for (Shape shape : shapes) {
			summSquare += shape.getSquare();
			summPerimeters += shape.getPerimeter();
		}
		System.out.println(summSquare);
		System.out.println(summPerimeters);
	}

}
