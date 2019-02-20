package com.example.bean;

public class CardStockInfBean {
	private String ID;
	private String CardPrefix;
	private String CardNum;
	private String StockInDate;
	private String CardStatus;

	public CardStockInfBean(String ID, String cardPrefix, String cardNum, String stockInDate, String cardStatus) {
		this.ID = ID;
		CardPrefix = cardPrefix;
		CardNum = cardNum;
		StockInDate = stockInDate;
		CardStatus = cardStatus;
	}

	public CardStockInfBean() {
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getCardPrefix() {
		return CardPrefix;
	}

	public void setCardPrefix(String cardPrefix) {
		CardPrefix = cardPrefix;
	}

	public String getCardNum() {
		return CardNum;
	}

	public void setCardNum(String cardNum) {
		CardNum = cardNum;
	}

	public String getStockInDate() {
		return StockInDate;
	}

	public void setStockInDate(String stockInDate) {
		StockInDate = stockInDate;
	}

	public String getCardStatus() {
		return CardStatus;
	}

	public void setCardStatus(String cardStatus) {
		CardStatus = cardStatus;
	}
}
