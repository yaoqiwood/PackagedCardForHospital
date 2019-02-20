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

public class ReflgCInfTServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String CNUMStart = req.getParameter("CNUMStart");
		String CNUMEND = req.getParameter("CNUMEND");
		String CSatus = req.getParameter("CSatus");
		String CurrentPage = req.getParameter("CurrentPage");
		String Limit = req.getParameter("Limit");

		ObjectMapper om = new ObjectMapper();
		List<CardInfBean> cardInfBeans = new CardServiceImpl().viewLGCTable(CNUMStart,CNUMEND,CSatus,
				Integer.parseInt(CurrentPage),Integer.parseInt(Limit));
		String json = om.writeValueAsString(cardInfBeans);
		resp.getWriter().println(json);
	}
}
