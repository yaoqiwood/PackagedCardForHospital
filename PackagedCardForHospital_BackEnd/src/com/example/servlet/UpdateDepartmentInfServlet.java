package com.example.servlet;

import com.example.bean.DepartmentInfBean;
import com.example.service.RoleMTableServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UpdateDepartmentInfServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("UpdateDepartmentInfServlet");
		RoleMTableServiceImpl roleMTableService = new RoleMTableServiceImpl();
		List<DepartmentInfBean> departmentInfBeans = new ArrayList<>();
		departmentInfBeans = roleMTableService.viewDepartmentInf();
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(departmentInfBeans);
		resp.getWriter().println(json);
	}
}
