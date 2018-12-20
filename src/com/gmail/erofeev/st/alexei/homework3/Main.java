package com.gmail.erofeev.st.alexei.homework3;

public class Main {

	public static void main(String[] args) {

		CreditCard card1 = new CreditCard(1234456778998789L, 600);
		CreditCard card2 = new CreditCard(0000111122223333L, 1500);
		CreditCard card3 = new CreditCard(9999111122223333L, 1500);

		card1.putMoney(1);
		card2.putMoney(100);
		card3.takeOffMoney(1499);

		card1.showInfo();
		card2.showInfo();
		card3.showInfo();
	}

}
