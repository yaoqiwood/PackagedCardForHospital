package com.example.servlet;

import com.example.bean.CardInfBean;
import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetCardNumDataServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GetCardNumDataServlet");
		HttpSession hs = req.getSession();
		String userID = hs.getAttribute("userID").toString();
		List<CardInfBean> cardInfBeans = new CardServiceImpl().viewCardNum(userID);
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(cardInfBeans);
		resp.getWriter().println(json);
	}
}
