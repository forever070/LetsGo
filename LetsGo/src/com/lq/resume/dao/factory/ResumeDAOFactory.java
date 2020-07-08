package com.lq.resume.dao.factory;

import com.lq.resume.dao.dao.ResumeDAO;
import com.lq.resume.dao.impl.ResumeDAOImpl;

public class ResumeDAOFactory {
	public static ResumeDAO getResumeDAO() {
		return new ResumeDAOImpl();
	}
}
