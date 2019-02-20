package com.example.dao;

import com.example.bean.*;

import java.sql.Connection;
import java.util.List;

public interface CardDao {

	//  插入卡入库
	public int cardInStocking(Connection conn, String sql, List<String> params);

	/**
	 * view
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<CardStockInfBean> viewCardStockTable(String sql, List<String> params);

	/**
	 * count
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public int countCardStockTable(String sql, List<String> params);

	/**
	 * @param sql
	 * @param params
	 * @return
	 */
	public int findCardStatus(String sql, List<String> params);

	/**
	 * del
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public int delSCard(String sql, List<String> params);

	/**
	 * view审批表
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<ReqCardInfBean> viewReqCardTable(String sql, List<String> params);

	/**
	 * 增加申请表数据
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public int addRequestData(String sql, List<String> params);

	/**
	 * @param sql
	 * @param params
	 * @return
	 */
	public int countReqCardTable(String sql, List<String> params);

	/**
	 * @param sql
	 * @param params
	 * @return
	 */
	public int updateReqCardTable(String sql, List<String> params);

	/**
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<AppInfBean> viewAppTable(String sql, List<String> params);

	/**
	 * 审批通过
	 *
	 * @param sql
	 * @param appCardID
	 * @return
	 */
	public int appRequestCard(Connection conn, String sql, String appCardID, String app_requester, String app_IDNUM);

	/**
	 * @param sql
	 * @return
	 */
	public int viewWaitCardSize(String sql);

	/**
	 * @param sql
	 * @return
	 */
	public List<AppCardIDCountBean> viewWaitAppCard(String sql, String size);

	/**
	 * @param sql
	 * @param AID
	 * @return
	 */
	public int updateAppApproval(String sql, String AID, String UserID);

	/**
	 * @param sql
	 * @param AID
	 * @return
	 */
	public List<AppCardIDCountBean> viewAppCardGroup(String sql, String AID);

	/**
	 * @param sql
	 * @param CardNum
	 * @return
	 */
	public int checkCardNumExist(String sql, String CardNum);

	/**
	 * @param sql
	 * @param Amount
	 * @return
	 */
	public int updateAmountWithCard(String sql, String Amount, String CardNUM, String CollecterID);

	/**
	 * @param sql
	 * @param params
	 * @return
	 */
	public int updateChangeCard(String sql, List<String> params);

	/**
	 * @param sql
	 * @param params
	 * @return
	 */
	public String viewParams(String sql, String params);

	/**
	 * @param sql
	 * @param params
	 * @return
	 */
	public String oldNumParams(String sql, List<String> params);

	/**
	 * 退卡
	 *
	 * @param sql
	 * @param CardNum
	 * @return
	 */
	public int exitCard(String sql, String CardNum);

	/**
	 * 查询卡信息
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<CardInfBean> viewCardInf(String sql, List<String> params);


	/**
	 * 通用统计
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public int CountAnyInf(String sql, List<String> params);

	/**
	 * @param sql
	 * @param params
	 * @return
	 */
	public ViewCardInfBean viewCardPanelInf(String sql, List<String> params);

	/**
	 * @param sql
	 * @param params
	 * @return
	 */
	public String viewUserName(String sql, List<String> params);

	/**
	 * 查询病人ID
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public String viewPatientID(String sql, List<String> params);

	/**
	 * 查询通用（卡）
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public String viewCardAnyString(String sql, List<String> params);

	/**
	 * 领卡查找
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<CardCensusInfBean> viewCardCensus(String sql, List<String> params);

	/**
	 * @param sql
	 * @param params
	 * @return
	 */
	public int countCardCensus(String sql, List<String> params);

	/**
	 * 更新通用信息
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public int updateAnyInf(String sql, List<String> params);

	/**
	 * 查看卡号
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<CardInfBean> viewCardNum(String sql, List<String> params);
	
	
}
