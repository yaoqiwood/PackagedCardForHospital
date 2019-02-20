package com.example.servlet;

import com.example.bean.UserRoleCountInfBean;
import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountCStockTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String CNStart = req.getParameter("CNStart");
		String CNEND = req.getParameter("CNEND");
		String CSatus = req.getParameter("CSatus");
		String StINDateStart = req.getParameter("StINDateStart");
		String StINDateEND = req.getParameter("StINDateEND");

		ObjectMapper om = new ObjectMapper();
		int Count = new CardServiceImpl().countCardStockTable(CNStart,CNEND,CSatus,StINDateStart,StINDateEND);
		String json = om.writeValueAsString(new UserRoleCountInfBean(String.valueOf(Count)));
		resp.getWriter().println(json);
	}
}
