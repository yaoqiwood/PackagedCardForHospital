package com.example.service;

import com.example.bean.*;

import java.sql.Connection;
import java.util.List;

public interface CardService {

	/**
	 * @param add_CNStart
	 * @param add_CNEND
	 * @param add_Prefix
	 * @return
	 */
	public int cardInStocking(int add_CNStart, int add_CNEND, String add_Prefix);

	/**
	 * @param CNStart
	 * @param CNEND
	 * @param CSatus
	 * @param StINDateStart
	 * @param StINDateEND
	 * @param CurrentPage
	 * @param Limit
	 * @return
	 */
	public List<CardStockInfBean> viewCardStockTable(String CNStart, String CNEND, String CSatus, String StINDateStart,
	                                                 String StINDateEND, int CurrentPage, int Limit);

	/**
	 * @param CNStart
	 * @param CNEND
	 * @param CSatus
	 * @param StINDateStart
	 * @param StINDateEND
	 * @return
	 */
	public int countCardStockTable(String CNStart, String CNEND, String CSatus, String StINDateStart,
	                               String StINDateEND);

	/**
	 * @param delID
	 * @return
	 */
	public int findCardService(String delID);

	/**
	 * @param delID
	 * @return
	 */
	public int delScard(String delID);


	/**
	 * @param RDateStart
	 * @param RDateEND
	 * @param AsseSatus
	 * @param CurrentPage
	 * @param Limit
	 * @return
	 */
	public List<ReqCardInfBean> viewReqCardTable(String RDateStart, String RDateEND, String AsseSatus, int CurrentPage, int Limit);

	/**
	 * @param add_requester
	 * @param add_reqDate
	 * @param add_reqNum
	 * @return
	 */
	public int addReqCardData(String add_requester, String add_reqDate, String add_reqNum);

	/**
	 * @param RDateStart
	 * @param RDateEND
	 * @param AsseSatus
	 * @return
	 */
	public int countReqCardTable(String RDateStart, String RDateEND, String AsseSatus);

	/**
	 * @param modify_reqNum
	 * @param modify_id
	 * @return
	 */
	public int updateReqCardTable(String modify_reqNum, String modify_id);

	/**
	 * @param S_Requester
	 * @param S_Status
	 * @param S_Date_Start
	 * @param S_Date_End
	 * @param CurrentPage
	 * @param Limit
	 * @return
	 */
	public List<AppInfBean> viewAppInfTable(String S_Requester, String S_Status, String S_Date_Start, String S_Date_End, int CurrentPage, int Limit);

	/**
	 * @param S_Requester
	 * @param S_Status
	 * @param S_Date_Start
	 * @param S_Date_End
	 * @return
	 */
	public int countAppInfTable(String S_Requester, String S_Status, String S_Date_Start, String S_Date_End);

	/**
	 * @param conn
	 * @param appCardID
	 * @param app_IDNUM
	 * @return
	 */
	public int appRequestCard(Connection conn, String appCardID, String app_IDNUM, String app_requester);

	/**
	 * @return
	 */
	public int viewWaitCardSize();

	/**
	 * @param SizeNum
	 * @return
	 */
	public List<AppCardIDCountBean> viewWaitAppCard(String SizeNum);

	/**
	 * @param AID
	 * @return
	 */
	public int updateAppApproval(String AID, String UserID);

	/**
	 * @param AID
	 * @return
	 */
	public List<AppCardIDCountBean> viewAppCardGroup(String AID);


	//  换卡等业务组

	/**
	 * @param CardNum
	 * @return
	 */
	public int checkCardNumExist(String CardNum);

	/**
	 * @param Amount
	 * @param CardNum
	 * @return
	 */
	public int updateAmountWithCard(String Amount, String CardNum, String CollecterID);

	public int updateChangeCard(String OldCardNum, String newCardNum, String UserID);

	public String oldNumParams(String params);

	/**
	 * @param OldCardNum
	 * @param newCardNum
	 * @return
	 */
	public int updatePatientCard(String OldCardNum, String newCardNum);

	public int updateOldCard(String OldCard);

	public List<PatientInfBean> viewExitPatientInf(String CardNum);

	/**
	 * 退卡
	 *
	 * @param CardNum
	 * @return
	 */
	public int exitCard(String CardNum);

	/**
	 * 清除病人的绑定信息
	 *
	 * @param CardNum
	 * @return
	 */
	public int clearPatientCardID(String CardNum);

	public int deleteCard(String CardNum);

	public List<CardInfBean> viewCardInf(String CNUM, String CSatus, String requestor, int CurrentPage, int Limit);

	/**
	 * @param CNUM
	 * @param CSatus
	 * @param requestor
	 * @return
	 */
	public int countCardInf(String CNUM, String CSatus, String requestor);

	public ViewCardInfBean viewCardPanelInf(String ID);

	public String viewUsername(String ID);

	public String viewPatientID(String CardNum);

	public String viewCardID(String CardNum);

	public String viewAmount(String CardNum);

	/**
	 * @param timeDateStart
	 * @param timeDateEND
	 * @param cnoStart
	 * @param cnoEND
	 * @param CurrentPage
	 * @param Limit
	 * @return
	 */
	public List<CardCensusInfBean> viewCardCensus(String timeDateStart, String timeDateEND, String cnoStart,
	                                              String cnoEND, int CurrentPage, int Limit);

	public int countCardCensus(String timeDateStart, String timeDateEND, String cnoStart,
	                           String cnoEND);

	public List<CardInfBean> viewLGCTable(String CNUMStart, String CNUMEND, String CSatus, int CurrentPage, int Limit);

	public int countLGCTable(String CNUMStart, String CNUMEND, String CSatus);

	public int LogOutCard(String ID);

	/**
	 * @param userID
	 * @return
	 */
	public List<CardInfBean> viewCardNum(String userID);

	/**
	 * 查看账号
	 * @param userID
	 * @return
	 */
	public String viewUAccount(String userID);

}
