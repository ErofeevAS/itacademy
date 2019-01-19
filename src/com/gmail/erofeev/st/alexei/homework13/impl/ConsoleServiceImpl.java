package com.gmail.erofeev.st.alexei.homework13.impl;

import com.gmail.erofeev.st.alexei.homework13.IConsoleService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public  class ConsoleServiceImpl implements IConsoleService {
    @Override
    public String readLine(String message) {
        System.out.println(message);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = "";
        try {
            line = reader.readLine();
        } catch (IOException e) {
            System.out.println("cant readline");
        }
        return line;
    }

    @Override
    public int readInt(String message) {
        return Integer.parseInt(readLine(message));
    }
}