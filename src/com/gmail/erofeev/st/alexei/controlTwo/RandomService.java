package com.gmail.erofeev.st.alexei.controlTwo;

import com.gmail.erofeev.st.alexei.controlTwo.model.Player;

import java.util.List;

public interface RandomService {
    List<Integer> getRandomArray(int size, int rangeStart, int rangeStop);

    int getRandomInt(int rangeStart, int rangeStop);

    List<Player> getPlayers(int size, int minAge, int maxAge);
}
