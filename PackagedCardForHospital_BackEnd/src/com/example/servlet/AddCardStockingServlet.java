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

public class AddCardStockingServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession hs = req.getSession();
		String add_CNStart = req.getParameter("add_CNStart");
		String add_CNEND = req.getParameter("add_CNEND");
		String add_Prefix = req.getParameter("add_Prefix");
		ObjectMapper om = new ObjectMapper();
		if (hs.getAttribute("userID") == null) {
			String json = om.writeValueAsString(new UserMessageBean("2", "游客，检测当前账号尚未登录,将跳转至登录页", "../index.jsp"));
			resp.getWriter().println(json);
			return;
		}

		CardServiceImpl cardService = new CardServiceImpl();
		int ret = cardService.cardInStocking(Integer.parseInt(add_CNStart), Integer.parseInt(add_CNEND), add_Prefix);
		System.out.println(ret);
		String json = null;
		if (ret > 0) {
			String userID = hs.getAttribute("userID").toString();
			new BackLogServiceImpl().BackLogCardStockingIN(userID, add_CNStart, add_CNEND);
			json = om.writeValueAsString(new UserMessageBean("1", "卡入库成功", null));
		} else {
			json = om.writeValueAsString(new UserMessageBean("0", "卡入库失败", null));
		}
		resp.getWriter().println(json);
	}

}
