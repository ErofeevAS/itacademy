package com.gmail.erofeev.st.alexei.controlTwo.app;

import com.gmail.erofeev.st.alexei.controlTwo.*;
import com.gmail.erofeev.st.alexei.controlTwo.enums.XMLParser;
import com.gmail.erofeev.st.alexei.controlTwo.impl.*;
import com.gmail.erofeev.st.alexei.controlTwo.parser.XMLParserFactoryImpl;
import com.gmail.erofeev.st.alexei.controlTwo.thread.TaskOneThread;
import com.gmail.erofeev.st.alexei.homework21.util.XMLValidatorUtil;

import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutorService;

public class Runner {
    public static volatile int countOfWriterThread = 0;

    public static void main(String[] args) throws InterruptedException {

        //task1
//        String text = "In any programming language arrays are used that are convenient for working with a large number of the same type of data";
//        ConsoleService console = ConsoleServiceImpl.getInstance();
//        int amount = console.getInt("enter amount of thread");
//        String fileName = "task1";
//        ThreadRunnerService threadRunnerService = new ThreadRunnerServiceImpl();
//        threadRunnerService.startThreads(amount, fileName, text);

        //task2

//        WriteReadFileService writeReadFileService = WriteReadFileServiceImpl.getInstance();
//        List<File> files = writeReadFileService.startWrite(5);
//        List<String> names = writeReadFileService.startRead(files,5);

        //task3
        File xml = new File("src/com/gmail/erofeev/st/alexei/controlTwo/files/PurchaseOrder.xml");
        File xsd = new File("src/com/gmail/erofeev/st/alexei/controlTwo/files/PurchaseOrder.xsd");
        XMLParserFactory factory = new XMLParserFactoryImpl();
        ParserService domParser = factory.getXMLParser(XMLParser.DOM);
        System.out.println("DOM");
        System.out.println(domParser.parse(xml, xsd));

        System.out.println("STAX");
        ParserService staxParser = factory.getXMLParser(XMLParser.STAX);
        System.out.println(staxParser.parse(xml, xsd));

        ParserService jaxbParser = factory.getXMLParser(XMLParser.JAXB);
        System.out.println(jaxbParser.parse(xml, xsd));

    }
}
