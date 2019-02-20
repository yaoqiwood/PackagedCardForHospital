package com.example.service;

import com.example.bean.CardCensusInfBean;
import com.example.bean.WorkCensusInfBean;

import java.util.List;

public interface StreamService {
	/**
	 * @param S_EVENT
	 * @param S_CID
	 * @param S_PID
	 * @param S_UID
	 * @param S_AMOUNT
	 * @param S_STATE
	 * @param S_CTIME
	 * @param S_REMARK
	 * @return
	 */
	public int insertFundStreamRe(String S_EVENT, String S_CID, String S_PID, String S_UID, String S_AMOUNT, String S_STATE, String S_CTIME, String S_REMARK);

	/**
	 *
	 * @param timeDateStart
	 * @param timeDateEND
	 * @param workman
	 * @param CurrentPage
	 * @param Limit
	 * @return
	 */
	public List<WorkCensusInfBean> viewWorkCenInf(String timeDateStart, String timeDateEND, String workman, int CurrentPage, int Limit);

	/**
	 * 统计数量
	 * @param timeDateStart
	 * @param timeDateEND
	 * @param workman
	 * @return
	 */
	public  int countWorkCen(String timeDateStart, String timeDateEND, String workman);
}
