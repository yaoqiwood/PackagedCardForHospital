package com.example.servlet;

import com.example.bean.UserMessageBean;
import com.example.service.DoctorServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DelArrTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String aid = req.getParameter("aid");
		int ret = new DoctorServiceImpl().delArrInf(aid);
		ObjectMapper om = new ObjectMapper();
		String json = null;
		if (ret > 0) {
			json = om.writeValueAsString(new UserMessageBean("1","删除成功", null));
		} else {
			json = om.writeValueAsString(new UserMessageBean("0","删除失败",null));
		}
		resp.getWriter().println(json);
	}
}
