package com.example.servlet;

import com.example.bean.RoleInfBean;
import com.example.service.RoleMTableServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UpdateRoleInfServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("UpdateRoleInfServlet");
		RoleMTableServiceImpl roleMTableService = new RoleMTableServiceImpl();
		List<RoleInfBean> roleInfBeans = roleMTableService.viewRoleInf();
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(roleInfBeans);
		resp.getWriter().println(json);
	}
}
