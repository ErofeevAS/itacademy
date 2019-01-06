package com.gmail.erofeev.st.alexei.homework9.task2;

public class RussianAutomobile extends Automobile{
	
	int getRate() {	
		return 1;
	}	
	public String getDescription() {
		String str = super.getDescription();		
		return str.concat(" Моя страна - Россия. Рейтинг автомобиля:").concat(String.valueOf(getRate()));
	}

}
