package com.example.dao;

import com.example.bean.WorkCensusInfBean;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StreamDaoImpl implements StreamDao {
	@Override
	public int insertFundStreamRe(String sql, List<String> params) {
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

		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	@Override
	public int insertLogTable(String sql, List<String> params) {
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

		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	@Override
	public List<WorkCensusInfBean> viewWorkCenInf(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<WorkCensusInfBean> workCensusInfBeans = new ArrayList<>();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String B_EXCUTORID = set.getString("B_EXECUTORID");
				String SOLD_CARD = set.getString("SOLD_CARD");
				String CHANGE_CARD = set.getString("CHANGE_CARD");
				String EXID_CARD = set.getString("EXIT_CARD");
				workCensusInfBeans.add(new WorkCensusInfBean(B_EXCUTORID, SOLD_CARD, CHANGE_CARD, EXID_CARD));
			}
			return workCensusInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public int countWorkCenInf(String sql, List<String> params) {
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
				return set.getInt("Count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}
}
