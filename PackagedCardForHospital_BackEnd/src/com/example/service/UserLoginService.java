package com.example.service;

import com.example.bean.UserLoginInfBean;

import java.util.List;

public interface UserLoginService {
	public UserLoginInfBean UserLogin(String username, String password);

	public String viewRoleID(String ID);

	public int checkOriPWD(String UID, String NPWD);

	public int uptatePWD(String UID, String NPWD);
}
