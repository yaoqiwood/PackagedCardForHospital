package com.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import com.example.bean.RoleInfBean;
import com.example.service.RoleMTableServiceImpl;

public class FillWorkmanServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("FillWorkmanServlet");
		List<RoleInfBean> roleInfBeans = new RoleMTableServiceImpl().viewCollectorInf();
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(roleInfBeans);
		resp.getWriter().println(json);
	}

}
