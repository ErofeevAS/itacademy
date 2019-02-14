package com.gmail.erofeev.st.alexei.controlTwo.impl;

import com.gmail.erofeev.st.alexei.controlTwo.ConsoleService;
import com.gmail.erofeev.st.alexei.homework19.RandomService;
import com.gmail.erofeev.st.alexei.homework21.BookService;
import com.gmail.erofeev.st.alexei.homework21.impl.BookServiceImpl;

import java.util.Scanner;

public class ConsoleServiceImpl implements ConsoleService {
    private Scanner scanner = new Scanner(System.in);
    private static volatile ConsoleService instance = null;

    private ConsoleServiceImpl() {
    }

    public static ConsoleService getInstance() {
        if (instance == null) {
            synchronized (ConsoleService.class) {
                if (instance == null) {
                    instance = new ConsoleServiceImpl();
                }
            }
        }
        return instance;
    }

    @Override
    public int getInt(String message) {
        System.out.println(message);
        int number = scanner.nextInt();
        scanner.nextLine();
        return number;
    }
}
