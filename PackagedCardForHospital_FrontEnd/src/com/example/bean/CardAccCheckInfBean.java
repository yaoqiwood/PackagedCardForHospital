package com.example.bean;

public class CardAccCheckInfBean {
	private String WhenTime;
	private String Event;
	private String Amount;
	private String Executor;

	public CardAccCheckInfBean(String whenTime, String event, String amount, String executor) {
		WhenTime = whenTime;
		Event = event;
		Amount = amount;
		Executor = executor;
	}

	public CardAccCheckInfBean() {
	}

	public String getWhenTime() {
		return WhenTime;
	}

	public void setWhenTime(String whenTime) {
		WhenTime = whenTime;
	}

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}

	public String getAmount() {
		return Amount;
	}

	public void setAmount(String amount) {
		Amount = amount;
	}

	public String getExecutor() {
		return Executor;
	}

	public void setExecutor(String executor) {
		Executor = executor;
	}
}
