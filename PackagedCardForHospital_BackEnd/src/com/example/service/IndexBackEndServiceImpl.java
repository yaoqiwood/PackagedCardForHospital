package com.example.service;

import com.example.bean.LeftPanelInfBean;
import com.example.bean.PwManageBean;
import com.example.dao.IndexBackEndDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class IndexBackEndServiceImpl implements IndexBackEndService {

	@Override
	public List<LeftPanelInfBean> viewLeftPanel(String ParentID, String roleID) {
		String sql = "SELECT * FROM T_MENU A INNER JOIN T_RM_RELATION B ON A.M_ID = B.RM_MID WHERE 1=1  ";
		List<String> params = new ArrayList<>();
		if (ParentID != null && (!ParentID.trim().equals(""))) {
			sql += " AND M_UPLEVELID = ? ";
			params.add(ParentID);
			if (roleID != null && (!roleID.trim().equals(""))) {
				sql += " AND RM_RID = ? ";
				params.add(roleID);
				return new IndexBackEndDaoImpl().viewLeftPanel(sql, params);
			}
		}
		return new IndexBackEndDaoImpl().viewLeftPanel(sql, params);
	}

	@Override
	public List<PwManageBean> viewPwManainf(String MID) {
		String sql = "SELECT * FROM T_RM_RELATION WHERE RM_RID = ? ";
		List<String> params = new ArrayList<>();
		params.add(MID);
		return new IndexBackEndDaoImpl().viewPwManainf(sql,params);
	}

	@Override
	public List<LeftPanelInfBean> viewLeftPWMPanel(String ParentID) {
		String sql = " SELECT * FROM T_MENU WHERE M_UPLEVELID = ? ORDER BY M_ID ";
		List<String> params = new ArrayList<>();
		params.add(ParentID);
		return new IndexBackEndDaoImpl().viewLeftPanel(sql, params);
	}
}
