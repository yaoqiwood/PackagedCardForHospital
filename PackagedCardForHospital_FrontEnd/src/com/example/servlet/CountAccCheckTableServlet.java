package com.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.example.bean.UserRoleCountInfBean;
import com.example.service.PatientServiceImpl;

public class CountAccCheckTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("CountAccCheckTableServlet");
		String ID = req.getParameter("ID");
		int count = new PatientServiceImpl().countAccCheckTable(ID);
		ObjectMapper  om = new ObjectMapper();
		String json = om.writeValueAsString(new UserRoleCountInfBean(String.valueOf(count)));
		resp.getWriter().println(json);
	}

}
