package com.example.service;

public interface StreamService {
	/**
	 *
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
	 * 通用
	 * @param userID
	 * @param Event
	 * @return
	 */
	public int BackAllUser(String userID,String Event);
}
