package com.example.dao;

import com.example.bean.DepartmentInfBean;
import com.example.bean.RoleInfBean;
import com.example.bean.UserRoleInfBean;

import java.util.List;

public interface RoleMTableDao {

	/**
	 * 查管理人员表
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<UserRoleInfBean> viewRoleMtable(String sql, List<String> params);

	/**
	 * 查询数量
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public int countRoleMtable(String sql, List<String> params);

	/**
	 * 查询科室
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<DepartmentInfBean> viewDepartmentInf(String sql, List<String> params);

	/**
	 * 查询角色
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<RoleInfBean> viewRoleInf(String sql, List<String> params);

	/**
	 * 增加数据
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public int addRoleMTableInf(String sql, List<String> params);

	/**
	 * @param sql
	 * @param params
	 * @return
	 */
	public int updateMTableInf(String sql, List<String> params);

	/**
	 * @param sql
	 * @return
	 */
	public int addBackLog(String sql, List<String> params);

	/**
	 * 禁用与恢复
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public int banornot(String sql, List<String> params);

	/**
	 * 删除
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public int delDataUser(String sql, List<String> params);

	/**
	 * resetPWD
	 * @param sql
	 * @param params
	 * @return
	 */
	public int resetPWD(String sql, List<String> params);

	/**
	 * 更新通用信息
	 * @param sql
	 * @param params
	 * @return
	 */
	public int updateAnyInf(String sql,List<String> params);

	/**
	 *
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<RoleInfBean> viewRequestorInf(String sql,List<String> params);
	
	/**
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<RoleInfBean> viewCollectorInf(String sql,List<String> params);
}
