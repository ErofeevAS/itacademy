package com.gmail.erofeev.st.alexei.homework11.impl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import com.gmail.erofeev.st.alexei.homework11.IConsoleService;

public class ConsoleServiceImpl implements IConsoleService {

	public final static String STOP = "stop";

	private Scanner scanner;

	public ConsoleServiceImpl(Scanner scanner) {
		this.scanner = scanner;
	}

	@Override
	public Set<String> getSetFromConsole() {
		Set<String> lines = new HashSet<String>();
		while (true) {
			System.out.println("Enter string:");
			String line = scanner.nextLine();
			if (line.equals(STOP)) {
				break;
			} else {
				lines.add(line);
			}

		}
		return lines;
	}

}
