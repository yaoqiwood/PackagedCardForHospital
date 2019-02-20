package com.example.servlet;

import com.example.bean.UserMessageBean;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginOrNotServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		ObjectMapper om = new ObjectMapper();
		if (hs.getAttribute("userID") == null){
			String json = om.writeValueAsString(new UserMessageBean("0","用户尚未登录，将为您跳转","../index.jsp"));
			resp.getWriter().println(json);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
}
