package com.example.dao;

import com.example.bean.UserLoginInfBean;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserLoginDaoImpl implements UserLoginDao {
	@Override
	public UserLoginInfBean UserLogin(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i+1,params.get(i));
				System.out.println(params.get(i));
			}
			set = pstm.executeQuery();
			if (set.next()){
				return new UserLoginInfBean(set.getString("U_ID"),set.getString("U_NAME"),set.getString("U_STATE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn,pstm,set);
		}
		return null;
	}

	@Override
	public String viewRoleID(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i+1,params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()){
				return set.getString("U_ROLE_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn,pstm,set);
		}
		return null;
	}

	@Override
	public int checkOriPWD(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i+1,params.get(i));
			}
			set = pstm.executeQuery();
			if (set.next()){
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn,pstm,set);
		}

		return 0;
	}

	@Override
	public int uptatePWD(String sql, List<String> params) {
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
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn,pstm,set);
		}
		return 0;
	}
}
