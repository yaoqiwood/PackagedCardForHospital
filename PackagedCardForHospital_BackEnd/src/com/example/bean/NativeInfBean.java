package com.example.bean;

public class NativeInfBean {
	private String ID;
	private String NativeName;

	public NativeInfBean(String ID, String nativeName) {
		this.ID = ID;
		NativeName = nativeName;
	}

	public NativeInfBean() {
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getNativeName() {
		return NativeName;
	}

	public void setNativeName(String nativeName) {
		NativeName = nativeName;
	}
}
