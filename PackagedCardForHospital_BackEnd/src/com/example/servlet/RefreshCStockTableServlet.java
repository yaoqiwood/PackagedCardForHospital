package com.example.servlet;

import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RefreshCStockTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String CNStart = req.getParameter("CNStart");
		String CNEND = req.getParameter("CNEND");
		String CSatus = req.getParameter("CSatus");
		String StINDateStart = req.getParameter("StINDateStart");
		String StINDateEND = req.getParameter("StINDateEND");
		String CurrentPage = req.getParameter("CurrentPage");
		String Limit = req.getParameter("Limit");

		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(new CardServiceImpl().viewCardStockTable(CNStart,CNEND,CSatus,StINDateStart,StINDateEND,
				Integer.parseInt(CurrentPage),Integer.parseInt(Limit)));
		resp.getWriter().println(json);
	}
}
