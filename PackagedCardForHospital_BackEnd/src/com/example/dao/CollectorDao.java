package com.example.dao;

import com.example.bean.NativeInfBean;
import com.example.bean.PatientInfBean;

import java.util.List;

public interface CollectorDao {
	/**
	 * @param sql
	 * @return
	 */
	public List<NativeInfBean> viewNativeInf(String sql);

	/**
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public int addPatient (String sql,List<String> params);

	/**
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<PatientInfBean> viewPatientInf(String sql, List<String> params);
	

}
