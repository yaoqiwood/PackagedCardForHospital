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

public class DelSCardTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String delID = req.getParameter("delID");
		HttpSession hs = req.getSession();
		ObjectMapper om = new ObjectMapper();
		String json = null;
		String userID = null;
		if (new CardServiceImpl().findCardService(delID) == 0) {
			int ret = new CardServiceImpl().delScard(delID);
			json =  ret > 0 ? om.writeValueAsString(new UserMessageBean("1","删除成功",null))
					:
					om.writeValueAsString(new UserMessageBean("0","删除失败",null));
			if (ret>0) {
				if (hs.getAttribute("userID")!=null) {
					userID = hs.getAttribute("userID").toString();
					new BackLogServiceImpl().BackAllUser(userID, "用户："+new CardServiceImpl().viewUAccount(userID)+"删除了一张卡");
				}
			}
		} else {
			json = om.writeValueAsString(new UserMessageBean("3","删除失败，当前卡已领取",null));

		}
		resp.getWriter().println(json);
	}
}
