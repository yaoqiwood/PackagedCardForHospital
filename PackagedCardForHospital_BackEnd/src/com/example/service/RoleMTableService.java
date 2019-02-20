package com.example.service;

import com.example.bean.DepartmentInfBean;
import com.example.bean.RoleInfBean;
import com.example.bean.UserRoleInfBean;

import java.util.List;

public interface RoleMTableService {
	/**
	 * 查管理人员表
	 *
	 * @param sName
	 * @param sDepartment
	 * @param sRole
	 * @param sState
	 * @param CurrentPage
	 * @param Limit
	 * @return
	 */

	public List<UserRoleInfBean> viewRoleMtable(String sName, String sDepartment, String sRole, String sState, int CurrentPage, int Limit);

	/**
	 * 查管理人员表总数
	 *
	 * @param sName
	 * @param sDepartment
	 * @param sRole
	 * @param sState
	 * @return
	 */
	public int countRoleMtable(String sName, String sDepartment, String sRole, String sState);

	/**
	 * 查询科室
	 *
	 * @return
	 */
	public List<DepartmentInfBean> viewDepartmentInf();

	/**
	 * 查角色
	 *
	 * @return
	 */
	public List<RoleInfBean> viewRoleInf();


	/**
	 * 增加数据
	 *
	 * @param add_uname
	 * @param add_user_Password
	 * @param add_user_Department
	 * @param add_user_role
	 * @return
	 */
	public int addRoleMTable(String add_uAccount, String add_uname, String add_user_Password, String add_user_Department, String add_user_role);

	/**
	 * @param modify_uAccount
	 * @param modify_uname
	 * @param modify_user_department
	 * @param modify_user_role
	 * @param id
	 * @return
	 */
	public int updateRoleMtable(String modify_uAccount, String modify_uname, String modify_user_department,
	                            String modify_user_role, String id);

	/**
	 * @param ban
	 * @return
	 */
	public int banornot(String ban, String ID);

	/**
	 * 伪删除
	 * @param delID
	 * @return
	 */
	public int delRowDataUser(String delID);

	/**
	 * resetPWD
	 * @param resetID
	 * @return
	 */
	public int resetPWD(String resetID);

	/**
	 *
	 * @param roleID
	 * @return
	 */
	public int delRoleMenu(String roleID);

	/**
	 *
	 * @param roleID
	 * @param params
	 * @return
	 */
	public int insertRoleRalation(String roleID,List<String> params);

	/**
	 *
	 * @param roleID
	 * @return
	 */
	public List<RoleInfBean> viewRequestorInf(String roleID);
	
	public List<RoleInfBean> viewCollectorInf();
}
