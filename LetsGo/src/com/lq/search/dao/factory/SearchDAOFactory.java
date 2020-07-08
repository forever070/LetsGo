package com.lq.search.dao.factory;

import com.lq.search.dao.dao.SearchDAO;
import com.lq.search.dao.impl.SearchDAOImpl;

public class SearchDAOFactory {
	public static SearchDAO getSearchDAO()
	{
		return new SearchDAOImpl();
	}
}
