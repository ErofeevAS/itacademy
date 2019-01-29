package com.gmail.erofeev.st.alexei.homework19;

import com.gmail.erofeev.st.alexei.homework19.enums.ListType;

import java.util.List;

public interface ListFactory {

    List<Integer> generateList(ListType type);
}
