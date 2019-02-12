package com.gmail.erofeev.st.alexei.practice;

import java.util.List;

public interface RandomService {

    List<Integer> getRandomArray(int size, int rangeStart, int rangeStop);

    int getRandomInt(int rangeStart, int rangeStop);

}
