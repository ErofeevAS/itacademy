package com.gmail.erofeev.st.alexei.homework12.app;

import com.gmail.erofeev.st.alexei.homework12.IConsoleService;
import com.gmail.erofeev.st.alexei.homework12.enums.Volume;
import com.gmail.erofeev.st.alexei.homework12.exceptions.MyFirstException;
import com.gmail.erofeev.st.alexei.homework12.exceptions.MySecondException;
import com.gmail.erofeev.st.alexei.homework12.exceptions.MyThirdException;
import com.gmail.erofeev.st.alexei.homework12.impl.ConsoleServiceImpl;
import com.gmail.erofeev.st.alexei.homework12.impl.MediaBox;
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
        consoleService.generateException();

        MediaBox mediaBox = new MediaBox(Volume.LOW);
        mediaBox.increaseVolume();
        mediaBox.increaseVolume();
        mediaBox.increaseVolume();
        mediaBox.increaseVolume();
        mediaBox.decreaseVolume();
        mediaBox.decreaseVolume();
        mediaBox.decreaseVolume();
        mediaBox.decreaseVolume();


    }
}
