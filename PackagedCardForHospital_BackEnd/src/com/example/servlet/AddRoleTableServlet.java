package com.example.servlet;

import com.example.bean.UserMessageBean;
import com.example.service.BackLogServiceImpl;
import com.example.service.RoleMTableServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddRoleTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		<!--  人员姓名    密码  确认密码  科室  角色   -->
		System.out.println("AddRoleTableServlet");
		String add_uAccount = req.getParameter("add_uAccount");
		String add_uname = req.getParameter("add_uname");
		String add_user_Password = req.getParameter("add_user_Password");
		String add_user_Department = req.getParameter("add_user_Department");
		String add_user_role = req.getParameter("add_user_role");

		HttpSession hs = req.getSession();
		String userID = hs.getAttribute("userID").toString();

		RoleMTableServiceImpl roleMTableService = new RoleMTableServiceImpl();
		int ret = roleMTableService.addRoleMTable(add_uAccount,add_uname, add_user_Password, add_user_role, add_user_Department);

		UserMessageBean userMessageBean = new UserMessageBean();
		ObjectMapper om = new ObjectMapper();
		String json = null;
		if (ret > 0) {
			userMessageBean.setID("1");
			userMessageBean.setMessage("插入成功");
//			插入日志
			new BackLogServiceImpl().BackLogAdd(userID,add_uAccount);
			json = om.writeValueAsString(userMessageBean);
		} else {
			userMessageBean.setID("0");
			userMessageBean.setMessage("插入失败");
			json = om.writeValueAsString(userMessageBean);
		}
		resp.getWriter().println(json);
	}
}
