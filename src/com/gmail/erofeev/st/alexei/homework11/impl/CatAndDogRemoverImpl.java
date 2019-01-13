package com.gmail.erofeev.st.alexei.homework11.impl;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.gmail.erofeev.st.alexei.homework11.ICatAndDogRemover;

public class CatAndDogRemoverImpl implements ICatAndDogRemover {
	public final static String WORDONE = "cat";
	public final static String WORDTWO = "dog";

	@Override
	public Set<String> removeCatAndDog(Set<String> lines) {
		Set<String> newLines = new HashSet<String>(lines);
		Iterator<String> iterator = newLines.iterator();
		while (iterator.hasNext()) {
			String line = iterator.next();
			if (line.contains(WORDONE) || (line.contains(WORDTWO))) {
				iterator.remove();
			}
		}
		return newLines;
	}

}
