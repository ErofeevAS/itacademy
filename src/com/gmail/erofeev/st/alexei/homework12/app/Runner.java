package com.gmail.erofeev.st.alexei.homework12.app;

import com.gmail.erofeev.st.alexei.homework12.IConsoleService;
import com.gmail.erofeev.st.alexei.homework12.exceptions.MyFirstException;
import com.gmail.erofeev.st.alexei.homework12.exceptions.MySecondException;
import com.gmail.erofeev.st.alexei.homework12.exceptions.MyThirdException;
import com.gmail.erofeev.st.alexei.homework12.impl.ConsoleServiceImpl;
import com.gmail.erofeev.st.alexei.homework12.impl.NullPointExceptionGenerator;
import com.gmail.erofeev.st.alexei.homework7.ConsoleService;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

//        NullPointExceptionGenerator nullPointExceptionGenerator = new NullPointExceptionGenerator();
//        try{
//            nullPointExceptionGenerator.generateNPE();
//        }
//        catch (NullPointerException e){
//            System.out.println(e.getMessage());
//            e.printStackTrace();
//        }

        IConsoleService consoleService = new ConsoleServiceImpl(new Scanner(System.in));

        while (true) {
            try {
                System.out.println("Enter 1/2/3/0:");
                String line = consoleService.getStringFromConsole();
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
                            System.out.println("Enter 1 or 2 or 3 or 0");
                    }
                }
            } catch (RuntimeException e) {
                System.out.println(e);
            }
        }


    }
}
