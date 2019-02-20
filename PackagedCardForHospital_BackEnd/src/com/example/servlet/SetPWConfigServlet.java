package com.example.servlet;

import com.example.bean.UserMessageBean;
import com.example.service.BackLogServiceImpl;
import com.example.service.CardServiceImpl;
import com.example.service.RoleMTableServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetPWConfigServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("SetPWConfigServlet");
		String roleID = req.getParameter("roleID");
		String[] jsons = req.getParameterValues("jsons[]");
		HttpSession hs = req.getSession();
		System.out.println(roleID);
		List<String> params = new ArrayList<>(Arrays.asList(jsons));
		String userID = null;
		if (hs.getAttribute("userID") != null) {
			 userID = hs.getAttribute("userID").toString();
		}
		int ret = new RoleMTableServiceImpl().delRoleMenu(roleID);
		int res = new RoleMTableServiceImpl().insertRoleRalation(roleID, params);
		ObjectMapper om = new ObjectMapper();
		String json = null;
		if (ret > 0 && res > 0) {
			new BackLogServiceImpl().BackAllUser(userID, "用户：" + new CardServiceImpl().viewUAccount(userID) + "变更了权限");
			json = om.writeValueAsString(new UserMessageBean("1", "更变成功", null));
		} else {
			json = om.writeValueAsString(new UserMessageBean("0", "变更失败", null));
		}
		resp.getWriter().println(json);
	}
}
