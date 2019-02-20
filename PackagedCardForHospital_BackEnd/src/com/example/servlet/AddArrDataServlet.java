package com.example.servlet;

import com.example.bean.UserMessageBean;
import com.example.service.DoctorServiceImpl;
import com.sun.org.apache.bcel.internal.generic.NEW;
import com.sun.org.apache.xpath.internal.functions.Function;

import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddArrDataServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String doctorName = req.getParameter("doctorName");
		String arrange_date = req.getParameter("arrange_date");

		HttpSession hs = req.getSession();
		ObjectMapper om = new ObjectMapper();
		String json = null;
		if (hs.getAttribute("userID") == null) {
			json = om.writeValueAsString(new UserMessageBean("0", "您尚未登陆,抱歉，无法操作", null));
		} else {
			if (checkDateYesterday(arrange_date)) {
				String mid = hs.getAttribute("userID").toString();
				int ret = new DoctorServiceImpl().addDoctorArr(mid, doctorName, arrange_date);
				if (ret > 0) {
					json = om.writeValueAsString(new UserMessageBean("1", "排班成功", null));
				} else {
					json = om.writeValueAsString(new UserMessageBean("0", "排班失败", null));
				}
			} else {
				json = om.writeValueAsString(new UserMessageBean("0", "时间不可为今天以前", null));
			}
		}
		resp.getWriter().println(json);
	}

	public boolean checkDateYesterday(String arrange_date) {
		System.out.println("arrange:" + arrange_date);
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		System.out.println(df.format(new Date()));
		try {
			Date date = df.parse(arrange_date);
			if (date.after(today) || df.format(new Date()).equals(arrange_date)) {
				System.out.println(true);
				return true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
