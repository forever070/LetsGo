package com.lq.search.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lq.search.dao.dao.toudiDAO;
import com.lq.search.domain.Company;
import com.lq.search.domain.Position;

import Util.DBUtil;

public class toudiImpl implements toudiDAO{
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public Position queryBy(String pid,String cid) {
			String sql="select * from tbl_position p left join tbl_baseinfo c on c.cid=p.cid where p.pid=? and p.cid=? ";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, pid);
			pst.setString(2, cid);
			rs=pst.executeQuery();
			if(rs.next())
			{
				Company c=new Company();
				c.setCid(rs.getString("cid"));
				c.setCdescribe(rs.getString("cdescribe"));
				c.setCname(rs.getString("cname"));
				c.setCfield(rs.getString("cfield"));
				c.setClarge(rs.getString("clarge"));
				c.setCdevelop(rs.getString("cdevelop"));
				c.setCsite(rs.getString("csite"));
				c.setCinvest(rs.getString("cinvest"));
				c.setCcity(rs.getString("ccity"));
				Position p=new Position();
				p.setPid(rs.getString("pid"));
				p.setCid(rs.getString("cid"));
				p.setPname(rs.getString("pname"));
				p.setPcity(rs.getString("pcity"));
				p.setPfromsalary(rs.getInt("pfromsalary"));
				p.setPtosalary(rs.getInt("ptosalary"));
				p.setPdegree(rs.getString("pdegree"));
				p.setPgood(rs.getString("pgood"));		
				p.setCompany(c);
				return p;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
