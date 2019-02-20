package com.example.servlet;

import com.example.bean.UserRoleCountInfBean;
import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountCardInfTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String CNUM = req.getParameter("CNUM");
		String CSatus = req.getParameter("CSatus");
		String requestor = req.getParameter("requestor");
//		System.out.println(CNUM+":"+CSatus+":"+requestor);
		int Count = new CardServiceImpl().countCardInf(CNUM,CSatus,requestor);
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(new UserRoleCountInfBean(String.valueOf(Count)));
		resp.getWriter().println(json);
	}
}
