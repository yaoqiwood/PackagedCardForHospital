package com.example.servlet;

import com.example.bean.UserMessageBean;
import com.example.service.BackLogServiceImpl;
import com.example.service.CardServiceImpl;
import com.example.service.StreamServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ExitCardServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String CardNum = req.getParameter("CardNum");
		ObjectMapper om = new ObjectMapper();
		HttpSession hs = req.getSession();
		String PID = new CardServiceImpl().viewPatientID(CardNum);
		String CID = new CardServiceImpl().viewCardID(CardNum);
		String amount = new CardServiceImpl().viewAmount(CardNum);

		int ret = new CardServiceImpl().exitCard(CardNum);
		int out = new CardServiceImpl().clearPatientCardID(CardNum);
		String json = null;
		if (hs.getAttribute("userID") == null) {
			json = om.writeValueAsString(new UserMessageBean("0", "当前尚未登录,将为您进行跳转", null));
		} else if (ret > 0 && out > 0) {
			String userID = hs.getAttribute("userID").toString();
			new StreamServiceImpl().insertFundStreamRe("退卡", CID, PID, userID, ("-" + amount), "1", null, null);
			new BackLogServiceImpl().intBackAllUserState(userID, "用户:" + userID + "退了一张卡", "3");
			json = om.writeValueAsString(new UserMessageBean("1", "退卡成功", null));
		} else {
			json = om.writeValueAsString(new UserMessageBean("0", "退卡失败", null));
		}
		resp.getWriter().println(json);
	}
}
