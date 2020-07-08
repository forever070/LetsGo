package com.lq.search.dao.factory;

import com.lq.search.dao.dao.toudiDAO;
import com.lq.search.dao.impl.toudiImpl;

public class toudiDAOFactory {
	public static toudiDAO gettoudiDAO() {
		return new toudiImpl();
	}

}
