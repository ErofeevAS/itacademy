package com.gmail.erofeev.st.alexei.controlwork2.app;

import com.gmail.erofeev.st.alexei.controlwork2.ArrayService;
import com.gmail.erofeev.st.alexei.controlwork2.ConsoleService;
import com.gmail.erofeev.st.alexei.controlwork2.FileService;
import com.gmail.erofeev.st.alexei.controlwork2.ThreadService;
import com.gmail.erofeev.st.alexei.controlwork2.impl.ArrayServiceImpl;
import com.gmail.erofeev.st.alexei.controlwork2.impl.ConsoleServiceImpl;
import com.gmail.erofeev.st.alexei.controlwork2.impl.FileServiceImpl;
import com.gmail.erofeev.st.alexei.controlwork2.impl.ThreadServiceImpl;
import com.gmail.erofeev.st.alexei.controlwork2.thread.TaskTwoReaderThread;
import com.gmail.erofeev.st.alexei.controlwork2.thread.TaskTwoWriterThread;


import java.io.File;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Runner {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //task1
//        ConsoleService console = new ConsoleServiceImpl();
//        int n = console.getInt("Enter amount of thread:");
//
//        ThreadService threadService = ThreadServiceImpl.getInstance();
//        File file = new File("task1.txt");
//        threadService.startThreads(n, file);

        //task2
        File task2 = new File("task2.txt");


        ExecutorService executorReader = Executors.newFixedThreadPool(2);
        Future<Integer> future = executorReader.submit(new TaskTwoReaderThread(task2));
        executorReader.shutdown();

        Thread.sleep(100);


        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new TaskTwoWriterThread(task2, 10, 1, 100));
        executorService.shutdown();


        while(!future.isDone()){

        }
        System.out.println("max "+future.get());
      //  System.out.println(future.get());


    }
}
