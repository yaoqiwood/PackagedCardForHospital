package com.example.servlet;

import com.example.bean.CardAccCheckInfBean;
import com.example.service.PatientServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RefreshAccCheckTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ID = req.getParameter("ID");
		String CurrentPage = req.getParameter("CurrentPage");
		String Limit = req.getParameter("Limit");
		System.out.printf(ID);
		List<CardAccCheckInfBean> cardAccCheckInfBeans = new PatientServiceImpl().viewAccCheckTable(ID,
				Integer.parseInt(CurrentPage),Integer.parseInt(Limit));
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(cardAccCheckInfBeans);
		resp.getWriter().println(json);
	}
}
