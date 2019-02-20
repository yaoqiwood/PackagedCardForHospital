package com.example.servlet;

import com.example.bean.PatientInfBean;
import com.example.dao.CardDaoImpl;
import com.example.service.CardServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ReadCardExitCCARDServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String cardIDNUM = req.getParameter("cardIDNUM");
		ObjectMapper om = new ObjectMapper();
		List<PatientInfBean> patientInfBeans = new CardServiceImpl().viewExitPatientInf(cardIDNUM);
		String json = om.writeValueAsString(patientInfBeans);
		resp.getWriter().println(json);
	}
}
