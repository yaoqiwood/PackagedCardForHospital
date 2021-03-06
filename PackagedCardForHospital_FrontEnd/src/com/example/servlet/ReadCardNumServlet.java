package com.example.servlet;

import com.example.service.PatientServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ReadCardNumServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ReadCardNumServlet");
		String cardIDNUM = req.getParameter("cardIDNUM");

		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(new PatientServiceImpl().viewPatientInf(cardIDNUM));
		resp.getWriter().println(json);
	}
}
