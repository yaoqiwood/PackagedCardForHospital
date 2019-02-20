package com.example.servlet;

import com.example.bean.CardCensusInfBean;
import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RefCCensusTServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String timeDateStart = req.getParameter("timeDateStart");
		String timeDateEND = req.getParameter("timeDateEND");
		String cnoStart = req.getParameter("cnoStart");
		String cnoEND = req.getParameter("cnoEND");
		String CurrentPage = req.getParameter("CurrentPage");
		String Limit = req.getParameter("Limit");

		List<CardCensusInfBean> censusInfBeans = new CardServiceImpl().viewCardCensus(timeDateStart,timeDateEND,
				cnoStart,cnoEND,Integer.parseInt(CurrentPage),Integer.parseInt(Limit));

		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(censusInfBeans);
		resp.getWriter().println(json);
	}
}
