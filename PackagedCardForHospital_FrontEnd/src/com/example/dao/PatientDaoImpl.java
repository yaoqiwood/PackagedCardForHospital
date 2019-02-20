package com.example.dao;

import com.example.bean.CardAccCheckInfBean;
import com.example.bean.PatientInfBean;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDaoImpl implements PatientDao {
	@Override
	public List<PatientInfBean> viewPatientInf(String sql, String CardNUM) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<PatientInfBean> patientInfBeans = new ArrayList<>();

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, CardNUM);
			set = pstm.executeQuery();
			while (set.next()) {
				String P_ID = set.getString("P_ID");
				String sold_name = set.getString("P_NAME");
				String sold_age = set.getString("P_AGE");
				String sex = set.getString("P_SEX");
				String U_native = set.getString("P_NATIVE");
				String idNum = set.getString("P_IDNUMBER");
				String phone = set.getString("P_PHONE");
				String address = set.getString("P_ADDR");
				String preStore = set.getString("C_AMOUNT");
				String deposit = set.getString("C_DEPOSIT");
				patientInfBeans.add(new PatientInfBean(P_ID, sold_name, sold_age, sex, U_native, idNum, phone, address,
						preStore, deposit));
			}
			return patientInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public int topUpPatientCard(String sql, String CardNum, String MoneyNum) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, CardNum);
			pstm.setString(2, MoneyNum);
			pstm.setString(3, CardNum);
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	@Override
	public String viewAnyString(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			if (set.next()) {
				return set.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public List<CardAccCheckInfBean> viewAccCheckTable(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<CardAccCheckInfBean> cardAccCheckInfBeans = new ArrayList<>();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String WhenTime = set.getString("S_CTIME");
				String Event = set.getString("S_EVENT");
				String Amount = set.getString("S_AMOUNT");
				String Executor = set.getString("U_NAME");
				cardAccCheckInfBeans.add(new CardAccCheckInfBean(WhenTime, Event, Amount, Executor));
			}
			return cardAccCheckInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public int viewAnyInt(String sql, List<String> params) {
		// TODO Auto-generated method stub
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			if (set.next()) {
				return set.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}

		return 0;
	}
}
