package com.gmail.erofeev.st.alexei.homework9.task2;

public class EnglandAutomobile extends Automobile{	
	int getRate() {		
		return 5;
	}		
	public String getDescription() {
		String str = super.getDescription();		
		return str.concat(" ��� ������ - ������. ������� ����������:").concat(String.valueOf(getRate()));
	}
	
}
