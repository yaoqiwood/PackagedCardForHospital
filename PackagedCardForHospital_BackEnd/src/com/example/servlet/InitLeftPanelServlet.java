package com.example.servlet;

import com.example.bean.LeftPanelInfBean;
import com.example.dao.UserLoginDaoImpl;
import com.example.service.IndexBackEndServiceImpl;
import com.example.service.UserLoginServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class InitLeftPanelServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("InitLeftPanelServlet");
		HttpSession hs = req.getSession();
		String ParentID = req.getParameter("ParentID");
		ObjectMapper om = new ObjectMapper();
		String json = null;
		if (hs.getAttribute("userID") != null) {
			String userID = hs.getAttribute("userID").toString();
			String roleID = new UserLoginServiceImpl().viewRoleID(userID);
			List<LeftPanelInfBean> leftPanelInfBeans = new IndexBackEndServiceImpl().viewLeftPanel(ParentID,roleID);
			json = om.writeValueAsString(leftPanelInfBeans);
		}
		resp.getWriter().println(json);
	}
}
