package com.example.dao;

import com.example.bean.LeftPanelInfBean;
import com.example.bean.PwManageBean;

import java.util.List;

public interface IndexBackEndDao {

	/**
	 * 查左表
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<LeftPanelInfBean> viewLeftPanel(String sql, List<String> params);

	/**
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<PwManageBean> viewPwManainf(String sql, List<String> params);
}
