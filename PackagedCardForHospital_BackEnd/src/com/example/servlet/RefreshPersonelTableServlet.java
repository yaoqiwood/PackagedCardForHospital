package com.example.servlet;

import com.example.bean.UserRoleInfBean;
import com.example.service.RoleMTableServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RefreshPersonelTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("RefreshPersonelTable");
		String sName = req.getParameter("sName");
		String sDepartment = req.getParameter("sDepartment");
		String sRole = req.getParameter("sRole");
		String sState = req.getParameter("sState");
		String CurrentPage = req.getParameter("CurrentPage");
		String Limit = req.getParameter("Limit");

		ObjectMapper om = new ObjectMapper();
		RoleMTableServiceImpl roleMTableService = new RoleMTableServiceImpl();
		List<UserRoleInfBean> userRoleInfBeans = roleMTableService.viewRoleMtable(sName,sDepartment,sRole,sState,Integer.parseInt(CurrentPage),
				Integer.parseInt(Limit));
		String json = om.writeValueAsString(userRoleInfBeans);
		resp.getWriter().println(json);
	}
}
