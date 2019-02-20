package com.example.servlet;

import com.example.bean.AppInfBean;
import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RefreshAppCardTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String S_Requester = req.getParameter("S_Requester");
		String S_Status = req.getParameter("S_Status");
		String S_Date_Start = req.getParameter("S_Date_Start");
		String S_Date_End = req.getParameter("S_Date_End");
		String CurrentPage = req.getParameter("CurrentPage");
		String Limit = req.getParameter("Limit");

		ObjectMapper om = new ObjectMapper();
		List<AppInfBean> appInfBeans = new CardServiceImpl().viewAppInfTable(S_Requester, S_Status, S_Date_Start, S_Date_End, Integer.parseInt(CurrentPage), Integer.parseInt(Limit));
		for (int i = 0; i < appInfBeans.size(); i++) {
			appInfBeans.get(i).setARVL_REMARK(appInfBeans.get(i).getARVL_CORID());
			appInfBeans.get(i).setARVL_CORID(new CardServiceImpl().viewUsername(appInfBeans.get(i).getARVL_CORID()));
			appInfBeans.get(i).setARVL_MID(new CardServiceImpl().viewUsername(appInfBeans.get(i).getARVL_MID()));
		}
		String json = om.writeValueAsString(appInfBeans);
		resp.getWriter().println(json);
	}
}
