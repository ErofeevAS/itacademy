package com.gmail.erofeev.st.alexei.controlwork2.impl;

import com.gmail.erofeev.st.alexei.controlwork2.ConsoleService;

import java.io.Console;
import java.util.Scanner;

public class ConsoleServiceImpl implements ConsoleService {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public int getInt(String message) {
        System.out.println(message);
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}
