package com.example.dao;

import com.example.bean.ArrInfBean;
import com.example.bean.DoctorInfBean;

import java.util.List;

public interface DoctorDao {
	/**
	 * 查看医生姓名
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<DoctorInfBean> viewDoctorInf(String sql, List<String> params);

	/**
	 * 通用修改dao
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public int updateDoctorInf(String sql, List<String> params);

	/**
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<ArrInfBean> viewArrInf(String sql, List<String> params);

	/**
	 * 修改任何信息
	 * @param sql
	 * @param params
	 * @return
	 */
	public int UpdateAnyInf(String sql, List<String> params);
}
