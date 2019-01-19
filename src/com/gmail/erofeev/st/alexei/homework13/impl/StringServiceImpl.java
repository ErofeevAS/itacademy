package com.gmail.erofeev.st.alexei.homework13.impl;

import com.gmail.erofeev.st.alexei.homework13.IStringService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class StringServiceImpl implements IStringService {
    private String[] punctuationMarks = {",", ".", ":", ";", ")", "(", "!", "?", " ", "\\n", "\\r"};

    @Override
    public String[] removeWords(String[] lines, int min, int max) {
        String[] newLines = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            List<String> words = new ArrayList<String>(Arrays.asList(lines[i].split(" ")));
            Iterator<String> it = words.iterator();
            while (it.hasNext()) {
                String word = it.next();
                int wordLength = word.length() - getPunctuationMarks(word);
                if (wordLength >= min && wordLength <= max) {
                    it.remove();
                }
            }
            for (String word : words) {
                newLines[i] += word + " ";
            }

        }
        return newLines;
    }

    private int getPunctuationMarks(String word) {
        int counter = 0;
        for (String punctuationMark : punctuationMarks) {
            if (word.contains(punctuationMark)) {
                counter++;
            }
        }
        return counter;
    }
}
