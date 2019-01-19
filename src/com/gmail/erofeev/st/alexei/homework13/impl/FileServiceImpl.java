package com.gmail.erofeev.st.alexei.homework13.impl;

import com.gmail.erofeev.st.alexei.homework13.IConsoleService;
import com.gmail.erofeev.st.alexei.homework13.IFileService;

import java.io.*;

public class FileServiceImpl implements IFileService {
    @Override
    public String[] readFile(File file) {
        StringBuffer sb = new StringBuffer();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line = reader.readLine();
            while (line != null) {
                sb.append(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Can't change file");
        }
        return sb.toString().split(System.lineSeparator());
    }

    @Override
    public void writeFile(File file, String[] text, boolean append) {
        File folders = new File(file.getParent());
        if (folders.mkdirs()) {
            System.out.println("Folders was created:" + folders);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
            for (String line : text) {
                writer.write(line);
                writer.write(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Can't write");
        }

    }

    @Override
    public void writeFile(File file, String text, boolean append) {
        File folders = new File(file.getParent());
        if (folders.mkdirs()) {
            System.out.println("Folders was created:" + folders);
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, append))) {
            writer.write(text);
        } catch (IOException e) {
            System.out.println("Can't write");
        }
    }


}
