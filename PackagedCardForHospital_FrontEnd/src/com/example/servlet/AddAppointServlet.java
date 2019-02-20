package com.example.servlet;

import com.example.bean.UserMessageBean;
import com.example.service.DoctorServiceImpl;
import com.example.service.PatientServiceImpl;
import com.example.service.StreamServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;

import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddAppointServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String timeRangeSelected = req.getParameter("timeRangeSelected"); // 时间段
		String tempID = req.getParameter("tempID"); // 排班ID
		String p_ID = req.getParameter("p_ID"); // 病人卡ID
		String CardNum = req.getParameter("CardNum");
		System.out.println(timeRangeSelected + ":" + tempID + ":" + p_ID + ":" + CardNum);
		ObjectMapper om = new ObjectMapper();
		String json = null;

		boolean bea = new DoctorServiceImpl().checkAppPaLive(tempID, p_ID);
		System.out.println(bea);
		if (!bea) {
			int ret = new DoctorServiceImpl().updateAppoint(timeRangeSelected, tempID, p_ID);
			int out = new DoctorServiceImpl().appDisMoney(CardNum);
			if (ret > 0 && out > 0) {
				String CID = new PatientServiceImpl().viewCardID(CardNum);
				new StreamServiceImpl().insertFundStreamRe("预约", CID, p_ID, "-100", "-5", "1", null, null);
				json = om.writeValueAsString(new UserMessageBean("1", "预约成功", null));
			} else {
				json = om.writeValueAsString(new UserMessageBean("0", "预约失败", null));
			}
		} else {
			json = om.writeValueAsString(new UserMessageBean("0", "预约失败，患者已在此排班列表中有过预约", null));
		}
		resp.getWriter().println(json);
	}
}
