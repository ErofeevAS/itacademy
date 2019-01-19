package com.gmail.erofeev.st.alexei.homework12.impl;

import com.gmail.erofeev.st.alexei.homework12.IConsoleService;
import com.gmail.erofeev.st.alexei.homework12.exceptions.MyFirstException;
import com.gmail.erofeev.st.alexei.homework12.exceptions.MySecondException;
import com.gmail.erofeev.st.alexei.homework12.exceptions.MyThirdException;

import java.util.Scanner;

public class ConsoleServiceImpl implements IConsoleService {

    private Scanner scanner;


    public ConsoleServiceImpl(Scanner scanner) {
        this.scanner = scanner;
    }


    private String getStringFromConsole() {
        return scanner.nextLine();
    }

    @Override
    public void generateException() {
        while (true) {
            try {
                System.out.println("Enter 1/2/3/0:");
                String line = getStringFromConsole();
                if (line.equals("0")) {
                    System.out.println("You left infinity loop");
                    break;
                } else {
                    switch (line) {
                        case "1":
                            throw new MyFirstException();
                        case "2":
                            throw new MySecondException();
                        case "3":
                            throw new MyThirdException();
                        default:
                            System.out.println("Incorrect data! Enter 1 or 2 or 3 or 0");
                    }
                }
            } catch (RuntimeException e) {
                System.out.println(e);
            }
        }
    }

}
