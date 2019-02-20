package com.example.service;

import com.example.bean.CardAccCheckInfBean;
import com.example.bean.PatientInfBean;

import java.util.List;

public interface PatientService {
	public List<PatientInfBean> viewPatientInf(String CardNUm);

	public int topUpCardAmount(String CardNum, String MoneyNum);

	public String viewPatientID(String CardNum);

	public String viewCardID(String CardNum);

	public List<CardAccCheckInfBean> viewAccCheckTable(String ID, int CurrentPage, int Limit);
	
	/**
	 * 查数量
	 * @param ID
	 * @return
	 */
	public int countAccCheckTable(String ID);
}
