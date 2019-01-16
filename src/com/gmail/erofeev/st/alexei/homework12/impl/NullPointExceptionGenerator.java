package com.gmail.erofeev.st.alexei.homework12.impl;

public class NullPointExceptionGenerator {
    public void generateNPE() {
        String str = null;
        str.equals("str");
    }
}
