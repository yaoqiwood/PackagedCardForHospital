package com.example.servlet;

import com.example.bean.UserMessageBean;
import com.example.service.DoctorServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FindAppointServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String appID = req.getParameter("appID");
		String timeRange = req.getParameter("timeRange");
		System.out.println("appID:" + appID + "timeRange:" + timeRange);
		ObjectMapper om = new ObjectMapper();
		String pname = new DoctorServiceImpl().viewAppStatusOCC(appID, timeRange);
		String json = null;
		if (pname != null) {
			json = om.writeValueAsString(new UserMessageBean("1", pname, null));
		} else {
			json = om.writeValueAsString(new UserMessageBean("0",null,null));
		}
		resp.getWriter().println(json);
	}
}
