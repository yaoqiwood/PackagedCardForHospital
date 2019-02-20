package com.example.servlet;

import com.example.bean.WorkCensusInfBean;
import com.example.service.CardServiceImpl;
import com.example.service.RoleMTableServiceImpl;
import com.example.service.StreamServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class RefWorkTServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String timeDateStart = req.getParameter("timeDateStart");
		String timeDateEND = req.getParameter("timeDateEND");
		String workman = req.getParameter("workman");
		String CurrentPage = req.getParameter("CurrentPage");
		String Limit = req.getParameter("Limit");
		
		
		List<WorkCensusInfBean> workCensusInfBeans = new StreamServiceImpl().viewWorkCenInf(timeDateStart, timeDateEND,
				workman, Integer.parseInt(CurrentPage), Integer.parseInt(Limit));
		for (WorkCensusInfBean i : workCensusInfBeans) {
			i.setB_EXCUTORID(new CardServiceImpl().viewUsername(i.getB_EXCUTORID()));
		}
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(workCensusInfBeans);
		resp.getWriter().println(json);
	}
}
