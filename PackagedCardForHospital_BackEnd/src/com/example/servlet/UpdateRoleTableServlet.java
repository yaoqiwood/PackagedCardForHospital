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

public class UpdateRoleTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("UpdateRoleTableServlet");
		String modify_uAccount = req.getParameter("modify_uAccount");
		String modify_uname = req.getParameter("modify_uname");
		String modify_user_department = req.getParameter("modify_user_department");
		String modify_user_role = req.getParameter("modify_user_role");
		String id = req.getParameter("id");
		System.out.println(modify_uAccount+" : "+modify_uname+" : "+modify_user_department+" : "+modify_user_role+" : "+id);

		HttpSession hs = req.getSession();
		String userID = hs.getAttribute("userID").toString();
		ObjectMapper om = new ObjectMapper();
		RoleMTableServiceImpl roleMTableService = new RoleMTableServiceImpl();
		int ret = roleMTableService.updateRoleMtable(modify_uAccount, modify_uname, modify_user_department, modify_user_role, id);
		String json = null;
		if (ret > 0) {
			new BackLogServiceImpl().BackLogUpdate(userID, modify_uAccount);
			json = om.writeValueAsString(new UserMessageBean("1", "修改成功", null));
		} else {
			json = om.writeValueAsString(new UserMessageBean("0", "修改失败", null));
		}
		resp.getWriter().println(json);
	}
}
