package com.example.dao;

import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
				pstm.setString(i+1,params.get(i));
			}
			return pstm.executeUpdate();
		} catch (SQLException e) {

		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}
	
	@Override
	public int addBackLog(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			int ret = pstm.executeUpdate();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}
}
