package com.example.dao;

import com.example.bean.ArrInfBean;
import com.example.bean.DoctorInfBean;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDaoImpl implements DoctorDao {
	@Override
	public List<DoctorInfBean> viewDoctorInf(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<DoctorInfBean> doctorInfBeans = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String ID = set.getString("U_ID");
				String NAME = set.getString("U_NAME");
				String SEX = set.getString("U_SEX");
				String AGE = set.getString("U_AGE");
				String DEPARTMENT = set.getString("U_DEPARTMENT_ID");
				doctorInfBeans.add(new DoctorInfBean(ID, NAME, SEX, AGE, DEPARTMENT));
			}
			return doctorInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public int updateDoctorInf(String sql, List<String> params) {
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
	public List<ArrInfBean> viewArrInf(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<ArrInfBean> arrInfBeans = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String ID = set.getString("A_ID");
				String Doctor = set.getString("U_NAME");
				String Department = set.getString("D_NAME");
				String ATIME = set.getString("ADATE");
				String State = set.getString("A_STATE");
				arrInfBeans.add(new ArrInfBean(ID, Doctor, Department, ATIME, State));
			}
			return arrInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public int UpdateAnyInf(String sql, List<String> params) {
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

}
