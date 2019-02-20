package com.example.service;

public interface BackLogService {

	/**
	 * @param username
	 * @return
	 */
	public int BackLogAdd(String username, String add_uAccount);

	/**
	 * @param username
	 * @param update_uAccount
	 * @return
	 */
	public int BackLogUpdate(String username, String update_uAccount);

	/**
	 * @param userID
	 * @param COUNTStart
	 * @param COUNTEnd
	 * @return
	 */
	public int BackLogCardStockingIN(String userID, String COUNTStart, String COUNTEnd);

	/**
	 * 启用禁用日志
	 * 
	 * @param state
	 * @param uaccount
	 * @return
	 */
	public int BackBanNorNot(String userID, String state, String uaccount);
	
	/**
	 * 通用
	 * @param userID
	 * @param Event
	 * @return
	 */
	public int BackAllUser(String userID,String Event);
	
	/**
	 * 通用标识业务
	 * @param userID
	 * @param Event
	 * @param State
	 * @return
	 */
	public int intBackAllUserState(String userID,String Event,String State);
}
