package com.example.bean;

public class ArrInfBean {
//	        <!-- 选择 	ID 	医生 科室 排班时间 	状态 	操作-->
	private String ID;
	private String Doctor;
	private String Department;
	private String ATIME;
	private String State;
	private String CTIME;

	public ArrInfBean(String ID, String doctor, String department, String ATIME, String state) {
		this.ID = ID;
		Doctor = doctor;
		Department = department;
		this.ATIME = ATIME;
		State = state;
	}

	public ArrInfBean() {
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getDoctor() {
		return Doctor;
	}

	public void setDoctor(String doctor) {
		Doctor = doctor;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getATIME() {
		return ATIME;
	}

	public void setATIME(String ATIME) {
		this.ATIME = ATIME;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}
}
