package com.example.servlet;

import com.example.bean.ViewCardInfBean;
import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewCardInfPanelServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String CardID = req.getParameter("CardID");
		ViewCardInfBean viewCardInfBean = new CardServiceImpl().viewCardPanelInf(CardID);
		ObjectMapper om = new ObjectMapper();
		viewCardInfBean.setCardRequester(new CardServiceImpl().viewUsername(viewCardInfBean.getCardRequester()));
		viewCardInfBean.setCardVender(new CardServiceImpl().viewUsername(viewCardInfBean.getCardVender()));
		String json = om.writeValueAsString(viewCardInfBean);
		resp.getWriter().println(json);
	}
}
