package com.example.dao;

import com.example.bean.UserLoginInfBean;

import java.util.List;

public interface UserLoginDao {
	//  用户登录
	public UserLoginInfBean UserLogin(String sql, List<String> params);
	//  获取角色ID
	public String viewRoleID(String sql,List<String> params);

	//  密码修改(查询是否正确)
	public int checkOriPWD(String sql,List<String> params);

	public int uptatePWD(String sql,List<String> params);

}
