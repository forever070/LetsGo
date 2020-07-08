package com.lq.rmanage.dao.dao;

import java.sql.SQLException;
import java.util.List;

import com.lq.rmanage.domain.ReseiveId;
import com.lq.rmanage.domain.ResumeList;

public interface ResumeListDAO {
	public List<ResumeList> queryByCid(ReseiveId ri);
	public void updateByUid(String cid,String rstate,String[] uid,String []pid) throws SQLException;
	public int queryRstate1(String cid);
	public int queryRstate3(String cid);
	public int queryForCount(ReseiveId ri);
}
