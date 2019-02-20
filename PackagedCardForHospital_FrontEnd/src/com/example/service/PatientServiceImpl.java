package com.example.service;

import com.example.bean.CardAccCheckInfBean;
import com.example.bean.PatientInfBean;
import com.example.dao.PatientDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class PatientServiceImpl implements PatientService {

	@Override
	public List<PatientInfBean> viewPatientInf(String CardNUm) {
		String sql = "SELECT * FROM T_PATIENT A INNER JOIN T_CARD B ON A.P_CARD_ID = CONCAT(B.C_PREFIX,B.C_NUMBER) WHERE A.P_CARD_ID = ? ";
		return new PatientDaoImpl().viewPatientInf(sql, CardNUm);
	}

	@Override
	public int topUpCardAmount(String CardNum, String MoneyNum) {
		String sql = "UPDATE T_CARD SET C_AMOUNT = (SELECT C_AMOUNT FROM T_CARD WHERE CONCAT(C_PREFIX,C_NUMBER) = ? ) + ?  WHERE CONCAT(C_PREFIX,C_NUMBER) = ? ";
		return new PatientDaoImpl().topUpPatientCard(sql, CardNum, MoneyNum);
	}

	@Override
	public String viewPatientID(String CardNum) {
		String sql = "SELECT P_ID FROM T_PATIENT WHERE P_CARD_ID = ? ";
		List<String> params = new ArrayList<>();
		params.add(CardNum);
		return new PatientDaoImpl().viewAnyString(sql, params);
	}

	@Override
	public String viewCardID(String CardNum) {
		String sql = " SELECT C_ID FROM T_CARD WHERE CONCAT(C_PREFIX,C_NUMBER) = ? ";
		List<String> params = new ArrayList<>();
		params.add(CardNum);
		return new PatientDaoImpl().viewAnyString(sql, params);
	}

	@Override
	public List<CardAccCheckInfBean> viewAccCheckTable(String ID, int CurrentPage, int Limit) {
		String sql = "SELECT A.*,ROWNUM RN FROM " +
				"(SELECT * FROM T_STREAM A LEFT JOIN T_USER B ON A.S_UID = B.U_ID WHERE 1=1 AND S_PID = ?) A ";
		List<String> params = new ArrayList<>();
		params.add(ID);
		params.add(String.valueOf(CurrentPage * Limit - (Limit - 1)));
		params.add(String.valueOf(CurrentPage * Limit));
		sql = "SELECT * FROM ( " + sql + " ) A " + " WHERE A.RN BETWEEN ? AND ?";
		return new PatientDaoImpl().viewAccCheckTable(sql, params);
	}

	@Override
	public int countAccCheckTable(String ID) {
		// TODO Auto-generated method stub
		String sql = "SELECT COUNT(0) Count FROM T_STREAM A LEFT JOIN T_USER B ON A.S_UID = B.U_ID WHERE 1=1 AND S_PID = ? ";
		List<String> params = new ArrayList<>();
		params.add(ID);
		return new PatientDaoImpl().viewAnyInt(sql, params);
	}
}
