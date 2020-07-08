package com.lq.search.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.lq.search.dao.dao.SearchDAO;
import com.lq.search.dao.factory.SearchDAOFactory;
import com.lq.search.domain.Company;
import com.lq.search.domain.CompanyQueryCondition;
import com.lq.search.domain.Position;
import com.lq.search.domain.PositionQueryCondition;

public class PositionConditionService {
	public List<Position> queryByCondition(PositionQueryCondition condition){
		SearchDAO sdao=SearchDAOFactory.getSearchDAO();
		try {
			List<Position> plist=sdao.queryByCondition(condition);			
			return plist;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	public List<Company> queryByComCondition(CompanyQueryCondition condition){
		SearchDAO sdao=SearchDAOFactory.getSearchDAO();
		try {
			List<Company> clist=sdao.queryByComCondition(condition);			
			return clist;
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
	}
}
