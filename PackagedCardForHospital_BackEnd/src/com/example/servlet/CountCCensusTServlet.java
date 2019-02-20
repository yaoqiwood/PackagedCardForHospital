package com.example.servlet;

import com.example.bean.UserRoleCountInfBean;
import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountCCensusTServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String timeDateStart = req.getParameter("timeDateStart");
		String timeDateEND = req.getParameter("timeDateEND");
		String cnoStart = req.getParameter("cnoStart");
		String cnoEND = req.getParameter("cnoEND");

		ObjectMapper om = new ObjectMapper();
		int count = new CardServiceImpl().countCardCensus(timeDateStart,timeDateStart,cnoStart,cnoEND);
		String json = om.writeValueAsString(new UserRoleCountInfBean(String.valueOf(count)));
		resp.getWriter().println(json);
	}
}
