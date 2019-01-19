package com.gmail.erofeev.st.alexei.homework13.app;

import com.gmail.erofeev.st.alexei.homework13.IArrayService;
import com.gmail.erofeev.st.alexei.homework13.IConsoleService;
import com.gmail.erofeev.st.alexei.homework13.IFileService;
import com.gmail.erofeev.st.alexei.homework13.IStringService;
import com.gmail.erofeev.st.alexei.homework13.impl.ArrayServiceImpl;
import com.gmail.erofeev.st.alexei.homework13.impl.ConsoleServiceImpl;
import com.gmail.erofeev.st.alexei.homework13.impl.FileServiceImpl;
import com.gmail.erofeev.st.alexei.homework13.impl.StringServiceImpl;

import java.io.File;

public class Runner {
    public static void main(String[] args) {

        IFileService fileService = new FileServiceImpl();
        IConsoleService console = new ConsoleServiceImpl();

        //task1
        File file = new File("src\\com\\gmail\\erofeev\\st\\alexei\\homework13\\files\\array.txt");
        String[] text = fileService.readFile(file);
        System.out.println(text[0]);
        IArrayService arrayService = new ArrayServiceImpl();
        int[] array = arrayService.getArray(text[0]);
        arrayService.showMinElement(array);

        //task2
        int size = console.readInt("Enter array size:");
        int range = console.readInt("Enter random range:");
        int[] randomArray = arrayService.generateArray(size, range);
        arrayService.showArray(randomArray);
        File file2 = new File("src\\com\\gmail\\erofeev\\st\\alexei\\homework13\\files\\randomArray.txt");
        String line = arrayService.arrayToString(randomArray);
        fileService.writeFile(file2, line, true);

        //task3
        File file3 = new File("src\\com\\gmail\\erofeev\\st\\alexei\\homework13\\files\\text.txt");
        String[] text3 = fileService.readFile(file3);
        IStringService stringService = new StringServiceImpl();
        String[] newText = stringService.removeWords(text3, 3, 14);
        File newFile = new File("src\\com\\gmail\\erofeev\\st\\alexei\\homework13\\files\\newfolder\\newtext.txt");
        fileService.writeFile(newFile, newText, true);

    }
}
