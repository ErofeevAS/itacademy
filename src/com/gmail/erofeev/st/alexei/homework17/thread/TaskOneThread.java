package com.gmail.erofeev.st.alexei.homework17.thread;

import com.gmail.erofeev.st.alexei.homework17.FileService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class TaskOneThread implements Runnable {
    private FileService fileService;
    private String fileName;
    private String newFileName;

    public TaskOneThread(FileService fileService, String fileName, String newFileName) {
        this.fileService = fileService;
        this.fileName = fileName;
        this.newFileName = newFileName;
    }

    @Override
    public void run() {
        List<String> flies = fileService.readFile(fileName);
        List<String> filesWithOutExtension = getFileWithOutExtension(flies);
        fileService.writeFile(filesWithOutExtension, newFileName, false);
        File newFile = new File(newFileName);
        System.out.println("file size is " + newFile.length() + " bytes");

    }

    private List<String> getFileWithOutExtension(List<String> text) {
        List<String> filesList = new ArrayList<>();
        for (String line : text) {
            if (line.indexOf('.') == -1) {
                filesList.add(line);
            }
        }
        return filesList;
    }


}
