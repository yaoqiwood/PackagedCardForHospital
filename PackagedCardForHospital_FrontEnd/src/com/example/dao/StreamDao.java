package com.example.dao;

import java.util.List;

public interface StreamDao {
	public int insertFundStreamRe(String sql, List<String> params);
	/**
	 * @param sql
	 * @return
	 */
	public int addBackLog(String sql, List<String> params);
}
