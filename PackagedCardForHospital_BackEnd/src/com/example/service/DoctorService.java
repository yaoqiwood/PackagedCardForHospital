package com.example.service;

import com.example.bean.ArrInfBean;
import com.example.bean.DoctorInfBean;

import java.util.List;

public interface DoctorService {
	/**
	 * 查看医生信息服务
	 * @return
	 */
	public List<DoctorInfBean> viewDoctorInf();

	/**
	 * 增加排班
	 * @param mid
	 * @param doctorID
	 * @param date
	 * @return
	 */
	public int addDoctorArr(String mid, String doctorID, String date);

	/**
	 * 查看排班信息
	 * @param sName
	 * @param CurrentPage
	 * @param Limit
	 * @return
	 */
	public List<ArrInfBean> viewArrInf(String sName,int CurrentPage,int Limit);

	/**
	 * 查找排班统计个数
	 * @param sName
	 * @return
	 */
	public int countArrInf(String sName);


	/**
	 * 修改排班
	 * @param aid
	 * @param modify_date
	 * @return
	 */
	public int updateArrInf(String aid,String modify_date);

	/**
	 * 删除排班
	 * @param aid
	 * @return
	 */
	public int delArrInf(String aid);

}
