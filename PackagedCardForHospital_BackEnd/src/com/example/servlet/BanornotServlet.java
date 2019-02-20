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

public class BanornotServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ban = req.getParameter("ban");
		String ID = req.getParameter("ID");
		RoleMTableServiceImpl roleMTableService = new RoleMTableServiceImpl();
		int ret = roleMTableService.banornot(ban, ID);
		String json = null;
		ObjectMapper om = new ObjectMapper();
		if (ret > 0) {
			new BackLogServiceImpl().BackBanNorNot(ID, ban, new CardServiceImpl().viewUAccount(ID));
			json = om.writeValueAsString(new UserMessageBean("1", ban.equals("0") ? "禁用成功" : "启用成功", null));
		} else {
			json = om.writeValueAsString(new UserMessageBean("0",ban.equals("0") ? "禁用失败" : "启用失败",null));
		}
		resp.getWriter().println(json);
	}
}
