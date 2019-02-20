package com.example.servlet;

import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ViewCardNumGroupServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String aid = req.getParameter("aid");
		System.out.println(aid+"aid");
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(new CardServiceImpl().viewAppCardGroup(aid));
		resp.getWriter().println(json);
	}
}
