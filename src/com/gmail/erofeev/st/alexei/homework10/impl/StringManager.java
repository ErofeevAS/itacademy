package com.gmail.erofeev.st.alexei.homework10.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StringManager {

	private Scanner scanner;
	private List<String> lines;

	public StringManager(Scanner scanner) {
		this.scanner = scanner;
		lines = new ArrayList<>();
	}

	public List<String> getLines() {
		return lines;
	}

	public void setLines(List<String> lines) {
		this.lines = lines;
	}

	public void addNewStrings(int amount) {
		System.out.println("Enter " + amount + " lines:");
		for (int i = 0; i < amount; i++) {
			lines.add(scanner.nextLine());
		}
	}

	public void replacePluses() {
		for (int i = 0; i < lines.size(); i++) {
			String newLine = lines.get(i).replace("+", "+++");
			lines.remove(i);
			lines.add(i, newLine);
		}
	}

}
