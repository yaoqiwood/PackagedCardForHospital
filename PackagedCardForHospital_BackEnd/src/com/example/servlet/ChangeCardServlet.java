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

public class ChangeCardServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ChangeCardServlet");
		String CardNum = req.getParameter("CardNum");
		String ChangeCardNum = req.getParameter("ChangeCardNum");
		System.out.println(CardNum + ":" + ChangeCardNum);
		HttpSession hs = req.getSession();

		int ret = new CardServiceImpl().checkCardNumExist(ChangeCardNum);

		ObjectMapper om = new ObjectMapper();
		String json = null;
		if (ret > 0 && hs.getAttribute("userID") != null) {
			CardNum = new CardServiceImpl().oldNumParams(CardNum);
			System.out.println(CardNum);
			String UserID = hs.getAttribute("userID").toString();
			int out = new CardServiceImpl().updateChangeCard(CardNum, ChangeCardNum, UserID);
			int ren = new CardServiceImpl().updatePatientCard(CardNum, ChangeCardNum);
			int come = new CardServiceImpl().updateOldCard(CardNum);
			if (out > 0 && ren > 0 && come > 0) {
				new BackLogServiceImpl().intBackAllUserState(UserID, "用户："+UserID+"售出了一张卡","2");
				json = om.writeValueAsString(new UserMessageBean("1", "更换成功", null));
			}
		} else {
			json = om.writeValueAsString(new UserMessageBean("0", "卡不可用或不存在", null));
			if (hs.getAttribute("userID") == null) {
				json = om.writeValueAsString(new UserMessageBean("0", "未登录", null));
			}
		}
		resp.getWriter().println(json);
	}
}
