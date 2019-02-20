package com.example.service;

import com.example.bean.LeftPanelInfBean;
import com.example.bean.PwManageBean;

import java.util.List;

public interface IndexBackEndService {
	/**
	 * @return
	 */
	List<LeftPanelInfBean> viewLeftPanel(String ParentID, String roleID);

	List<PwManageBean> viewPwManainf(String MID);

	List<LeftPanelInfBean> viewLeftPWMPanel(String ParentID);
}
