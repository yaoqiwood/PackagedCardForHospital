package com.example.bean;

public class UserMessageBean {
	private String ID;
	private String Message;
	private String Location;

	public UserMessageBean(String ID, String message, String location) {
		this.ID = ID;
		Message = message;
		Location = location;
	}

	public UserMessageBean() {
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}
}

