package com.gmail.erofeev.st.alexei.homework9.task2;

public class GermanyAutomobile extends Automobile{

	int getRate() {		
		return 10;
	}
	public String getDescription() {
		String str = super.getDescription();		
		return str.concat(" ��� ������ - ��������. ������� ����������:").concat(String.valueOf(getRate()));
	}

}
