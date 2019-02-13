package com.gmail.erofeev.st.alexei.controlworkTwo.thread;

import com.gmail.erofeev.st.alexei.controlworkTwo.FileService;
import com.gmail.erofeev.st.alexei.controlworkTwo.impl.FileServiceImpl;

import java.io.File;
import java.util.List;

public class CreateFileThread implements Runnable {
    private File file;
    private List<Integer> list;
    private FileService fileService = FileServiceImpl.getInstance();

    public CreateFileThread(File file, List<Integer> list) {
        this.file = file;
        this.list = list;
    }

    @Override
    public void run() {
        System.out.println(file + " start written");
        fileService.writeFile(file, list, false);
        System.out.println(file +  "was written");
    }
}
