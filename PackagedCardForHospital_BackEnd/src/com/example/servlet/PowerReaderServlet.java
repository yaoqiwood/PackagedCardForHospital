package com.example.servlet;

import com.example.bean.PwManageBean;
import com.example.service.IndexBackEndServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class PowerReaderServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String UserID = req.getParameter("UserID");

		List<PwManageBean> pwManageBeans = new IndexBackEndServiceImpl().viewPwManainf(UserID);
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(pwManageBeans);
		resp.getWriter().println(json);
	}
}
