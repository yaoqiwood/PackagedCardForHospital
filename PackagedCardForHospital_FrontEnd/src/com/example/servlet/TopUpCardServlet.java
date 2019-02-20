package com.example.servlet;

import com.example.bean.UserMessageBean;
import com.example.service.PatientServiceImpl;
import com.example.service.StreamServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TopUpCardServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String CardNum = req.getParameter("CardNum");
		String TopUpMoney = req.getParameter("TopUpMoney");

		ObjectMapper om = new ObjectMapper();
		HttpSession hs = req.getSession();
		String json = null;
		int ret = new PatientServiceImpl().topUpCardAmount(CardNum, TopUpMoney);
		if (ret > 0) {
			String PID = new PatientServiceImpl().viewPatientID(CardNum);
			String CID = new PatientServiceImpl().viewCardID(CardNum);
			new StreamServiceImpl().insertFundStreamRe("充值",CID,PID,"-100",TopUpMoney,"1",null,null);
			new StreamServiceImpl().BackAllUser("-100", CID+"充值了"+TopUpMoney+"元");
			json = om.writeValueAsString(new UserMessageBean("1", "充值成功", null));
		} else {
			json = om.writeValueAsString(new UserMessageBean("0","充值失败",null));
		}
		resp.getWriter().println(json);
	}
}
