package com.example.servlet;

import com.example.bean.ReturnLoginNameBean;
import com.example.bean.UserMessageBean;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ViewRequestorNameServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		ObjectMapper om = new ObjectMapper();
		String json = null;
		if (hs.getAttribute("username") == null) {
			json = om.writeValueAsString(new UserMessageBean("0", "检测到当前账号尚未登录，将为您跳转至主页", null));
		} else {
			json = om.writeValueAsString(new ReturnLoginNameBean("1",hs.getAttribute("userID").toString()
					,hs.getAttribute("username").toString(),null));
		}
		resp.getWriter().println(json);
	}
}
