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

    @Override
    public String getStringFromConsole() {
        System.out.println("Enter string:");
        return scanner.nextLine();
    }

    @Override
    public void generateException() {

    }

}
