package com.example.servlet;

import com.example.bean.UserRoleCountInfBean;
import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountAppCardTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String S_Requester = req.getParameter("S_Requester");
		String S_Status = req.getParameter("S_Status");
		String S_Date_Start = req.getParameter("S_Date_Start");
		String S_Date_End = req.getParameter("S_Date_End");

		ObjectMapper om = new ObjectMapper();
		int count = new CardServiceImpl().countAppInfTable(S_Requester, S_Status, S_Date_Start, S_Date_End);
		String json = om.writeValueAsString(new UserRoleCountInfBean(String.valueOf(count)));
		resp.getWriter().println(json);

	}
}
