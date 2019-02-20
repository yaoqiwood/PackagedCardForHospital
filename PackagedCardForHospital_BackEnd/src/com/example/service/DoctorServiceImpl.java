package com.example.service;

import com.example.bean.ArrInfBean;
import com.example.bean.DoctorInfBean;
import com.example.dao.CardDaoImpl;
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
		}

		String PageStart = String.valueOf(CurrentPage * Limit - (Limit - 1));
		String PageEnd = String.valueOf(CurrentPage * Limit);
		sql = " SELECT * FROM ( " + sql + " ) A WHERE A.RN BETWEEN ? AND ? ";
		params.add(PageStart);
		params.add(PageEnd);
		return new DoctorDaoImpl().viewArrInf(sql, params);
	}

	@Override
	public int countArrInf(String sName) {
		String sql = "SELECT COUNT(0) Count " +
				" FROM T_USER A " +
				"       INNER JOIN T_ARRANGE B ON A.U_ID = B.A_DID " +
				"       INNER JOIN T_DEPARTMENT C ON A.U_DEPARTMENT_ID = C.D_ID WHERE 1=1 ";
		List<String> params = new ArrayList<>();
		if (sName != null && (!sName.trim().equals(""))) {
			sql += "  AND A.U_NAME = ?  ";
			params.add(sName);
		}
		return new CardDaoImpl().CountAnyInf(sql, params);
	}

	@Override
	public int updateArrInf(String aid, String modify_date) {
		String sql = "UPDATE T_ARRANGE SET A_ATIME = TO_DATE(?,'YYYY-MM-DD') WHERE A_ID = ? ";
		List<String> params = new ArrayList<>();
		params.add(modify_date);
		params.add(aid);
		return new DoctorDaoImpl().UpdateAnyInf(sql, params);
	}

	@Override
	public int delArrInf(String aid) {
		String sql = " DELETE FROM T_ARRANGE WHERE A_ID = ? ";
		List<String> params = new ArrayList<>();
		params.add(aid);
		return new DoctorDaoImpl().UpdateAnyInf(sql, params);
	}


}
