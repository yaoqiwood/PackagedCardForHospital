package com.example.service;

import com.example.bean.ArrInfBean;
import com.example.bean.DoctorInfBean;
import com.example.dao.DoctorDaoImpl;

import java.util.ArrayList;
import java.util.List;

public class DoctorServiceImpl implements DoctorService {
	@Override
	public List<DoctorInfBean> viewDoctorInf() {
		String sql = "SELECT * FROM T_USER WHERE U_ROLE_ID = 2 ";
		List<String> params = new ArrayList<>();
		return new DoctorDaoImpl().viewDoctorInf(sql, params);
	}

	@Override
	public int addDoctorArr(String mid, String doctorID, String date) {
		String sql = "INSERT INTO T_ARRANGE VALUES (SEQ_T_ARRANGE.nextval,?,?,to_date(?,'YYYY-MM-DD'),null ,1,SYSDATE,SYSDATE,null ) ";
		List<String> params = new ArrayList<>();
		if (date != null && doctorID != null && mid != null) {
			if ((!date.trim().equals("")) && (!doctorID.trim().equals("")) && (!mid.trim().equals(""))) {
				params.add(mid);
				params.add(doctorID);
				params.add(date);
				return new DoctorDaoImpl().updateDoctorInf(sql, params);
			}
		}
		return 0;
	}

	@Override
	public List<ArrInfBean> viewArrInf(String sName, int CurrentPage, int Limit) {
		String sql = " SELECT A.*,to_char(A_ATIME,'YYYY-MM-DD') ADATE,ROWNUM RN FROM (SELECT * " +
				"                           FROM T_USER A " +
				"                                  INNER JOIN T_ARRANGE B ON A.U_ID = B.A_DID " +
				"                                  INNER JOIN T_DEPARTMENT C ON A.U_DEPARTMENT_ID = C.D_ID " +
				"                           ) A  WHERE 1 = 1 ";
		List<String> params = new ArrayList<>();
		if (sName != null && (!sName.trim().equals(""))) {
			sql += "  AND A.U_NAME = ?  ";
			params.add(sName);
			System.out.println(sName);
		}

		String PageStart = String.valueOf(CurrentPage * Limit - (Limit - 1));
		String PageEnd = String.valueOf(CurrentPage * Limit);
		sql = " SELECT * FROM ( " + sql + " ) A WHERE A.RN BETWEEN ? AND ? ";
		System.out.println(sql);
		params.add(PageStart);
		params.add(PageEnd);
		return new DoctorDaoImpl().viewArrInf(sql, params);
	}

	@Override
	public int updateAppoint(String timeRangeSelected, String tempID, String p_ID) {
		String sql = "INSERT INTO T_APPOINTMENT VALUES (SEQ_T_APPOINTMENT.nextval,?,?,?,1,SYSDATE,null) ";
		List<String> params = new ArrayList<>();
		params.add(tempID);
		params.add(p_ID);
		params.add(timeRangeSelected);
		return new DoctorDaoImpl().updateDoctorInf(sql, params);
	}

	@Override
	public String viewAppStatusOCC(String appID, String timeRange) {
		String sql = "SELECT P_NAME " +
				"FROM T_APPOINTMENT A " +
				"       INNER JOIN T_PATIENT B ON A.AP_PID = B.P_ID " +
				"WHERE 1 = 1 " +
				"  AND A.AP_STATE = 1 " +
				"  AND A.AP_TRANGE = ? " +
				"  AND A.AP_AID = ? ";
		List<String> params = new ArrayList<>();
		params.add(timeRange);
		params.add(appID);
		return new DoctorDaoImpl().viewAppOCC(sql, params);
	}

	@Override
	public List<ArrInfBean> viewArrIDInf(String ID, int CurrentPage, int Limit) {
		String sql = "SELECT A.*,to_char(A_ATIME,'YYYY-MM-DD') ADATE,ROWNUM RN FROM (SELECT * " +
				" FROM T_USER A " +
				" INNER JOIN T_ARRANGE B ON A.U_ID = B.A_DID " +
				" INNER JOIN T_DEPARTMENT C ON A.U_DEPARTMENT_ID = C.D_ID " +
				" INNER JOIN T_APPOINTMENT D ON B.A_ID = D.AP_AID " +
				" ) A  WHERE 1 = 1 ";
		List<String> params = new ArrayList<>();
		if (ID != null && (!ID.trim().equals(""))) {
			sql += " AND A.AP_PID = ? ";
			params.add(ID);
		}
		String PageStart = String.valueOf(CurrentPage * Limit - (Limit - 1));
		String PageEnd = String.valueOf(CurrentPage * Limit);
		sql = " SELECT * FROM ( " + sql + " ) A WHERE A.RN BETWEEN ? AND ? ";
		params.add(PageStart);
		params.add(PageEnd);
		return new DoctorDaoImpl().viewArrIDInf(sql,params);
	}

	@Override
	public int delAppInf(String ID) {
		String sql = " DELETE FROM T_APPOINTMENT WHERE AP_ID = ? ";
		List<String> params = new ArrayList<>();
		params.add(ID);
		return new DoctorDaoImpl().delAppInf(sql,params);
	}

	@Override
	public int appDisMoney(String CardNum) {
		String sql = " UPDATE T_CARD SET C_AMOUNT = (SELECT (C_AMOUNT-5) FROM T_CARD WHERE CONCAT(C_PREFIX,C_NUMBER) = ? ) " +
				"WHERE CONCAT(C_PREFIX,C_NUMBER) = ? AND C_STATE = 2 ";
		List<String> params = new ArrayList<>();
		params.add(CardNum);
		params.add(CardNum);
		return new DoctorDaoImpl().updateAnyInf(sql,params);
	}

	@Override
	public int countArrIDInf(String ID) {
		String sql = "SELECT COUNT(0) Count " +
				" FROM T_USER A " +
				" INNER JOIN T_ARRANGE B ON A.U_ID = B.A_DID " +
				" INNER JOIN T_DEPARTMENT C ON A.U_DEPARTMENT_ID = C.D_ID " +
				" INNER JOIN T_APPOINTMENT D ON B.A_ID = D.AP_AID " +
				" WHERE 1 = 1 ";
		List<String> params = new ArrayList<>();
		if (ID != null && (!ID.trim().equals(""))) {
			sql += " AND AP_PID = ? ";
			params.add(ID);
		}
		return new DoctorDaoImpl().countAnyInf(sql,params);
	}

	@Override
	public boolean checkAppPaLive(String AID, String PID) {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM T_APPOINTMENT WHERE AP_PID = ? AND AP_AID = ? ";
		List<String> params = new ArrayList<>();
		params.add(PID);
		params.add(AID);
		return new DoctorDaoImpl().checkAppPaLive(sql, params);
	}


}
