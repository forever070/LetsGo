package com.lq.certification.dao.factory;

import com.lq.certification.dao.Impl.CompanyDAOImpl;
import com.lq.certification.dao.dao.CompanyDAO;

public class CompanyDAOFactory {
	public static CompanyDAO getCompanyDAO() {
		return new CompanyDAOImpl();
	}
}
