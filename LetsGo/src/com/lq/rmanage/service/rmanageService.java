package com.lq.rmanage.service;

import java.sql.Connection;
import java.sql.SQLException;

import com.lq.rmanage.dao.dao.ResumeListDAO;
import com.lq.rmanage.dao.factory.ResumeListDAOFactory;

import Util.DBUtil;

public class rmanageService {
	
	private Connection conn;
	
	public boolean updateRstate(String cid, String rstate, String[] uid,String[] pid) {
		ResumeListDAO rdao=ResumeListDAOFactory.getResumeListDAO();
		try {
			conn=DBUtil.openConn();
			conn.setAutoCommit(false);
			rdao.updateByUid(cid, rstate, uid,pid);
			conn.commit();
			return true;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		return false;
	}
}
