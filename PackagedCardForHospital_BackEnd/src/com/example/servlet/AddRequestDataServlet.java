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

public class AddRequestDataServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		System.out.println(hs.getAttribute("userID"));
		String add_requester = hs.getAttribute("userID").toString();
		String add_reqDate = req.getParameter("add_reqDate");
		String add_reqNum = req.getParameter("add_reqNum");

		CardServiceImpl cardService = new CardServiceImpl();
		ObjectMapper om = new ObjectMapper();
		String json = null;
		int ret = cardService.addReqCardData(add_requester, add_reqDate, add_reqNum);
		if (ret > 0) {
			if (hs.getAttribute("userID") != null) {
				String userID = hs.getAttribute("userID").toString();
				new BackLogServiceImpl().BackAllUser(userID, "用户："+new CardServiceImpl().viewUAccount(userID)+"增加了一条申请领卡数据");
			}
			json = om.writeValueAsString(new UserMessageBean("1", "添加成功", null));
		} else {
			json = om.writeValueAsString(new UserMessageBean("0", "添加失败", null));
		}
		resp.getWriter().println(json);
	}
}
