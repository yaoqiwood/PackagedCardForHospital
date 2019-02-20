package com.example.dao;

import com.example.bean.NativeInfBean;
import com.example.bean.PatientInfBean;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollectorDaoImpl implements CollectorDao {
	@Override
	public List<NativeInfBean> viewNativeInf(String sql) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<NativeInfBean> nativeInfBeans = new ArrayList<>();

		try {
			pstm = conn.prepareStatement(sql);
			set = pstm.executeQuery();
			while (set.next()) {
				nativeInfBeans.add(new NativeInfBean(set.getString("N_ID"), set.getString("N_NAME")));
			}
			return nativeInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}

		return null;
	}

	@Override
	public int addPatient(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	@Override
	public List<PatientInfBean> viewPatientInf(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<PatientInfBean> patientInfBeans = new ArrayList<>();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String sold_name = set.getString("P_NAME");
				String sold_age = set.getString("P_AGE");
				String sex = set.getString("P_SEX");
				String U_native = set.getString("P_NATIVE");
				String idNum = set.getString("P_IDNUMBER");
				String phone = set.getString("P_PHONE");
				String address = set.getString("P_ADDR");
				String preStore = set.getString("C_AMOUNT");
				String deposit = set.getString("C_DEPOSIT");
				patientInfBeans.add(new PatientInfBean(sold_name, sold_age, sex, U_native, idNum, phone, address,
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

}
