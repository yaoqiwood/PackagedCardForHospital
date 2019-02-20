package com.example.service;

import com.example.bean.*;
import com.example.dao.CardDaoImpl;
import com.example.dao.CollectorDaoImpl;
import com.example.util.DBUtil;

import javax.smartcardio.Card;

import java.io.Console;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class CardServiceImpl implements CardService {

	@Override
	public int cardInStocking(int add_CNStart, int add_CNEND, String add_Prefix) {
		String sql = "INSERT INTO T_CARD (C_ID, C_PREFIX, C_NUMBER,C_SUFFIX,C_CTIME,C_STATE ) VALUES (SEQ_T_CARD.nextval,?,?,?,SYSDATE,0) ";
		Connection conn = DBUtil.createConn();
		CardDaoImpl cardDao = new CardDaoImpl();
		for (int i = add_CNStart; i <= add_CNEND; i++) {
			List<String> params = new ArrayList<>();
			String CardNUM = completeNum(i, 8);
			System.out.println(CardNUM);
			params.add(add_Prefix);
			params.add(CardNUM);
			params.add(add_Prefix+CardNUM);
			cardDao.cardInStocking(conn, sql, params);
			if (i == add_CNEND) {
				DBUtil.closeConn(conn, null, null);
				return 1;
			}
		}
		return 0;
	}

	@Override
	public List<CardStockInfBean> viewCardStockTable(String CNStart, String CNEND, String CSatus, String StINDateStart, String StINDateEND, int CurrentPage, int Limit) {
		String sql = "SELECT A.*,ROWNUM RN FROM (SELECT * FROM T_CARD ORDER BY C_CTIME DESC) A WHERE 1=1 ";
		List<String> params = new ArrayList<>();
		if (CNStart != null && CNEND != null) {
			if ((!CNStart.trim().equals("")) && (!CNEND.trim().equals(""))) {
				sql += " AND CONCAT(C_PREFIX,C_NUMBER) BETWEEN ? AND ? ";
				params.add(CNStart);
				params.add(CNEND);
			}
		}
		if (CSatus != null && (!CSatus.trim().equals(""))) {
			sql += " AND C_STATE = ? ";
			params.add(CSatus);
		}

		if (StINDateStart != null && StINDateEND != null) {
			if ((!StINDateStart.trim().equals("")) && (!StINDateEND.trim().equals(""))) {
				sql += " AND to_char(C_CTIME,'YYYY-MM-DD') BETWEEN ? AND ? ";
				params.add(StINDateStart);
				params.add(StINDateEND);
			}
		}


		sql = "SELECT * FROM ( " + sql + " ) A WHERE A.RN BETWEEN ? AND ? ";
		params.add(String.valueOf(CurrentPage * Limit - (Limit - 1)));
		params.add(String.valueOf(CurrentPage * Limit));
		return new CardDaoImpl().viewCardStockTable(sql, params);
	}

	@Override
	public int countCardStockTable(String CNStart, String CNEND, String CSatus, String StINDateStart, String StINDateEND) {
		String sql = "SELECT COUNT(0) Count FROM T_CARD  WHERE 1=1 ";
		List<String> params = new ArrayList<>();
		if (CNStart != null && CNEND != null) {
			if ((!CNStart.trim().equals("")) && (!CNEND.trim().equals(""))) {
				sql += " AND C_NUMBER BETWEEN ? AND ? ";
				params.add(CNStart);
				params.add(CNEND);
			}
		}

		if (CSatus != null && (!CSatus.trim().equals(""))) {
			sql += " AND C_STATE = ? ";
			params.add(CSatus);
		}

		if (StINDateStart != null && StINDateEND != null) {
			if ((!StINDateStart.trim().equals("")) && (!StINDateEND.trim().equals(""))) {
				sql += " AND to_char(C_CTIME,'YYYY-MM-DD') BETWEEN ? AND ? ";
				params.add(StINDateStart);
				params.add(StINDateEND);
			}
		}
		return new CardDaoImpl().countCardStockTable(sql, params);
	}

	@Override
	public int findCardService(String delID) {
		String sql = "SELECT C_STATE Status FROM T_CARD WHERE C_ID = ? ";
		List<String> params = new ArrayList<>();
		if (delID != null && (!delID.trim().equals(""))) {
			params.add(delID);
			return new CardDaoImpl().findCardStatus(sql, params);
		}
		return 100;
	}

	@Override
	public int delScard(String delID) {
		String sql = "DELETE FROM T_CARD WHERE C_ID = ? ";
		List<String> params = new ArrayList<>();
		if (delID != null && (!delID.trim().equals(""))) {
			params.add(delID);
			return new CardDaoImpl().delSCard(sql, params);
		}
		return 0;
	}

	@Override
	public List<ReqCardInfBean> viewReqCardTable(String RDateStart, String RDateEND, String AsseSatus, int CurrentPage, int Limit) {
		String sql = "SELECT A.* ,ROWNUM RN FROM ( SELECT * FROM T_APPROVAL ORDER BY ARVL_CTIME DESC ) A WHERE 1=1 ";
		List<String> params = new ArrayList<>();
		if (RDateStart != null && RDateEND != null) {
			if ((!RDateStart.trim().equals("")) && (!RDateEND.trim().equals(""))) {
				sql += " AND to_char(ARVL_CTIME,'YYYY-MM-DD') BETWEEN ? AND ? ";
				params.add(RDateStart);
				params.add(RDateEND);
			}
		}
		if (AsseSatus != null && (!AsseSatus.trim().equals(""))) {
			sql += "  AND ARVL_STATE = ? ";
			params.add(AsseSatus);
		}


		sql = "SELECT * FROM ( " + sql + " ) A WHERE A.RN BETWEEN ? AND ? ";
		params.add(String.valueOf(CurrentPage * Limit - (Limit - 1)));
		params.add(String.valueOf(CurrentPage * Limit));

		return new CardDaoImpl().viewReqCardTable(sql, params);
	}

	@Override
	public int addReqCardData(String add_requester, String add_reqDate, String add_reqNum) {
		String sql = "INSERT INTO T_APPROVAL (ARVL_ID,ARVL_CORID,ARVL_CTIME,ARVL_REQUESTNUM,ARVL_STATE) VALUES (SEQ_T_APPROVAL.nextval,?,SYSDATE,?,0) ";
		List<String> params = new ArrayList<>();
		if (add_requester != null && add_reqDate != null && add_reqNum != null) {
			if ((!add_requester.trim().equals("")) && (!add_reqDate.trim().equals("")) && (!add_reqNum.trim().equals(""))) {
				params.add(add_requester);
				params.add(add_reqNum);
				return new CardDaoImpl().addRequestData(sql, params);
			}
		}
		return 0;
	}

	@Override
	public int countReqCardTable(String RDateStart, String RDateEND, String AsseSatus) {
		String sql = "SELECT COUNT(0) Count FROM T_APPROVAL WHERE 1=1 ";
		List<String> params = new ArrayList<>();
		if (RDateStart != null && RDateEND != null) {
			if ((!RDateStart.trim().equals("")) && (!RDateEND.trim().equals(""))) {
				sql += " AND to_char(ARVL_CTIME,'YYYY-MM-DD') BETWEEN ? AND ? ";
				params.add(RDateStart);
				params.add(RDateEND);
			}
		}
		if (AsseSatus != null && (!AsseSatus.trim().equals(""))) {
			sql += "  AND ARVL_STATE = ? ";
			params.add(AsseSatus);
		}

		return new CardDaoImpl().countReqCardTable(sql, params);
	}

	@Override
	public int updateReqCardTable(String modify_reqNum, String modify_id) {
		String sql = "UPDATE T_APPROVAL SET ARVL_REQUESTNUM = ? WHERE ARVL_ID = ? ";
		List<String> params = new ArrayList<>();
		if (modify_reqNum != null && modify_id != null) {
			if ((!modify_reqNum.trim().equals("")) && (!modify_id.trim().equals(""))) {
				params.add(modify_reqNum);
				params.add(modify_id);
				return new CardDaoImpl().updateReqCardTable(sql, params);
			}
		}
		return 0;
	}

	@Override
	public List<AppInfBean> viewAppInfTable(String S_Requester, String S_Status, String S_Date_Start, String S_Date_End, int CurrentPage, int Limit) {
		String sql = "SELECT * FROM T_APPROVAL A WHERE 1=1 ";
//		System.out.println(S_Requester+":"+S_Status+":"+S_Date_End);
		List<String> params = new ArrayList<>();
		if (S_Requester != null && (!S_Requester.trim().equals(""))) {
			sql += " AND ARVL_CORID = ? ";
			params.add(S_Requester);
		}
		if (S_Status != null && (!S_Status.trim().equals(""))) {
			sql += " AND ARVL_STATE = ? ";
			params.add(S_Status);
		}
		if (S_Date_Start != null && S_Date_End != null) {
			if ((!S_Date_Start.trim().equals("")) && (!S_Date_End.trim().equals(""))) {
				sql += " AND to_char(ARVL_CTIME,'YYYY-MM-DD') BETWEEN ? AND ? ";
				params.add(S_Date_Start);
				params.add(S_Date_End);
			}
		}
		sql += " ORDER BY ARVL_CTIME DESC";
		sql = "SELECT A.* , ROWNUM RN  FROM ( "+ sql + ") A";
		sql = "SELECT * FROM ( " + sql + " ) A WHERE A.RN BETWEEN ? AND ? ";
		params.add(String.valueOf(CurrentPage * Limit - (Limit - 1)));
		params.add(String.valueOf(CurrentPage * Limit));
		
		return new CardDaoImpl().viewAppTable(sql, params);
	}

	@Override
	public int countAppInfTable(String S_Requester, String S_Status, String S_Date_Start, String S_Date_End) {
		String sql = "SELECT COUNT(0) Count FROM T_APPROVAL WHERE 1=1 ";
		List<String> params = new ArrayList<>();
		if (S_Requester != null && (!S_Requester.trim().equals(""))) {
			sql += " AND ARVL_CORID = ? ";
			params.add(S_Requester);
		}
		if (S_Status != null && (!S_Status.trim().equals(""))) {
			sql += " AND ARVL_STATE = ? ";
			params.add(S_Status);
		}
		if (S_Date_Start != null && S_Date_End != null) {
			if ((!S_Date_Start.trim().equals("")) && (!S_Date_End.trim().equals(""))) {
				sql += " AND to_char(ARVL_CTIME,'YYYY-MM-DD') BETWEEN ? AND ? ";
				params.add(S_Date_Start);
				params.add(S_Date_End);
			}
		}
		return new CardDaoImpl().CountAnyInf(sql, params);
	}

	@Override
	public int appRequestCard(Connection conn, String appCardID, String app_IDNUM, String app_requester) {
		String sql = "UPDATE T_CARD SET C_STATE = 1 , C_APPROVAL_ID = ? ,C_COLLECTOR_ID = ? WHERE C_ID = ? ";
		return new CardDaoImpl().appRequestCard(conn, sql, appCardID, app_requester, app_IDNUM);
	}

	@Override
	public int viewWaitCardSize() {
		String sql = "SELECT COUNT(0) Count FROM T_CARD WHERE C_STATE = 0 ";
		return new CardDaoImpl().viewWaitCardSize(sql);
	}

	@Override
	public List<AppCardIDCountBean> viewWaitAppCard(String SizeNum) {
		String sql = "SELECT * FROM (SELECT A.C_ID,ROWNUM RN FROM T_CARD A WHERE C_STATE = 0) A WHERE A.RN BETWEEN 0 AND ? ";
		return new CardDaoImpl().viewWaitAppCard(sql, SizeNum);
	}

	@Override
	public int updateAppApproval(String AID, String UserID) {
		String sql = "UPDATE T_APPROVAL SET ARVL_STATE = 1,ARVL_MID = ?,ARVL_ATIME = SYSDATE WHERE ARVL_ID = ? ";
		return new CardDaoImpl().updateAppApproval(sql, AID, UserID);
	}

	@Override
	public List<AppCardIDCountBean> viewAppCardGroup(String AID) {
		String sql = "SELECT * FROM T_CARD WHERE C_APPROVAL_ID = ? ";
		return new CardDaoImpl().viewAppCardGroup(sql, AID);
	}

	@Override
	public int checkCardNumExist(String CardNum) {
		String sql = "SELECT COUNT(0) Count FROM (SELECT CONCAT(C_PREFIX, C_NUMBER) AS CARD_NUM FROM T_CARD WHERE C_STATE = 1) A WHERE A.CARD_NUM = ? ";
		return new CardDaoImpl().checkCardNumExist(sql, CardNum);
	}

	@Override
	public int updateAmountWithCard(String Amount, String CardNum, String CollecterID) {
		String sql = "UPDATE T_CARD SET C_AMOUNT = ?,C_DEPOSIT = 5,C_COLLECTOR_ID = ?,C_STATE = 2,C_VEND_TIME = SYSDATE WHERE CONCAT(C_PREFIX,C_NUMBER) = ? ";
		return new CardDaoImpl().updateAmountWithCard(sql, Amount, CardNum, CollecterID);
	}

	@Override
	public int updateChangeCard(String OldCardNum, String newCardNum, String UserID) {
		String sql = "UPDATE T_CARD SET C_AMOUNT = ? ,C_DEPOSIT = ?, C_MTIME = SYSDATE,C_STATE = 2,C_COLLECTOR_ID = ?,C_VEND_TIME = SYSDATE WHERE CONCAT(C_PREFIX,C_NUMBER) = ?  ";
		System.out.println(OldCardNum);
		List<String> params = new ArrayList<>();
		List<String> TempParams = new ArrayList<>();
		params.add("C_AMOUNT");
		params.add("C_DEPOSIT");
		params.add(UserID);
		for (int i = 0; i < params.size(); i++) {
			String newSql = "SELECT " + params.get(i) + " FROM T_CARD WHERE CONCAT(C_PREFIX,C_NUMBER) = ? ";
			TempParams.add(new CardDaoImpl().viewParams(newSql, OldCardNum));
		}

		String CID = new CardServiceImpl().viewCardID(newCardNum);
		String PID = new CardServiceImpl().viewPatientID(OldCardNum);
		new StreamServiceImpl().insertFundStreamRe("换卡", CID, PID, UserID, TempParams.get(0), "1", null, null);
		TempParams.add(newCardNum);
//		for (String i : TempParams) {
//			System.out.println(i);
//		}
		return new CardDaoImpl().updateChangeCard(sql, TempParams);
	}

	@Override
	public String oldNumParams(String params) {
		String findSql = "SELECT CONCAT(C_PREFIX,C_NUMBER) " +
				" FROM T_PATIENT A " +
				" INNER JOIN T_CARD B ON A.P_CARD_ID = CONCAT(B.C_PREFIX, B.C_NUMBER) " +
				" WHERE A.P_CARD_ID = ? OR P_PHONE = ? OR P_IDNUMBER = ? ";
		List<String> newParams = new ArrayList<>();
		newParams.add(params);
		newParams.add(params);
		newParams.add(params);
		return new CardDaoImpl().oldNumParams(findSql, newParams);
	}

	@Override
	public int updatePatientCard(String OldCardNum, String newCardNum) {
		String sql = "UPDATE T_PATIENT SET P_CARD_ID = ? WHERE P_CARD_ID = ? ";
		List<String> params = new ArrayList<>();
		params.add(newCardNum);
		params.add(OldCardNum);
		return new CardDaoImpl().updateChangeCard(sql, params);
	}

	@Override
	public int updateOldCard(String OldCard) {
		String sql = " UPDATE T_CARD SET C_STATE = -1 WHERE CONCAT(C_PREFIX,C_NUMBER) = ?  ";
		List<String> params = new ArrayList<>();
		params.add(OldCard);
		return new CardDaoImpl().updateChangeCard(sql, params);
	}

	@Override
	public List<PatientInfBean> viewExitPatientInf(String CardNum) {
		String sql = " SELECT * " +
				" FROM T_PATIENT A" +
				" INNER JOIN T_CARD B ON A.P_CARD_ID = CONCAT(B.C_PREFIX, B.C_NUMBER) " +
				" WHERE A.P_CARD_ID = ? ";
		List<String> params = new ArrayList<>();
		params.add(CardNum);
		return new CollectorDaoImpl().viewPatientInf(sql, params);
	}

	@Override
	public int exitCard(String CardNum) {
		String sql = "UPDATE T_CARD SET C_STATE = 1, C_AMOUNT = 0, C_DEPOSIT = 0,C_MTIME = SYSDATE,C_COLLECTOR_ID = null " +
				" WHERE CONCAT(C_PREFIX,C_NUMBER) = ? AND C_STATE = 2";
		return new CardDaoImpl().exitCard(sql, CardNum);
	}

	@Override
	public int clearPatientCardID(String CardNum) {
		String sql = " UPDATE T_PATIENT SET P_CARD_ID = null WHERE P_CARD_ID = ? ";
		return new CardDaoImpl().exitCard(sql, CardNum);
	}

	@Override
	public int deleteCard(String CardNum) {
		String sql = " DELETE T_CARD WHERE CONCAT(C_PREFIX,C_NUMBER) = ? AND C_STATE = 1 ";
		return new CardDaoImpl().exitCard(sql, CardNum);
	}

	@Override
	public List<CardInfBean> viewCardInf(String CNUM, String CSatus, String requestor, int CurrentPage, int Limit) {
		String sql = " SELECT * FROM T_CARD A INNER JOIN T_APPROVAL B ON A.C_APPROVAL_ID = B.ARVL_ID " +
				" LEFT JOIN  T_PATIENT C ON CONCAT(A.C_PREFIX,A.C_NUMBER) = C.P_CARD_ID " +
				" INNER JOIN T_USER D ON B.ARVL_CORID = D.U_ID WHERE 1=1 ";

		List<String> params = new ArrayList<>();
		if (CNUM != null) {
			if ((!CNUM.trim().equals(""))) {
				sql += " AND CONCAT(A.C_PREFIX,A.C_NUMBER) = ?  ";
				params.add(CNUM);
			}
		}
		if (CSatus != null) {
			if ((!CSatus.trim().equals(""))) {
				sql += " AND A.C_STATE = ?  ";
				params.add(CSatus);
			}
		}
		if (requestor != null) {
			if ((!requestor.trim().equals(""))) {
				sql += " AND D.U_ID = ? ";
				params.add(requestor);
			}
		}

		sql += " ORDER BY CONCAT(C_PREFIX,C_NUMBER) ";

		sql = "SELECT * FROM (SELECT A.*,ROWNUM RN FROM ( " + sql + " )  A ) A WHERE A.RN BETWEEN ? AND ? ";
		params.add(String.valueOf(CurrentPage * Limit - (Limit - 1)));
		params.add(String.valueOf(CurrentPage * Limit));
		return new CardDaoImpl().viewCardInf(sql, params);
	}

	@Override
	public int countCardInf(String CNUM, String CSatus, String requestor) {
		String sql = "SELECT COUNT(0) Count FROM T_CARD A INNER JOIN T_APPROVAL B ON A.C_APPROVAL_ID = B.ARVL_ID " +
				"LEFT JOIN  T_PATIENT C ON CONCAT(A.C_PREFIX,A.C_NUMBER) = C.P_CARD_ID " +
				"INNER JOIN T_USER D ON B.ARVL_CORID = D.U_ID WHERE 1=1 ";

		List<String> params = new ArrayList<>();
		if (CNUM != null) {
			if ((!CNUM.trim().equals(""))) {
				sql += " AND CONCAT(A.C_PREFIX,A.C_NUMBER) = ?  ";
				params.add(CNUM);
			}
		}
		if (CSatus != null) {
			if ((!CSatus.trim().equals(""))) {
				sql += " AND A.C_STATE = ?  ";
				params.add(CSatus);
			}
		}
		if (requestor != null) {
			if ((!requestor.trim().equals(""))) {
				sql += " AND D.U_ID = ? ";
				params.add(requestor);
			}
		}
		return new CardDaoImpl().CountAnyInf(sql, params);
	}

	@Override
	public ViewCardInfBean viewCardPanelInf(String ID) {
		String sql = " SELECT * FROM T_CARD A INNER JOIN T_APPROVAL B ON A.C_APPROVAL_ID = B.ARVL_ID " +
				"LEFT JOIN  T_PATIENT C ON CONCAT(A.C_PREFIX,A.C_NUMBER) = C.P_CARD_ID " +
				"WHERE 1=1  ";
		List<String> params = new ArrayList<>();
		if (ID != null && (!ID.trim().equals(""))) {
			sql += " AND C_ID = ? ";
			params.add(ID);
			return new CardDaoImpl().viewCardPanelInf(sql, params);
		}
		return null;
	}

	@Override
	public String viewUsername(String ID) {
		String sql = " SELECT U_NAME UserName FROM T_USER WHERE U_ID = ? ";
		List<String> params = new ArrayList<>();
		params.add(ID);
		return new CardDaoImpl().viewUserName(sql, params);
	}

	@Override
	public String viewPatientID(String CardNum) {
		String sql = " SELECT P_ID FROM T_PATIENT WHERE P_CARD_ID = ?  ";
		List<String> params = new ArrayList<>();
		params.add(CardNum);
		return new CardDaoImpl().viewPatientID(sql, params);
	}

	@Override
	public String viewCardID(String CardNum) {
		String sql = " SELECT C_ID FROM T_CARD WHERE CONCAT(C_PREFIX,C_NUMBER) = ? ";
		List<String> params = new ArrayList<>();
		params.add(CardNum);
		return new CardDaoImpl().viewCardAnyString(sql, params);
	}

	@Override
	public String viewAmount(String CardNum) {
		String sql = " SELECT C_AMOUNT FROM T_CARD WHERE CONCAT(C_PREFIX,C_NUMBER) = ? ";
		List<String> params = new ArrayList<>();
		params.add(CardNum);
		return new CardDaoImpl().viewCardAnyString(sql, params);
	}

	@Override
	public List<CardCensusInfBean> viewCardCensus(String timeDateStart, String timeDateEND, String cnoStart, String cnoEND, int CurrentPage, int Limit) {
		String sql = " SELECT CONCAT(B.C_PREFIX,B.C_NUMBER) P_CARD_ID,C.ARVL_CTIME,C.ARVL_ATIME,D.U_NAME,A.P_NAME,B.C_AMOUNT,B.C_STATE " +
				"FROM T_PATIENT A RIGHT JOIN T_CARD B ON A.P_CARD_ID = CONCAT(B.C_PREFIX,B.C_NUMBER) " +
				"INNER JOIN T_APPROVAL C ON B.C_APPROVAL_ID = C.ARVL_ID INNER JOIN T_USER D ON C.ARVL_MID = D.U_ID " +
				"WHERE 1=1 ";
		List<String> params = new ArrayList<>();
		if (timeDateStart != null && timeDateEND != null) {
			if ((!timeDateStart.trim().equals("")) && (!timeDateEND.trim().equals(""))) {
				sql += " AND TO_CHAR(C.ARVL_CTIME,'YYYY-MM-DD') BETWEEN ? AND ? ";
				params.add(timeDateStart);
				params.add(timeDateEND);
			}
		}

		if (cnoStart != null && cnoEND != null) {
			if ((!cnoStart.trim().equals("")) && (!cnoEND.trim().equals(""))) {
				sql += " AND CONCAT(B.C_PREFIX,B.C_NUMBER) BETWEEN ? AND ? ";
				params.add(cnoStart);
				params.add(cnoEND);
			}
		}

		sql = "SELECT * FROM ( SELECT A.*,ROWNUM RN FROM ( " + sql + "  ) A ) A WHERE A.RN BETWEEN ? AND ? ";
		params.add(String.valueOf(CurrentPage * Limit - (Limit - 1)));
		params.add(String.valueOf(CurrentPage * Limit));
		return new CardDaoImpl().viewCardCensus(sql, params);
	}

	@Override
	public int countCardCensus(String timeDateStart, String timeDateEND, String cnoStart, String cnoEND) {
		String sql = " SELECT COUNT(0) Count " +
				"FROM T_PATIENT A RIGHT JOIN T_CARD B ON A.P_CARD_ID = CONCAT(B.C_PREFIX,B.C_NUMBER) " +
				"INNER JOIN T_APPROVAL C ON B.C_APPROVAL_ID = C.ARVL_ID INNER JOIN T_USER D ON C.ARVL_MID = D.U_ID " +
				"WHERE 1=1 ";
		List<String> params = new ArrayList<>();
		if (timeDateStart != null && timeDateEND != null) {
			if ((!timeDateStart.trim().equals("")) && (!timeDateEND.trim().equals(""))) {
				sql += " AND TO_CHAR(C.ARVL_CTIME,'YYYY-MM-DD') BETWEEN ? AND ? ";
				params.add(timeDateStart);
				params.add(timeDateEND);
			}
		}

		if (cnoStart != null && cnoEND != null) {
			if ((!cnoStart.trim().equals("")) && (!cnoEND.trim().equals(""))) {
				sql += " AND CONCAT(B.C_PREFIX,B.C_NUMBER) BETWEEN ? AND ? ";
				params.add(cnoStart);
				params.add(cnoEND);
			}
		}
		return new CardDaoImpl().countCardCensus(sql, params);
	}

	@Override
	public List<CardInfBean> viewLGCTable(String CNUMStart, String CNUMEND, String CSatus, int CurrentPage, int Limit) {
		String sql = "SELECT * FROM T_CARD A INNER JOIN T_APPROVAL B ON A.C_APPROVAL_ID = B.ARVL_ID " +
				"LEFT JOIN  T_PATIENT C ON CONCAT(A.C_PREFIX,A.C_NUMBER) = C.P_CARD_ID " +
				"INNER JOIN T_USER D ON B.ARVL_CORID = D.U_ID WHERE 1=1 ";
		List<String> params = new ArrayList<>();
		if (CNUMStart != null && CNUMEND != null && (!CNUMStart.trim().equals("")) && (!CNUMEND.trim().equals(""))) {
			sql += " AND CONCAT(A.C_PREFIX,A.C_NUMBER) BETWEEN ? AND ? ";
			System.out.println(CNUMStart);
			System.out.println(CNUMEND);
			params.add(CNUMStart);
			params.add(CNUMEND);
		}

		if (CSatus != null) {
			if ((!CSatus.trim().equals(""))) {
				sql += " AND A.C_STATE = ?  ";
				params.add(CSatus);
			}
		}

		sql = "SELECT * FROM (SELECT A.*,ROWNUM RN FROM ( " + sql + " ) A) A WHERE A.RN BETWEEN ? AND ? ";
		params.add(String.valueOf(CurrentPage * Limit - (Limit - 1)));
		params.add(String.valueOf(CurrentPage * Limit));
		return new CardDaoImpl().viewCardInf(sql, params);
	}

	@Override
	public int countLGCTable(String CNUMStart, String CNUMEND, String CSatus) {
		String sql = "SELECT COUNT(0) Count FROM T_CARD A INNER JOIN T_APPROVAL B ON A.C_APPROVAL_ID = B.ARVL_ID " +
				"LEFT JOIN  T_PATIENT C ON CONCAT(A.C_PREFIX,A.C_NUMBER) = C.P_CARD_ID " +
				"INNER JOIN T_USER D ON B.ARVL_CORID = D.U_ID WHERE 1=1 ";
		List<String> params = new ArrayList<>();
		if (CNUMStart != null && CNUMEND != null && (!CNUMStart.trim().equals("")) && (!CNUMEND.trim().equals(""))) {
			sql += " AND CONCAT(A.C_PREFIX,A.C_NUMBER) BETWEEN ? AND ? ";
			System.out.println(CNUMStart);
			System.out.println(CNUMEND);
			params.add(CNUMStart);
			params.add(CNUMEND);
		}
		if (CSatus != null) {
			if ((!CSatus.trim().equals(""))) {
				sql += " AND A.C_STATE = ?  ";
				params.add(CSatus);
			}
		}
		return new CardDaoImpl().CountAnyInf(sql,params);
	}

	@Override
	public int LogOutCard(String ID) {
		String sql = " UPDATE T_CARD SET C_STATE = -1 WHERE C_ID = ? ";
		List<String> params = new ArrayList<>();
		params.add(ID);
		return new CardDaoImpl().updateAnyInf(sql, params);
	}

	@Override
	public List<CardInfBean> viewCardNum(String userID) {
		String sql = "SELECT C_ID,CONCAT(C_PREFIX,C_NUMBER) CNUM FROM T_CARD  "
				+ "WHERE C_COLLECTOR_ID = ? AND C_STATE = 1 ORDER BY CONCAT(C_PREFIX,C_NUMBER) ";
		List<String> params = new ArrayList<>();
		if (userID != null && (!userID.trim().equals(""))) {
			params.add(userID);
			return new CardDaoImpl().viewCardNum(sql,params);
		}
		return null;
	}


	//	字符串位数补齐
	public String completeNum(int Num, int Num2) {
		String temp = "" + Num;
		for (; temp.length() < Num2; temp = "0" + temp) ;
		return temp;
	}

	@Override
	public String viewUAccount(String userID) {
		// TODO Auto-generated method stub
		String sql = "SELECT U_ACCOUNT FROM T_USER WHERE U_ID = ? ";
		List<String> params = new ArrayList<>();
		params.add(userID);
		return new CardDaoImpl().viewUserName(sql, params);
	}
}
