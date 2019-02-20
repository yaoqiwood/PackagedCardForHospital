package com.example.service;

import com.example.bean.UserLoginInfBean;
import com.example.dao.UserLoginDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class UserLoginServiceImpl implements UserLoginService {

	@Override
	public UserLoginInfBean UserLogin(String username, String password) {
		List<String> params = new ArrayList<>();
		UserLoginDaoImpl userLoginDao = new UserLoginDaoImpl();
		String sql = "SELECT * FROM T_USER WHERE U_ACCOUNT = ? AND U_PWD = ? ";
		if (username != null && password != null && (!username.trim().equals("")) && (!password.trim().equals(""))) {
			params.add(username);
			params.add(password);
			return userLoginDao.UserLogin(sql, params);
		}
		return null;
	}

	@Override
	public String viewRoleID(String ID) {
		List<String> params = new ArrayList<>();
		String sql = "SELECT U_ROLE_ID FROM T_USER WHERE U_ID = ? ";
		params.add(ID);
		return new UserLoginDaoImpl().viewRoleID(sql,params);
	}

	@Override
	public int checkOriPWD(String UID, String NPWD) {
		String sql = " SELECT * FROM T_USER WHERE U_ID = ?  AND U_PWD = ? ";
		List<String> params = new ArrayList<>();
		params.add(UID);
		params.add(NPWD);
		return new UserLoginDaoImpl().checkOriPWD(sql,params);
	}

	@Override
	public int uptatePWD(String UID, String NPWD) {
		String sql = " UPDATE T_USER SET U_PWD = ? WHERE U_ID = ? ";
		List<String> params = new ArrayList<>();
		params.add(NPWD);
		params.add(UID);
		return new UserLoginDaoImpl().uptatePWD(sql,params);
	}
}
