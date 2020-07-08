package com.lq.search.dao.dao;

import java.sql.SQLException;
import java.util.List;

import com.lq.search.domain.Company;
import com.lq.search.domain.CompanyQueryCondition;
import com.lq.search.domain.Position;
import com.lq.search.domain.PositionQueryCondition;

public interface SearchDAO {
	public List<Position> queryByCondition(PositionQueryCondition condition) throws SQLException;
	public List<Company> queryByComCondition(CompanyQueryCondition condition) throws SQLException;
}
