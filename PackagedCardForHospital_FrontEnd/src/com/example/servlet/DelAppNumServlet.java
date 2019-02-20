package com.example.servlet;

import com.example.bean.UserMessageBean;
import com.example.service.DoctorServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelAppNumServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String ID = req.getParameter("ID");
		System.out.println(ID);
		ObjectMapper om = new ObjectMapper();
		int ret = new DoctorServiceImpl().delAppInf(ID);
		String json = null;
		if (ret > 0) {
			json = om.writeValueAsString(new UserMessageBean("1", "取号成功", null));
		} else {
			json = om.writeValueAsString(new UserMessageBean("0","取号失败",null));
		}
		resp.getWriter().println(json);
	}
}
