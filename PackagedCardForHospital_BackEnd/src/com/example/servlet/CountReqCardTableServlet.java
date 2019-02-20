package com.example.servlet;

import com.example.bean.UserRoleCountInfBean;
import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountReqCardTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String RDateStart = req.getParameter("RDateStart");
		String RDateEND = req.getParameter("RDateEND");
		String AsseSatus = req.getParameter("AsseSatus");

		ObjectMapper om = new ObjectMapper();
		int count = new CardServiceImpl().countReqCardTable(RDateStart,RDateEND,AsseSatus);
		String json = om.writeValueAsString(new UserRoleCountInfBean(String.valueOf(count)));
		resp.getWriter().println(json);
	}
}
