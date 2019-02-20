package com.example.service;

import com.example.bean.NativeInfBean;
import com.example.bean.PatientInfBean;
import com.example.dao.CollectorDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class CollectorServiceImpl implements CollectorService {
	@Override
	public List<NativeInfBean> viewNativeInf() {
		String sql = "SELECT * FROM T_NATIVE ";
		return new CollectorDaoImpl().viewNativeInf(sql);
	}

	@Override
	public int addPatient(String sold_name, String sold_age, String sex, String U_native, String idNum, String phone, String address, String preStore, String cardNum) {
		String sql = "INSERT INTO T_PATIENT VALUES (SEQ_T_PATIENT.nextval,?,?,?,?,?,?,?,null,?) ";
		List<String> params = new ArrayList<>();
		if (sold_name != null && sold_age != null && sex != null && U_native != null && idNum != null && phone != null && address != null && preStore != null && cardNum != null) {
			if ((!sold_name.trim().equals("")) && (!sold_age.trim().equals("")) && (!sex.trim().equals("")) && (!U_native.trim().equals("")) && (!idNum.trim().equals("")) && (!phone.trim().equals("")) && (!address.trim().equals("")) && (!preStore.trim().equals("")) && (!cardNum.trim().equals(""))) {
				params.add(sold_name);
				params.add(sex);
				params.add(sold_age);
				params.add(idNum);
				params.add(U_native);
				params.add(phone);
				params.add(address);
				params.add(cardNum);
				return new CollectorDaoImpl().addPatient(sql,params);
			}
		}
		return 0;
	}

	@Override
	public List<PatientInfBean> viewPatientInf(String NumID) {
		String sql = " SELECT * " +
				" FROM T_PATIENT A " +
				"       INNER JOIN T_CARD B ON A.P_CARD_ID = CONCAT(B.C_PREFIX, B.C_NUMBER) " +
				" WHERE A.P_CARD_ID = ? OR P_PHONE = ? OR P_IDNUMBER = ?";
		List<String> params = new ArrayList<>();
		params.add(NumID);
		params.add(NumID);
		params.add(NumID);
		return new CollectorDaoImpl().viewPatientInf(sql,params);
	}


}
