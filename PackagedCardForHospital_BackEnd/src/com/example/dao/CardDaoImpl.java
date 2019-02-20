package com.example.dao;

import com.example.bean.*;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CardDaoImpl implements CardDao {
	@Override
	public int cardInStocking(Connection conn, String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<CardStockInfBean> viewCardStockTable(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<CardStockInfBean> cardStockInfBeans = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String C_ID = set.getString("C_ID");
				String C_PREFIX = set.getString("C_PREFIX");
				String C_NUMBER = set.getString("C_NUMBER");
				String C_CTIME = set.getString("C_CTIME");
				String C_STATE = set.getString("C_STATE");
				cardStockInfBeans.add(new CardStockInfBean(C_ID, C_PREFIX, C_NUMBER, C_CTIME, C_STATE));
			}
			return cardStockInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}

		return null;
	}

	@Override
	public int countCardStockTable(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			if (set.next()) {
				return set.getInt("Count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	@Override
	public int findCardStatus(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			if (set.next()) {
				return set.getInt("Status");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	@Override
	public int delSCard(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	@Override
	public List<ReqCardInfBean> viewReqCardTable(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<ReqCardInfBean> reqCardInfBeans = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String ARVL_ID = set.getString("ARVL_ID");
				String ARVL_CTIME = set.getString("ARVL_CTIME");
				String ARVL_REQUESTNUM = set.getString("ARVL_REQUESTNUM");
				String ARVL_CORID = set.getString("ARVL_CORID");
				String ARVL_STATE = set.getString("ARVL_STATE");
				String ARVL_MID = set.getString("ARVL_MID");
				String ARVL_ATIME = set.getString("ARVL_ATIME");
				reqCardInfBeans.add(new ReqCardInfBean(ARVL_ID, ARVL_CTIME, ARVL_REQUESTNUM, ARVL_CORID, ARVL_STATE,
						ARVL_MID, ARVL_ATIME));
			}
			return reqCardInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public int addRequestData(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	@Override
	public int countReqCardTable(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			if (set.next()) {
				return set.getInt("Count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	@Override
	public int updateReqCardTable(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}

		return 0;
	}

	@Override
	public List<AppInfBean> viewAppTable(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<AppInfBean> appInfBeans = new ArrayList<>();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String ARVL_ID = set.getString("ARVL_ID");
				String ARVL_MID = set.getString("ARVL_MID");
				String ARVL_CORID = set.getString("ARVL_CORID");
				String ARVL_REQUESTNUM = set.getString("ARVL_REQUESTNUM");
				String ARVL_APPRNUM = set.getString("ARVL_APPRNUM");
				String ARVL_STATE = set.getString("ARVL_STATE");
				String ARVL_CTIME = set.getString("ARVL_CTIME");
				String ARVL_REMARK = set.getString("ARVL_REMARK");
				String ARVL_ATIME = set.getString("ARVL_ATIME");
				appInfBeans.add(new AppInfBean(ARVL_ID, ARVL_MID, ARVL_CORID, ARVL_REQUESTNUM, ARVL_APPRNUM, ARVL_STATE,
						ARVL_CTIME, ARVL_REMARK, ARVL_ATIME));
			}
			return appInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public int appRequestCard(Connection conn, String sql, String appCardID, String app_requester, String app_IDNUM) {
		PreparedStatement pstm = null;
		ResultSet set = null;

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, app_IDNUM);
			pstm.setString(2, app_requester);
			pstm.setString(3, appCardID);
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int viewWaitCardSize(String sql) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		try {
			pstm = conn.prepareStatement(sql);
			set = pstm.executeQuery();
			if (set.next()) {
				return set.getInt("Count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	@Override
	public List<AppCardIDCountBean> viewWaitAppCard(String sql, String size) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<AppCardIDCountBean> appCardIDCountBeans = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, size);
			set = pstm.executeQuery();
			while (set.next()) {
				appCardIDCountBeans.add(new AppCardIDCountBean(set.getString("C_ID")));
			}
			return appCardIDCountBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}

		return null;
	}

	@Override
	public int updateAppApproval(String sql, String AID, String UserID) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, UserID);
			pstm.setString(2, AID);
			int ret = pstm.executeUpdate();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}

		return 0;
	}

	@Override
	public List<AppCardIDCountBean> viewAppCardGroup(String sql, String AID) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<AppCardIDCountBean> appCardIDCountBeans = new ArrayList<>();

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, AID);
			set = pstm.executeQuery();
			while (set.next()) {
				appCardIDCountBeans.add(new AppCardIDCountBean(set.getString("C_PREFIX") + set.getString("C_NUMBER")));
			}
			return appCardIDCountBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public int checkCardNumExist(String sql, String CardNum) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, CardNum);
			set = pstm.executeQuery();
			if (set.next()) {
				return set.getInt("Count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}

		return 0;
	}

	@Override
	public int updateAmountWithCard(String sql, String Amount, String CardNUM, String CollecterID) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, Amount);
			pstm.setString(2, CollecterID);
			pstm.setString(3, CardNUM);
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	@Override
	public int updateChangeCard(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	@Override
	public String viewParams(String sql, String params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, params);
			set = pstm.executeQuery();
			if (set.next()) {
				return set.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	// 通用
	@Override
	public String oldNumParams(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			if (set.next()) {
				return set.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public int exitCard(String sql, String CardNum) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, CardNum);
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	@Override
	public List<CardInfBean> viewCardInf(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<CardInfBean> cardInfBeans = new ArrayList<>();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String ID = set.getString("C_ID");
				String CARD_NUM = set.getString("C_PREFIX") + set.getString("C_NUMBER");
				String CARD_STATUS = set.getString("C_STATE");
				String CARD_REQUESTOR = set.getString("U_NAME");
				String CARD_USER = set.getString("P_NAME");
				cardInfBeans.add(new CardInfBean(ID, CARD_NUM, CARD_STATUS, CARD_REQUESTOR, CARD_USER));
			}
			return cardInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public int CountAnyInf(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			if (set.next()) {
				return set.getInt("Count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	@Override
	public ViewCardInfBean viewCardPanelInf(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<ViewCardInfBean> ViewCardInfBeans = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String CardNum = set.getString("C_PREFIX") + set.getString("C_NUMBER");
				String CardAmount = set.getString("C_AMOUNT");
				String CardStatus = set.getString("C_STATE");
				String CardUser = set.getString("P_NAME");
				String CardRequester = set.getString("ARVL_CORID");
				String CardReqTime = set.getString("ARVL_ATIME");
				String CardVender = set.getString("C_COLLECTOR_ID");
				String CardVendTime = set.getString("C_VEND_TIME");
				return new ViewCardInfBean(CardNum, CardAmount, CardStatus, CardUser, CardRequester, CardReqTime,
						CardVender, CardVendTime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public String viewUserName(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			if (set.next()) {
				return set.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public String viewPatientID(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			if (set.next()) {
				return set.getString("P_ID");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public String viewCardAnyString(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			if (set.next()) {
				return set.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public List<CardCensusInfBean> viewCardCensus(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<CardCensusInfBean> cardCensusInfBeans = new ArrayList<>();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String P_CARD_ID = set.getString("P_CARD_ID");
				String ARVL_CTIME = set.getString("ARVL_CTIME");
				String ARVL_ATIME = set.getString("ARVL_ATIME");
				String U_NAME = set.getString("U_NAME");
				String P_NAME = set.getString("P_NAME");
				String C_AMOUNT = set.getString("C_AMOUNT");
				String C_STATE = set.getString("C_STATE");
				cardCensusInfBeans.add(
						new CardCensusInfBean(P_CARD_ID, ARVL_CTIME, ARVL_ATIME, U_NAME, P_NAME, C_AMOUNT, C_STATE));
			}
			return cardCensusInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public int countCardCensus(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			if (set.next()) {
				return set.getInt("Count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	@Override
	public int updateAnyInf(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			return pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	@Override
	public List<CardInfBean> viewCardNum(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<CardInfBean> cardInfBeans = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				cardInfBeans.add(new CardInfBean(set.getString("C_ID"), set.getString("CNUM"), null, null, null));
			}
			return cardInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

}
