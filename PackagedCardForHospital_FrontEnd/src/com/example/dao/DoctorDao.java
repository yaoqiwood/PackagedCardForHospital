package com.example.dao;

import com.example.bean.ArrInfBean;
import com.example.bean.DoctorInfBean;

import java.util.List;

public interface DoctorDao {
	/**
	 * 查看医生姓名
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<DoctorInfBean> viewDoctorInf(String sql, List<String> params);

	/**
	 * 通用修改dao
	 * @param sql
	 * @param params
	 * @return
	 */
	public int updateDoctorInf(String sql, List<String> params);

	/**
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<ArrInfBean> viewArrInf(String sql, List<String> params);

	/**
	 * 查询取号表
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<ArrInfBean> viewArrIDInf(String sql,List<String> params);
	
	public String viewAppOCC(String sql,List<String> params);

	public int delAppInf(String sql,List<String> params);

	public int updateAnyInf(String sql,List<String> params);

	/**
	 * 通用统计页数
	 * @param sql
	 * @param params
	 * @return
	 */
	public int countAnyInf(String sql,List<String> params);
	
	/**
	 * 查看病人是否存在排班预约表中
	 * @param sql
	 * @param params
	 * @return
	 */
	public boolean checkAppPaLive(String sql,List<String> params);
}
