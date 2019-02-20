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
import java.io.IOException;

public class DelUserTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String delID = req.getParameter("delID");
		RoleMTableServiceImpl roleMTableService = new RoleMTableServiceImpl();
		int ret = roleMTableService.delRowDataUser(delID);
		String json = null;
		ObjectMapper om = new ObjectMapper();
		if (ret > 0) {
			new BackLogServiceImpl().BackAllUser(delID, "删除了用户：" + new CardServiceImpl().viewUAccount(delID));
			json = om.writeValueAsString(new UserMessageBean("1", "删除成功", null));
		} else {
			json = om.writeValueAsString(new UserMessageBean("0", "删除失败", null));
		}
		resp.getWriter().println(json);
	}
}
