package com.example.servlet;

import com.example.bean.ReqCardInfBean;
import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RefreshReqCardTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String RDateStart = req.getParameter("RDateStart");
		String RDateEND = req.getParameter("RDateEND");
		String AsseSatus = req.getParameter("AsseSatus");
		String CurrentPage = req.getParameter("CurrentPage");
		String Limit = req.getParameter("Limit");

		ObjectMapper om = new ObjectMapper();
		CardServiceImpl cardService = new CardServiceImpl();
		List<ReqCardInfBean> reqCardInfBeans = cardService.viewReqCardTable(RDateStart, RDateEND, AsseSatus,
				Integer.parseInt(CurrentPage), Integer.parseInt(Limit));
		
		for (int i = 0; i < reqCardInfBeans.size(); i++) {
			reqCardInfBeans.get(i).setARVL_CORID(new CardServiceImpl().viewUsername(reqCardInfBeans.get(i).getARVL_CORID()));
			reqCardInfBeans.get(i).setARVL_MID(new CardServiceImpl().viewUsername(reqCardInfBeans.get(i).getARVL_MID()));
		}

		String json = om.writeValueAsString(reqCardInfBeans);
		resp.getWriter().println(json);

	}
}
