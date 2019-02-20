package com.example.servlet;

import com.example.bean.LeftPanelInfBean;
import com.example.service.IndexBackEndServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class InitLeftMenuServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		String ParentID = req.getParameter("ParentID");
		ObjectMapper om = new ObjectMapper();
		String json = null;
		List<LeftPanelInfBean> leftPanelInfBeans = new IndexBackEndServiceImpl().viewLeftPWMPanel(ParentID);
		json = om.writeValueAsString(leftPanelInfBeans);
		resp.getWriter().println(json);
	}
}
