package com.lq.rmanage.dao.factory;

import com.lq.rmanage.dao.dao.ResumeListDAO;
import com.lq.rmanage.dao.impl.ResumeListDAOImpl;

public class ResumeListDAOFactory {
	public static ResumeListDAO getResumeListDAO() {
		return new ResumeListDAOImpl();
	}
}
