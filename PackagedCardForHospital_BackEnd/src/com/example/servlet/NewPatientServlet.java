package com.example.servlet;

import com.example.bean.UserMessageBean;
import com.example.service.BackLogServiceImpl;
import com.example.service.CardServiceImpl;
import com.example.service.CollectorServiceImpl;
import com.example.service.StreamServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NewPatientServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sold_name = req.getParameter("sold_name");
		String sold_age = req.getParameter("sold_age");
		String sex = req.getParameter("sex");
		String U_native = req.getParameter("native");
		String idNum = req.getParameter("idNum");
		String phone = req.getParameter("phone");
		String address = req.getParameter("address");
		String preStore = req.getParameter("preStore");
		String cardNum = req.getParameter("cardNum");
		HttpSession hs = req.getSession();
		System.out.println("NewPatientServlet");

		ObjectMapper om = new ObjectMapper();
		int ret = new CardServiceImpl().checkCardNumExist(cardNum);
		String json = null;
		if (ret > 0 && hs.getAttribute("userID") != null) {
			int out = new CollectorServiceImpl().addPatient(sold_name, sold_age, sex, U_native, idNum, phone, address,
					preStore, cardNum);
			int come = new CardServiceImpl().updateAmountWithCard(String.valueOf(Integer.parseInt(preStore) - 5),
					cardNum, hs.getAttribute("userID").toString());
			if (out > 0 && come > 0) {
				String PID = new CardServiceImpl().viewPatientID(cardNum);
				String CID = new CardServiceImpl().viewCardID(cardNum);
				int RetEN = new StreamServiceImpl().insertFundStreamRe("售卡", CID, PID,
						hs.getAttribute("userID").toString(), preStore, "1", "SYSDATE", "NULL");
					
				if (hs.getAttribute("userID") != null) {
					String userID = hs.getAttribute("userID").toString();
					System.out.println(123123);
					new BackLogServiceImpl().intBackAllUserState(userID, "用户：" + userID + "售出一张卡","1");
				}
				json = om.writeValueAsString(new UserMessageBean("1", "售出成功", null));

			}
		} else {
			json = om.writeValueAsString(new UserMessageBean("0", "当前系统不存在此卡号，请检查后再输入", null));
			if (hs.getAttribute("userID") == null) {
				json = om.writeValueAsString(new UserMessageBean("0", "当前尚未登录,将为您进行跳转", null));
			}
		}
		resp.getWriter().println(json);
	}
}
