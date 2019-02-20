package com.example.servlet;

import com.example.bean.AppCardIDCountBean;
import com.example.bean.UserMessageBean;
import com.example.service.BackLogServiceImpl;
import com.example.service.CardServiceImpl;
import com.example.util.DBUtil;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class AppRequestDataServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String app_appNum = req.getParameter("app_appNum");
		String app_IDNUM = req.getParameter("app_IDNUM");
		String app_requester = req.getParameter("app_requester");
//		System.out.println("app_requester"+app_requester);

		HttpSession hs = req.getSession();
		ObjectMapper om = new ObjectMapper();
		Connection conn = DBUtil.createConn();

		try {
			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		CardServiceImpl cardService = new CardServiceImpl();
		String json = null;
		int count = cardService.viewWaitCardSize();
		if (hs.getAttribute("userID") != null) {
			if (Integer.parseInt(app_appNum) <= count) {
				List<AppCardIDCountBean> appCardIDCountBeans = cardService.viewWaitAppCard(app_appNum);
				int j = 0;
				for (AppCardIDCountBean i : appCardIDCountBeans) {
					System.out.println(i.getID());
					int ret = new CardServiceImpl().appRequestCard(conn, i.getID(), app_IDNUM,app_requester);
					if (ret > 0) {
						j++;
					} else {
						break;
					}
				}
				if (j == Integer.parseInt(app_appNum)) {
					String UserID = hs.getAttribute("userID").toString();
					try {
						conn.commit();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					new CardServiceImpl().updateAppApproval(app_IDNUM,UserID);
					DBUtil.closeConn(conn, null, null);
					json = om.writeValueAsString(new UserMessageBean("1", "审批成功通过了" + app_appNum + "张卡", null));
					new BackLogServiceImpl().BackAllUser(UserID, UserID+"审批成功通过了" + app_appNum + "张卡");
				}
			} else {
				json = om.writeValueAsString(new UserMessageBean("0", "库存不足，请稍后再试", null));
			}
		} else {
			json = om.writeValueAsString(new UserMessageBean("0", "当前尚未登录", null));
		}
		resp.getWriter().println(json);
	}
}
