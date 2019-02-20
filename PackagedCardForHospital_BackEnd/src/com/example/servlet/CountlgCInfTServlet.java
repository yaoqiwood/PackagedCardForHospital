package com.example.servlet;

import com.example.bean.UserRoleCountInfBean;
import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountlgCInfTServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String CNUMStart = req.getParameter("CNUMStart");
		String CNUMEND = req.getParameter("CNUMEND");
		String CSatus = req.getParameter("CSatus");

		int count = new CardServiceImpl().countLGCTable(CNUMStart,CNUMEND,CSatus);
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(new UserRoleCountInfBean(String.valueOf(count)));
		resp.getWriter().println(json);
	}
}
