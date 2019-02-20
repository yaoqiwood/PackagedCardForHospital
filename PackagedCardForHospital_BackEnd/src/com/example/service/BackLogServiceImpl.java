package com.example.service;

import com.example.dao.RoleMTableDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class BackLogServiceImpl implements BackLogService {
	@Override
	public int BackLogAdd(String username, String add_uAccount) {
		String sql = "INSERT INTO T_BACK_LOG (B_ID,B_EXECUTORID,B_CTIME,B_EVENT) VALUES (SEQ_T_BACK_LOG.nextval,?,SYSDATE,?)";
		RoleMTableDaoImpl roleMTableDao = new RoleMTableDaoImpl();
		List<String> params = new ArrayList<>();
		if (username != null && (!username.trim().equals(""))) {
			params.add(username);
			params.add("添加了用户名：" + add_uAccount + " 的数据");
			return roleMTableDao.addBackLog(sql, params);
		}
		return 0;
	}

	@Override
	public int BackLogUpdate(String username, String update_uAccount) {
		String sql = "INSERT INTO T_BACK_LOG (B_ID,B_EXECUTORID,B_CTIME,B_EVENT) VALUES (SEQ_T_BACK_LOG.nextval,?,SYSDATE,?)";
		RoleMTableDaoImpl roleMTableDao = new RoleMTableDaoImpl();
		List<String> params = new ArrayList<>();
		if (username != null && (!username.trim().equals(""))) {
			params.add(username);
			params.add("修改了用户名：" + update_uAccount + " 的数据");
			return roleMTableDao.addBackLog(sql, params);
		}
		return 0;
	}

	@Override
	public int BackLogCardStockingIN(String userID, String COUNTStart, String COUNTEnd) {
		String sql = "INSERT INTO T_BACK_LOG (B_ID,B_EXECUTORID,B_CTIME,B_EVENT) VALUES (SEQ_T_BACK_LOG.nextval,?,SYSDATE,?)";
		RoleMTableDaoImpl roleMTableDao = new RoleMTableDaoImpl();
		List<String> params = new ArrayList<>();
		if (userID != null && (!userID.trim().equals(""))) {
			params.add(userID);
			params.add("添加了：" + COUNTStart + "-" + COUNTEnd + " 号卡的数据");
			return roleMTableDao.addBackLog(sql, params);
		}
		return 0;
	}

	@Override
	public int BackBanNorNot(String userID, String state, String uaccount) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO T_BACK_LOG (B_ID,B_EXECUTORID,B_CTIME,B_EVENT) VALUES (SEQ_T_BACK_LOG.nextval,?,SYSDATE,?)";
		RoleMTableDaoImpl roleMTableDao = new RoleMTableDaoImpl();
		List<String> params = new ArrayList<>();
		params.add(userID);
		if (state.equals("1")) {
			params.add(uaccount + "账号状态被启用");
		} else {
			params.add(uaccount + "账号状态被禁用");
		}
		return roleMTableDao.addBackLog(sql, params);
	}

	@Override
	public int BackAllUser(String userID, String Event) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO T_BACK_LOG (B_ID,B_EXECUTORID,B_CTIME,B_EVENT) VALUES (SEQ_T_BACK_LOG.nextval,?,SYSDATE,?)";
		RoleMTableDaoImpl roleMTableDao = new RoleMTableDaoImpl();
		List<String> params = new ArrayList<>();
		if (userID!=null && (!userID.trim().equals(""))) {
			params.add(userID);
		}
		if (Event!=null && (!Event.trim().equals(""))) {
			params.add(Event);
		}
		return roleMTableDao.addBackLog(sql, params);
	}

	@Override
	public int intBackAllUserState(String userID, String Event, String State) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO T_BACK_LOG (B_ID,B_EXECUTORID,B_CTIME,B_EVENT,B_STATE) VALUES (SEQ_T_BACK_LOG.nextval,?,SYSDATE,?,?)";
		RoleMTableDaoImpl roleMTableDao = new RoleMTableDaoImpl();
		List<String> params = new ArrayList<>();
		if (userID!=null && (!userID.trim().equals(""))) {
			params.add(userID);
		}
		if (Event!=null && (!Event.trim().equals(""))) {
			params.add(Event);
		}
		if (State!=null && (!State.trim().equals(""))) {
			params.add(State);
		}
		return roleMTableDao.addBackLog(sql, params);
	}
	
	
}
