package com.example.dao;

import com.example.bean.DepartmentInfBean;
import com.example.bean.RoleInfBean;
import com.example.bean.UserRoleInfBean;
import com.example.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleMTableDaoImpl implements RoleMTableDao {

	@Override
	public List<UserRoleInfBean> viewRoleMtable(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<UserRoleInfBean> userRoleInfBeans = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String U_ID = set.getString("U_ID");
				String U_NAME = set.getString("U_NAME");
				String U_SEX = set.getString("U_SEX");
				String U_AGE = set.getString("U_AGE");
				String U_ACCOUNT = set.getString("U_ACCOUNT");
				String U_PWD = set.getString("U_PWD");
				String R_NAME = set.getString("R_NAME");
				String D_NAME = set.getString("D_NAME");
				String U_STATE = set.getString("U_STATE");
				String U_CTIME = set.getString("U_CTIME");
				String U_REMARK = set.getString("U_REMARK");
				String U_DEPARTMENT_ID = set.getString("U_DEPARTMENT_ID");
				String U_ROLE_ID = set.getString("U_ROLE_ID");
				userRoleInfBeans.add(new UserRoleInfBean(U_ID, U_NAME, U_SEX, U_AGE, U_ACCOUNT, U_PWD, R_NAME, D_NAME,
						U_STATE, U_CTIME, U_REMARK, U_DEPARTMENT_ID, U_ROLE_ID));
			}
			return userRoleInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public int countRoleMtable(String sql, List<String> params) {
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
	public List<DepartmentInfBean> viewDepartmentInf(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<DepartmentInfBean> departmentInfBeans = new ArrayList<>();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String ID = set.getString("D_ID");
				String D_NAME = set.getString("D_NAME");
				String D_STATE = set.getString("D_STATE");
				String D_CTIME = set.getString("D_CTIME");
				String D_REMARK = set.getString("D_REMARK");
				departmentInfBeans.add(new DepartmentInfBean(ID, D_NAME, D_STATE, D_CTIME, D_REMARK));
			}
			return departmentInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public List<RoleInfBean> viewRoleInf(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		List<RoleInfBean> roleInfBeans = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String ID = set.getString("R_ID");
				String R_NAME = set.getString("R_NAME");
				String R_CTIME = set.getString("R_CTIME");
				String R_STATE = set.getString("R_STATE");
				String R_REMARK = set.getString("R_REMARK");
				roleInfBeans.add(new RoleInfBean(ID, R_NAME, R_CTIME, R_STATE, R_REMARK));
			}
			return roleInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public int addRoleMTableInf(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
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
	public int updateMTableInf(String sql, List<String> params) {
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
	public int addBackLog(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
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
	public int banornot(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			int ret = pstm.executeUpdate();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}

		return 0;
	}

	// (虚假删除
	@Override
	public int delDataUser(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			int ret = pstm.executeUpdate();
			return ret;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return 0;
	}

	// 重置密码
	@Override
	public int resetPWD(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
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
	public int updateAnyInf(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
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
	public List<RoleInfBean> viewRequestorInf(String sql, List<String> params) {
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<RoleInfBean> roleInfBeans = new ArrayList<>();
		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String U_ID = set.getString("U_ID");
				String U_NAME = set.getString("U_NAME");
				String U_ROLE_ID = set.getString("U_ROLE_ID");
				roleInfBeans.add(new RoleInfBean(U_ID, U_NAME, null, null, U_ROLE_ID));
			}
			return roleInfBeans;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

	@Override
	public List<RoleInfBean> viewCollectorInf(String sql, List<String> params) {
		// TODO Auto-generated method stub
		PreparedStatement pstm = null;
		ResultSet set = null;
		Connection conn = DBUtil.createConn();
		List<RoleInfBean> roleInfBeans = new ArrayList<>();

		try {
			pstm = conn.prepareStatement(sql);
			for (int i = 0; i < params.size(); i++) {
				pstm.setString(i + 1, params.get(i));
			}
			set = pstm.executeQuery();
			while (set.next()) {
				String U_ID = set.getString("U_ID");
				String U_NAME = set.getString("U_NAME");
				roleInfBeans.add(new RoleInfBean(U_ID, U_NAME, null, null, null));
			}
			return roleInfBeans;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.closeConn(conn, pstm, set);
		}
		return null;
	}

}
