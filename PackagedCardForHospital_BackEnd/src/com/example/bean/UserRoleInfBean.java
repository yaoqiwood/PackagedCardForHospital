package com.example.bean;

public class UserRoleInfBean {
	private String ID;
	private String Name;
	private String Sex;
	private String Age;
	private String Account;
	private String PWD;
	private String Role;
	private String Department;
	private String State;
	private String CTIME;
	private String Remark;
	private String DepartmentID;
	private String RoleID;

	public UserRoleInfBean(String ID, String name, String sex, String age, String account, String PWD, String role, String department, String state, String CTIME, String remark, String departmentID, String roleID) {
		this.ID = ID;
		Name = name;
		Sex = sex;
		Age = age;
		Account = account;
		this.PWD = PWD;
		Role = role;
		Department = department;
		State = state;
		this.CTIME = CTIME;
		Remark = remark;
		DepartmentID = departmentID;
		RoleID = roleID;
	}

	public UserRoleInfBean() {
	}

	public String getID() {
		return ID;
	}

	public void setID(String ID) {
		this.ID = ID;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSex() {
		return Sex;
	}

	public void setSex(String sex) {
		Sex = sex;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public String getAccount() {
		return Account;
	}

	public void setAccount(String account) {
		Account = account;
	}

	public String getPWD() {
		return PWD;
	}

	public void setPWD(String PWD) {
		this.PWD = PWD;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

	public String getDepartment() {
		return Department;
	}

	public void setDepartment(String department) {
		Department = department;
	}

	public String getState() {
		return State;
	}

	public void setState(String state) {
		State = state;
	}

	public String getCTIME() {
		return CTIME;
	}

	public void setCTIME(String CTIME) {
		this.CTIME = CTIME;
	}

	public String getRemark() {
		return Remark;
	}

	public void setRemark(String remark) {
		Remark = remark;
	}

	public String getDepartmentID() {
		return DepartmentID;
	}

	public void setDepartmentID(String departmentID) {
		DepartmentID = departmentID;
	}

	public String getRoleID() {
		return RoleID;
	}

	public void setRoleID(String roleID) {
		RoleID = roleID;
	}
}
