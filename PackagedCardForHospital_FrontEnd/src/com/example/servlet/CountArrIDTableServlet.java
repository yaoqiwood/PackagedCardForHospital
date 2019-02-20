package com.example.servlet;

import com.example.bean.UserRoleCountInfBean;
import com.example.service.DoctorServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountArrIDTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ID = req.getParameter("ID");
		ObjectMapper om = new ObjectMapper();
		int count = new DoctorServiceImpl().countArrIDInf(ID);
		String json = om.writeValueAsString(new UserRoleCountInfBean(String.valueOf(count)));
		resp.getWriter().println(json);
	}
}
