package com.example.servlet;

import com.example.bean.UserMessageBean;
import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutCardServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String delID = req.getParameter("delID");
		int ret = new CardServiceImpl().LogOutCard(delID);
		ObjectMapper om = new ObjectMapper();
		String json = null;
		if (ret > 0) {
			json = om.writeValueAsString(new UserMessageBean("1", "注销成功", null));
		} else {
			json = om.writeValueAsString(new UserMessageBean("0", "注销失败", null));
		}
		resp.getWriter().println(json);
	}
}
