package com.example.servlet;

import com.example.bean.UserMessageBean;
import com.example.service.BackLogServiceImpl;
import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

public class UpdateReqCardTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String modify_reqNum = req.getParameter("modify_reqNum");
		String modify_id = req.getParameter("modify_id");
		HttpSession hs = req.getSession();
		
		ObjectMapper om = new ObjectMapper();
		CardServiceImpl cardService = new CardServiceImpl();
		int ret = cardService.updateReqCardTable(modify_reqNum, modify_id);
		String json = null;
		if (ret > 0) {
			if (hs.getAttribute("userID") != null) {
				String userID = hs.getAttribute("userID").toString();
				new BackLogServiceImpl().BackAllUser(userID, "用户："+new CardServiceImpl().viewUAccount(userID)+"修改了一条申请领卡数据");
			}
			json = om.writeValueAsString(new UserMessageBean("1", "更新成功", null));
		} else {
			json = om.writeValueAsString(new UserMessageBean("0","更新失败",null));
		}
		resp.getWriter().println(json);
	}
}
