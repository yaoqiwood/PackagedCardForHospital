package com.example.service;

import com.example.bean.DepartmentInfBean;
import com.example.bean.RoleInfBean;
import com.example.bean.UserRoleInfBean;
import com.example.dao.RoleMTableDaoImpl;

import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class RoleMTableServiceImpl implements RoleMTableService {

	@Override
	public List<UserRoleInfBean> viewRoleMtable(String sName, String sDepartment, String sRole, String sState, int CurrentPage, int Limit) {
		String sql = "SELECT A.*,ROWNUM RN FROM (SELECT * FROM T_USER A INNER JOIN T_DEPARTMENT B ON " +
				" A.U_DEPARTMENT_ID = B.D_ID INNER JOIN T_ROLE C ON A.U_ROLE_ID = C.R_ID ORDER BY A.U_NAME) A WHERE 1=1 AND A.U_STATE != 3 ";
		List<String> params = new ArrayList<>();
		RoleMTableDaoImpl roleMTableDao = new RoleMTableDaoImpl();

		if (sName != null && (!sName.trim().equals(""))) {
			sql += " AND U_NAME = ? ";
			params.add(sName);
		}

		if (sDepartment != null && (!sDepartment.trim().equals(""))) {
			sql += " AND U_DEPARTMENT_ID = ? ";
			params.add(sDepartment);
		}

		if (sRole != null && (!sRole.trim().equals(""))) {
			sql += " AND U_ROLE_ID = ? ";
			params.add(sRole);
		}

		if (sState != null && (!sState.trim().equals(""))) {
			sql += " AND U_STATE = ? ";
			params.add(sState);
		}

		sql += " ORDER BY U_NAME ";

		String PageStart = String.valueOf(CurrentPage * Limit - (Limit - 1));
		String PageEnd = String.valueOf(CurrentPage * Limit);
		sql = " SELECT * FROM ( " + sql + " ) A WHERE A.RN BETWEEN ? AND ? ";
		params.add(PageStart);
		params.add(PageEnd);

		return roleMTableDao.viewRoleMtable(sql, params);
	}

	@Override
	public int countRoleMtable(String sName, String sDepartment, String sRole, String sState) {
		String sql = "SELECT COUNT(0) Count FROM  T_USER A INNER JOIN T_DEPARTMENT B ON " +
				"A.U_DEPARTMENT_ID = B.D_ID INNER JOIN T_ROLE C ON A.U_ROLE_ID = C.R_ID WHERE 1=1 AND A.U_STATE != 3";
		List<String> params = new ArrayList<>();
		RoleMTableDaoImpl roleMTableDao = new RoleMTableDaoImpl();

		if (sName != null && (!sName.trim().equals(""))) {
			sql += " AND U_NAME = ? ";
			params.add(sName);
		}

		if (sDepartment != null && (!sDepartment.trim().equals(""))) {
			sql += " AND U_DEPARTMENT_ID = ? ";
			params.add(sDepartment);
		}

		if (sRole != null && (!sRole.trim().equals(""))) {
			sql += " AND U_ROLE_ID = ? ";
			params.add(sRole);
		}

		if (sState != null && (!sState.trim().equals(""))) {
			sql += " AND U_STATE = ? ";
			params.add(sState);
		}
		return roleMTableDao.countRoleMtable(sql, params);
	}

	@Override
	public List<DepartmentInfBean> viewDepartmentInf() {
		String sql = "SELECT * FROM T_DEPARTMENT";
		RoleMTableDaoImpl roleMTableDao = new RoleMTableDaoImpl();
		List<String> params = new ArrayList<>();
		return roleMTableDao.viewDepartmentInf(sql, params);
	}

	@Override
	public List<RoleInfBean> viewRoleInf() {
		String sql = "SELECT * FROM T_ROLE ";
		List<String> params = new ArrayList<>();
		RoleMTableDaoImpl roleMTableDao = new RoleMTableDaoImpl();
		return roleMTableDao.viewRoleInf(sql, params);
	}

	@Override
	public int addRoleMTable(String add_uAccount, String add_uname, String add_user_Password, String add_user_Department, String add_user_role) {
		System.out.println(add_uname + " : " + " : " + add_user_Password + " : " + add_user_role + " : " + add_user_Department);
		String sql = "INSERT INTO T_USER (U_ID,U_ACCOUNT,U_NAME,U_PWD,U_DEPARTMENT_ID,U_ROLE_ID,U_STATE) VALUES (SEQ_T_USER.nextval,?,?,?,?,?,1) ";
		List<String> params = new ArrayList<>();
		if (add_uAccount != null && (!add_uAccount.trim().equals(""))) {
			params.add(add_uAccount);
		}
		if (add_uname != null && (!add_uname.trim().equals(""))) {
			params.add(add_uname);
		}
		if (add_user_Password != null && (!add_user_Password.trim().equals(""))) {
			params.add(add_user_Password);
		}
		if (add_user_role != null && (!add_user_role.trim().equals(""))) {
			params.add(add_user_role);
		}
		if (add_user_Department != null && (!add_user_Department.trim().equals(""))) {
			params.add(add_user_Department);
		}

		RoleMTableDaoImpl roleMTableDao = new RoleMTableDaoImpl();
		return roleMTableDao.addRoleMTableInf(sql, params);
	}

	@Override
	public int updateRoleMtable(String modify_uAccount, String modify_uname, String modify_user_department, String modify_user_role, String id) {
		String sql = "UPDATE T_USER SET U_NAME = ?,U_DEPARTMENT_ID = ?,U_ROLE_ID = ? WHERE U_ID = ? ";
		RoleMTableDaoImpl roleMTableDao = new RoleMTableDaoImpl();
		List<String> params = new ArrayList<>();
		if (modify_uAccount != null && modify_uname != null && modify_user_department != null && modify_user_role != null && id != null) {
			if ((!modify_uAccount.trim().equals("")) && (!modify_uname.trim().equals("")) && (!modify_user_department.trim().equals("")) &&
					(!modify_user_role.trim().equals("")) && (!id.trim().equals(""))) {
				params.add(modify_uname);
				params.add(modify_user_department);
				params.add(modify_user_role);
				params.add(id);
				return roleMTableDao.updateMTableInf(sql, params);
			}
		}
		return 0;
	}

	@Override
	public int banornot(String ban, String ID) {
		String sql = "UPDATE T_USER SET U_STATE = ? WHERE U_ID = ? ";
		RoleMTableDaoImpl roleMTableDao = new RoleMTableDaoImpl();
		List<String> params = new ArrayList<>();
		if (ban != null && ID != null) {
			if ((!ban.equals("")) && (!ID.equals(""))) {
				params.add(ban);
				params.add(ID);
				return new RoleMTableDaoImpl().banornot(sql, params);
			}
		}
		return 0;
	}

	@Override
	public int delRowDataUser(String delID) {
		String sql = "UPDATE T_USER SET U_STATE = 3 WHERE U_ID = ? ";
		RoleMTableDaoImpl roleMTableDao = new RoleMTableDaoImpl();
		List<String> params = new ArrayList<>();
		params.add(delID);
		System.out.println(delID);
		return roleMTableDao.delDataUser(sql, params);
	}

	@Override
	public int resetPWD(String resetID) {
		String sql = "UPDATE T_USER SET U_PWD = ? WHERE U_ID = ? ";
		List<String> params = new ArrayList<>();
		if (resetID != null && (!resetID.trim().equals(""))) {
			params.add("123456");
			params.add(resetID);
			return new RoleMTableDaoImpl().resetPWD(sql, params);
		}
		return 0;
	}

	@Override
	public int delRoleMenu(String roleID) {
		String sql = " DELETE FROM T_RM_RELATION WHERE RM_RID = ? ";
		List<String> params = new ArrayList<>();
		params.add(roleID);
		return new RoleMTableDaoImpl().updateAnyInf(sql, params);
	}

	@Override
	public int insertRoleRalation(String roleID, List<String> params) {
		String sql = " INSERT INTO T_RM_RELATION VALUES (SEQ_T_RM_RELATION.nextval,?,?,1,SYSDATE,null) ";
		List<String> tempParams = new ArrayList<>();
		int ret = 0;
		for (int i = 0; i < params.size(); i++) {
			tempParams.add(roleID);
			tempParams.add(params.get(i));
			int res = new RoleMTableDaoImpl().updateAnyInf(sql, tempParams);
			ret += res > 0 ? 1 : 0;
			tempParams.clear();
		}
		ret = ret == params.size() ? 1 : 0;
		return ret;
	}

	@Override
	public List<RoleInfBean> viewRequestorInf(String roleID) {
		String sql = " SELECT * FROM T_USER WHERE 1=1 AND U_ROLE_ID = ? ";
		List<String> params = new ArrayList<>();
		params.add(roleID);
		return new RoleMTableDaoImpl().viewRequestorInf(sql,params);
	}

	@Override
	public List<RoleInfBean> viewCollectorInf() {
		// TODO Auto-generated method stub
		String sql = "   SELECT * FROM T_USER WHERE U_ROLE_ID = 3 ORDER BY U_ID  ";
		List<String> params = new ArrayList<>();
		return new RoleMTableDaoImpl().viewCollectorInf(sql, params);
	}


}
