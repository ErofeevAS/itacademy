package com.gmail.erofeev.st.alexei.homework3;

public class CreditCard {
	private long accountNumber;
	private int amount;

	public CreditCard() {
		super();
	}

	public CreditCard(long accountNumber, int amount) {
		super();
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void putMoney(int money) {
		amount += money;
	}

	public void takeOffMoney(int money) {
		amount -= money;
	}

	public void showInfo() {
		System.out.println("account: " + accountNumber + " have: " + amount + "$");
	}

}
