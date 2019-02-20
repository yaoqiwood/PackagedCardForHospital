package com.example.servlet;

import com.example.bean.UserRoleCountInfBean;
import com.example.service.RoleMTableServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CountPersonelTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("countServlet");
		String sName = req.getParameter("sName");
		String sDepartment = req.getParameter("sDepartment");
		String sRole = req.getParameter("sRole");
		String sState = req.getParameter("sState");

		ObjectMapper om = new ObjectMapper();
		RoleMTableServiceImpl roleMTableService = new RoleMTableServiceImpl();
		int count = roleMTableService.countRoleMtable(sName,sDepartment,sRole,sState);
		String json = om.writeValueAsString(new UserRoleCountInfBean(String.valueOf(count)));
		resp.getWriter().println(json);
	}
}
