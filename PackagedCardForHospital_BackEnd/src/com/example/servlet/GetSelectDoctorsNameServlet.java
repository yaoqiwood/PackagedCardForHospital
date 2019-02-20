package com.example.servlet;

import com.example.bean.DoctorInfBean;
import com.example.service.DoctorServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetSelectDoctorsNameServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("GetSelectDoctorsNameServlet");
		List<DoctorInfBean> doctorInfBeans = new DoctorServiceImpl().viewDoctorInf();
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(doctorInfBeans);
		resp.getWriter().println(json);
	}
}
