package com.example.dao;

import com.example.bean.LeftPanelInfBean;
import com.example.bean.PwManageBean;
import com.example.util.DBUtil;
import com.sun.org.apache.regexp.internal.RE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IndexBackEndDaoImpl implements IndexBackEndDao {

	@Override
	public List<LeftPanelInfBean> viewLeftPanel(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<LeftPanelInfBean> leftPanelInfBeans = new ArrayList<>();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String ID = set.getString("M_ID");
				String NAME = set.getString("M_NAME");
				String URL = set.getString("M_URL");
				String UPLEVELID = set.getString("M_UPLEVELID");
				String STATE = set.getString("M_STATE");
				String CTIME = set.getString("M_CTIME");
				String REMARK = set.getString("M_REMARK");
				leftPanelInfBeans.add(new LeftPanelInfBean(ID, NAME, URL, UPLEVELID, STATE, CTIME, REMARK));
			}
			return leftPanelInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public List<PwManageBean> viewPwManainf(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<PwManageBean> viewPwManagBeans = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				viewPwManagBeans.add(new PwManageBean(set.getString("RM_MID")));
			}
			return viewPwManagBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}
}
