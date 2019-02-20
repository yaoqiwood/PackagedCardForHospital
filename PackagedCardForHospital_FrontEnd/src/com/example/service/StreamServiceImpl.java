package com.example.service;

import com.example.dao.StreamDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class StreamServiceImpl implements StreamService {

	@Override
	public int insertFundStreamRe(String S_EVENT, String S_CID, String S_PID, String S_UID, String S_AMOUNT,
	                              String S_STATE, String S_CTIME, String S_REMARK) {
		String sql = " INSERT INTO T_STREAM VALUES (SEQ_T_STREAM.nextval,?,?,?,?,?,?,SYSDATE,?) ";
		List<String> params = new ArrayList<>();
		params.add(S_EVENT);
		params.add(S_CID);
		params.add(S_PID);
		params.add(S_UID);
		params.add(S_AMOUNT);
		params.add(S_STATE);
		params.add(S_REMARK);

		for (String i:params){
			System.out.println(i);
		}
		return new StreamDaoImpl().insertFundStreamRe(sql,params);
	}
	
	@Override
	public int BackAllUser(String userID, String Event) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO T_BACK_LOG (B_ID,B_EXECUTORID,B_CTIME,B_EVENT) VALUES (SEQ_T_BACK_LOG.nextval,?,SYSDATE,?)";
		List<String> params = new ArrayList<>();
		if (userID!=null && (!userID.trim().equals(""))) {
			params.add(userID);
		}
		if (Event!=null && (!Event.trim().equals(""))) {
			params.add(Event);
		}
		return new StreamDaoImpl().addBackLog(sql, params);
	}
}
