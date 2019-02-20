package com.example.servlet;

import com.example.bean.NativeInfBean;
import com.example.service.CollectorService;
import com.example.service.CollectorServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetNativeServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper om = new ObjectMapper();
		List<NativeInfBean> nativeInfBeans = new CollectorServiceImpl().viewNativeInf();
		String json = om.writeValueAsString(nativeInfBeans);
		resp.getWriter().println(json);
	}
}
