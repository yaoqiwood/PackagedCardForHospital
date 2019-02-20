package com.example.dao;

import com.example.bean.WorkCensusInfBean;

import java.util.List;

public interface StreamDao {
	public int insertFundStreamRe(String sql, List<String> params);

	public int insertLogTable(String sql, List<String> params);

	public List<WorkCensusInfBean> viewWorkCenInf(String sql, List<String> params);

	public int countWorkCenInf(String sql,List<String> params);
}
