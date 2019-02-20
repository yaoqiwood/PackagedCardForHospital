package com.example.dao;

import com.example.bean.CardAccCheckInfBean;
import com.example.bean.PatientInfBean;

import java.util.List;

public interface PatientDao {
	public List<PatientInfBean> viewPatientInf(String sql, String CardNUM);

	public int topUpPatientCard(String sql, String CardNum, String MoneyNum);

	public String viewAnyString(String sql, List<String> params);

	public List<CardAccCheckInfBean> viewAccCheckTable(String sql,List<String> params);
	
	public int viewAnyInt(String sql,List<String> params);
}
