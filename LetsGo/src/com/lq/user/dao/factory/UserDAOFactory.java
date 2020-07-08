package com.lq.user.dao.factory;

import com.lq.user.dao.dao.UserDAO;
import com.lq.user.dao.impl.UserDAOImpl;

public class UserDAOFactory {
	public static UserDAO getUserDAO()
	{
		return new UserDAOImpl();
	}

}
