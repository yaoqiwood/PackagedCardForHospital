package com.example.servlet;

import com.example.bean.UserMessageBean;
import com.example.service.UserLoginServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ChangePWDServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		ObjectMapper om = new ObjectMapper();
		String used_PWD = req.getParameter("used_PWD");
		String new_PWD = req.getParameter("new_PWD");
		String json = null;
		System.out.println("ChangePWDServlet");
		if (hs.getAttribute("userID") == null) {
			json = om.writeValueAsString(new UserMessageBean("0", "尚未登陆，请登录后重试", null));
		} else {
			String UID = hs.getAttribute("userID").toString();
			int ret = new UserLoginServiceImpl().checkOriPWD(UID, used_PWD);
			if (ret > 0) {
				int out = new UserLoginServiceImpl().uptatePWD(UID, new_PWD);
				if (out > 0) {
					json = om.writeValueAsString(new UserMessageBean("1", "更新成功", null));
				} else {
					json = om.writeValueAsString(new UserMessageBean("0", "更新失败", null));
				}
			} else {
				json = om.writeValueAsString(new UserMessageBean("0", "更新失败，请检查旧密码是否输入正确", null));
			}
			System.out.println(ret);
		}
		resp.getWriter().println(json);

	}
}
