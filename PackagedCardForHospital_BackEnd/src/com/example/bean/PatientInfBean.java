package com.example.bean;

public class PatientInfBean {
	private String sold_name;
	private String sold_age;
	private String sex;
	private String U_native;
	private String idNum;
	private String phone;
	private String address;
	private String preStore;
	private String deposit;

	public PatientInfBean(String sold_name, String sold_age, String sex, String u_native, String idNum, String phone, String address, String preStore, String deposit) {
		this.sold_name = sold_name;
		this.sold_age = sold_age;
		this.sex = sex;
		U_native = u_native;
		this.idNum = idNum;
		this.phone = phone;
		this.address = address;
		this.preStore = preStore;
		this.deposit = deposit;
	}

	public PatientInfBean() {
	}

	public String getSold_name() {
		return sold_name;
	}

	public void setSold_name(String sold_name) {
		this.sold_name = sold_name;
	}

	public String getSold_age() {
		return sold_age;
	}

	public void setSold_age(String sold_age) {
		this.sold_age = sold_age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getU_native() {
		return U_native;
	}

	public void setU_native(String u_native) {
		U_native = u_native;
	}

	public String getIdNum() {
		return idNum;
	}

	public void setIdNum(String idNum) {
		this.idNum = idNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPreStore() {
		return preStore;
	}

	public void setPreStore(String preStore) {
		this.preStore = preStore;
	}

	public String getDeposit() {
		return deposit;
	}

	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
}
