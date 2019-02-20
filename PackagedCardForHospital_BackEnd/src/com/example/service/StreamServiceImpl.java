package com.example.service;

import com.example.bean.CardCensusInfBean;
import com.example.bean.WorkCensusInfBean;
import com.example.dao.CardDaoImpl;
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

		for (String i : params) {
			System.out.println(i);
		}
		return new StreamDaoImpl().insertFundStreamRe(sql, params);
	}

	@Override
	public List<WorkCensusInfBean> viewWorkCenInf(String timeDateStart, String timeDateEND, String workman,
			int CurrentPage, int Limit) {
		String sql = "  SELECT COUNT(0) Count,B_EXECUTORID,B_STATE FROM T_BACK_LOG "
				+ "  A INNER JOIN T_USER B ON A.B_EXECUTORID = B.U_ID WHERE 1=1 AND B.U_ROLE_ID = 3 AND B_STATE>0 ";
		List<String> params = new ArrayList<>();
		if (timeDateStart != null && timeDateEND != null && (!timeDateStart.trim().equals(""))
				&& (!timeDateEND.trim().equals(""))) {
			sql += " AND TO_CHAR(A.B_CTIME,'YYYY-MM-DD')  BETWEEN ? AND ? ";
			params.add(timeDateStart);
			params.add(timeDateEND);
		}

		if (workman != null && (!workman.trim().equals(""))) {
			sql += " AND B_EXECUTORID = ? ";
			params.add(workman);
		}

		sql = " SELECT * FROM ( " + " SELECT A.*,ROWNUM RN FROM ( "
				+ " SELECT A.B_EXECUTORID,SUM(DECODE(A.B_STATE,1,A.Count)) AS SOLD_CARD, "
				+ "       SUM(DECODE(A.B_STATE,2,A.Count)) AS CHANGE_CARD, "
				+ "       SUM(DECODE(A.B_STATE,3,A.Count)) AS EXIT_CARD " + " FROM ( " + sql
				+ " GROUP BY B_EXECUTORID,B_STATE) A " + "  GROUP BY A.B_EXECUTORID ORDER BY B_EXECUTORID "
				+ "  ) A ) A WHERE 1=1 AND A.RN BETWEEN ? AND ? ";
		params.add(String.valueOf(CurrentPage * Limit - (Limit - 1)));
		params.add(String.valueOf(CurrentPage * Limit));

		return new StreamDaoImpl().viewWorkCenInf(sql, params);
	}

	@Override
	public int countWorkCen(String timeDateStart, String timeDateEND, String workman) {
		String sql = "  SELECT COUNT(0) Count,B_EXECUTORID,B_STATE FROM T_BACK_LOG "
				+ "  A INNER JOIN T_USER B ON A.B_EXECUTORID = B.U_ID WHERE 1=1 AND B.U_ROLE_ID = 3 AND B_STATE>0 ";
		List<String> params = new ArrayList<>();
		if (timeDateStart != null && timeDateEND != null && (!timeDateStart.trim().equals(""))
				&& (!timeDateEND.trim().equals(""))) {
			sql += " AND TO_CHAR(A.B_CTIME,'YYYY-MM-DD')  BETWEEN ? AND ? ";
			params.add(timeDateStart);
			params.add(timeDateEND);
		}

		if (workman != null && (!workman.trim().equals(""))) {
			sql += " AND B_EXECUTORID = ? ";
			params.add(workman);
		}

		sql = "SELECT COUNT(0) Count FROM ( " + "SELECT A.B_EXECUTORID,SUM(DECODE(A.B_STATE,1,A.Count)) AS SOLD_CARD, "
				+ "       SUM(DECODE(A.B_STATE,2,A.Count)) AS CHANGE_CARD, "
				+ "       SUM(DECODE(A.B_STATE,3,A.Count)) AS EXIT_CARD " + "FROM (" + sql
				+ " GROUP BY B_EXECUTORID,B_STATE) A " + "  GROUP BY A.B_EXECUTORID ORDER BY B_EXECUTORID " + "  ) A";

		return new CardDaoImpl().CountAnyInf(sql, params);
	}

}
