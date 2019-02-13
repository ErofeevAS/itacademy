package com.gmail.erofeev.st.alexei.controlworkTwo;

import java.util.List;

public interface RandomService {
    List<Integer> getRandomList(int size, int start, int stop);

    int getRandomInt(int start, int stop);
}
