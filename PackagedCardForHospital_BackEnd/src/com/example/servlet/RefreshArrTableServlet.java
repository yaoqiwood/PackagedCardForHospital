package com.example.servlet;

import com.example.bean.ArrInfBean;
import com.example.service.DoctorServiceImpl;
import org.codehaus.jackson.map.ObjectMapper;
import org.omg.CORBA.OMGVMCID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RefreshArrTableServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sName = req.getParameter("sName");
		String CurrentPage = req.getParameter("CurrentPage");
		String Limit = req.getParameter("Limit");

		List<ArrInfBean> arrInfBeans = new DoctorServiceImpl().viewArrInf(sName,Integer.parseInt(CurrentPage),
				Integer.parseInt(Limit));
		ObjectMapper om = new ObjectMapper();
		String json = om.writeValueAsString(arrInfBeans);
		resp.getWriter().println(json);
	}
}
