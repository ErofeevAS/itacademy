package com.gmail.erofeev.st.alexei.homework10;

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

	public void addNewStrings(int amount) {
		System.out.println("Enter " + amount + " lines:");
		for (int i = 0; i < amount; i++) {
			lines.add(scanner.nextLine());
		}
	}

	public void replacePluses() {
		for (String line : lines) {
			line = line.replaceAll("\\+", "+++");
			System.out.println(line);
		}
	}

}
