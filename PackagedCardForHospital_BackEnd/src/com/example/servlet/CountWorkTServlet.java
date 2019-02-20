package com.example.servlet;

import com.example.bean.UserRoleCountInfBean;
import com.example.service.StreamServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountWorkTServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String timeDateStart = req.getParameter("timeDateStart");
		String timeDateEND = req.getParameter("timeDateEND");
		String workman = req.getParameter("workman");
		ObjectMapper om = new ObjectMapper();
		int count = new StreamServiceImpl().countWorkCen(timeDateStart,timeDateEND,workman);
		String json = om.writeValueAsString(new UserRoleCountInfBean(String.valueOf(count)));
		resp.getWriter().println(json);
	}
}
