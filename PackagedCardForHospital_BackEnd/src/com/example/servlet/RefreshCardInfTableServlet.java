package com.example.servlet;

import com.example.bean.CardInfBean;
import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RefreshCardInfTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String CNUM = req.getParameter("CNUM");
		String CSatus = req.getParameter("CSatus");
		String requestor = req.getParameter("requestor");
		String CurrentPage = req.getParameter("CurrentPage");
		String Limit = req.getParameter("Limit");

		List<CardInfBean> cardInfBeans = new CardServiceImpl().viewCardInf(CNUM, CSatus, requestor, Integer.parseInt(CurrentPage), Integer.parseInt(Limit));
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(cardInfBeans);
		resp.getWriter().println(json);
	}
}
