package com.lq.position.dao.factory;

import com.lq.position.dao.Impl.PositionDAOImpl;
import com.lq.position.dao.dao.PositionDAO;

public class PositionDAOFactory {
		public static PositionDAO getPositionDAO() {
			return new PositionDAOImpl();
		}
		
}
