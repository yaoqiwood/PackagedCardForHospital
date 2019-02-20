package com.example.servlet;

import com.example.bean.UserLoginInfBean;
import com.example.bean.UserMessageBean;
import com.example.service.UserLoginServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginRequestServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LoginSuccess");
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String code = req.getParameter("code");

		code = code.toLowerCase();
		System.out.println(code);
		HttpSession hs = req.getSession();
		UserLoginServiceImpl userLoginService = new UserLoginServiceImpl();
		ObjectMapper om = new ObjectMapper();
		String json = null;
		UserLoginInfBean ret = userLoginService.UserLogin(username, password);
		if (ret != null) {
			if (hs.getAttribute("code").equals(code)) {
				hs.setAttribute("userID",ret.getUID());
				hs.setAttribute("username",username);
				json = om.writeValueAsString(new UserMessageBean("1", "登录成功", "./page_PM/index.jsp"));
			} else {
				json = om.writeValueAsString(new UserMessageBean("0", "登陆失败,验证码有误", null));
			}
			if (ret.getU_STATE().equals("0")){
				json = om.writeValueAsString(new UserMessageBean("0", "登陆失败,当前账号已被禁用", null));
			}
		} else {
			json = om.writeValueAsString(new UserMessageBean("0","登陆失败，账号密码有误",null));
		}
		resp.getWriter().println(json);
	}
}
