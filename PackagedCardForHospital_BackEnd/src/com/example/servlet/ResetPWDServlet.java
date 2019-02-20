package com.example.servlet;

import com.example.bean.UserMessageBean;
import com.example.service.BackLogServiceImpl;
import com.example.service.CardServiceImpl;
import com.example.service.RoleMTableServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ResetPWDServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String resetID = req.getParameter("resetID");
		ObjectMapper om = new ObjectMapper();
		RoleMTableServiceImpl roleMTableService = new RoleMTableServiceImpl();
		int ret = roleMTableService.resetPWD(resetID);
		String json = null;
		if (ret > 0) {
			new BackLogServiceImpl().BackAllUser(resetID, "重置了用户"+new CardServiceImpl().viewUAccount(resetID)+"的密码");
			json = om.writeValueAsString(new UserMessageBean("1", "重置成功", null));
		} else {
			json = om.writeValueAsString(new UserMessageBean("0","重置失败",null));
		}
		resp.getWriter().println(json);
	}
}
