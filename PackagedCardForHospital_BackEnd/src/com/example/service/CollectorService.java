package com.example.service;

import com.example.bean.NativeInfBean;
import com.example.bean.PatientInfBean;

import java.util.List;

public interface CollectorService {
	public List<NativeInfBean> viewNativeInf();

	public int addPatient(String sold_name, String sold_age, String sex, String U_native, String idNum, String phone, String address, String preStore, String cardNum);

	public List<PatientInfBean> viewPatientInf(String NumID);
	

}
