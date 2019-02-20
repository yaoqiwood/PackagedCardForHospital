package com.example.service;

import com.example.bean.ArrInfBean;
import com.example.bean.DoctorInfBean;

import java.util.List;

public interface DoctorService {
	/**
	 * 查看医生信息服务
	 *
	 * @return
	 */
	public List<DoctorInfBean> viewDoctorInf();

	/**
	 * 增加排班
	 *
	 * @param mid
	 * @param doctorID
	 * @param date
	 * @return
	 */
	public int addDoctorArr(String mid, String doctorID, String date);

	/**
	 * 查看排班信息
	 *
	 * @param sName
	 * @param CurrentPage
	 * @param Limit
	 * @return
	 */
	public List<ArrInfBean> viewArrInf(String sName, int CurrentPage, int Limit);

	public int updateAppoint(String timeRangeSelected, String tempID, String p_ID);

	public String viewAppStatusOCC(String appID,String timeRange);

	public List<ArrInfBean> viewArrIDInf(String ID,int CurrentPage,int Limit);

	public int delAppInf(String ID);

	/**
	 *
	 * @param CardNum
	 * @return
	 */
	public int appDisMoney(String CardNum);

	/**
	 * 统计取号页数
	 * @param ID
	 * @return
	 */
	public int countArrIDInf(String ID);
	
	/**
	 * 查看该预约病人是否存在表中
	 * @param AID
	 * @param PID
	 * @return
	 */
	public boolean checkAppPaLive(String AID,String PID);
}
