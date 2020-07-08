package com.lq.search.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lq.search.dao.dao.SearchDAO;
import com.lq.search.domain.Company;
import com.lq.search.domain.CompanyQueryCondition;
import com.lq.search.domain.Position;
import com.lq.search.domain.PositionQueryCondition;

import Util.DBUtil;

public class SearchDAOImpl implements SearchDAO{
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public List<Position> queryByCondition(PositionQueryCondition condition) throws SQLException {
		List<Position> plist=new ArrayList<Position>();
		List<Object> params=new ArrayList<>();
		StringBuffer sb=new StringBuffer("select * from tbl_position p left join tbl_baseinfo c on p.cid=c.cid"
				+ " where 1=1 and p.state=1 "); 
			if(condition.getKd()!=null&&!"".equals(condition.getKd().trim())) {		
			sb.append(" and p.pname like ? ");
			params.add("%"+condition.getKd()+"%");
			}
			if(condition.getYx()!=null&&!"".equals(condition.getYx().trim())) {
					if("2k以下".equals(condition.getYx())) {
						sb.append(" and p.ptosalary<2 ");
						//params.add(condition.getYx());
					}else if("2k-5k".equals(condition.getYx())) {
						sb.append(" and p.pfromsalary>=2 and p.ptosalary<=5 ");
						//params.add(condition.getYx());
					}else if("5k-10k".equals(condition.getYx())) {
						sb.append(" and p.pfromsalary>=5 and p.ptosalary<=10 ");
						//params.add(condition.getYx());
					}else if("10k-15k".equals(condition.getYx())) {
						sb.append(" and p.pfromsalary>=10 and p.ptosalary<=15 ");
						//params.add(condition.getYx());
					}else if("15k-25k".equals(condition.getYx())) {
						sb.append(" and p.pfromsalary>=15 and p.ptosalary<=25 ");
						//params.add(condition.getYx());
					}else if("25k-50k".equals(condition.getYx())) {
						sb.append(" and p.pfromsalary>=25 and p.ptosalary<=50 ");
						//params.add(condition.getYx());
					}else if("50k以上".equals(condition.getYx())) {
						sb.append(" and p.pfromsalary>=50 ");
						//params.add(condition.getYx());
					}
				}else if(condition.getGj()!=null&&!"".equals(condition.getGj().trim()))
				{
					sb.append(" and p.pexperience = ? ");
					params.add(condition.getGj());
				}else if(condition.getXl()!=null&&!"".equals(condition.getXl().trim()))
				{
					sb.append(" and p.pdegree = ? ");
					params.add(condition.getXl());
				}else if(condition.getGx()!=null&&!"".equals(condition.getGx().trim()))
				{
				if("全职".equals(condition.getGx()))
				{
					sb.append(" and p.pstate = 0 ");
					//params.add(condition.getGx());
				}else if("兼职".equals(condition.getGx())) {
					sb.append(" and p.pstate = 1 ");
					//params.add(condition.getGx());					
				}else {
					sb.append(" and p.pstate = 2 ");
					//params.add(condition.getGx());
				}
				}else if(condition.getLc()==1&&!"".equals(condition.getCity().trim())) {
					if(!"全国".equals(condition.getCity())) {
					sb.append(" and p.pcity = ? ");
					params.add(condition.getCity());
					}
				}
			if(condition.getLabelWords()!=null&&condition.getPtype()!=null&&!"".equals(condition.getPtype().trim()))
				{
					sb.append(" and p.ptype = ? ");
					params.add(condition.getPtype());
				}
			
		String sql=sb.toString();
		conn=DBUtil.openConn();
		pst=conn.prepareStatement(sql);
		for(int x=0;x<params.size();x++)
		{
			pst.setObject(x+1, params.get(x));
			
		}		
		rs=pst.executeQuery();
		System.out.println(sql);
		while(rs.next())
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
			p.setPname(rs.getString("pname"));
			p.setPcity(rs.getString("pcity"));
			p.setPfromsalary(rs.getInt("pfromsalary"));
			p.setPtosalary(rs.getInt("ptosalary"));
			p.setPdegree(rs.getString("pdegree"));
			p.setPgood(rs.getString("pgood"));
			p.setPexperience(rs.getString("pexperience"));
			p.setCompany(c);
			plist.add(p);
		}
		
		return plist;
	}
	@Override
	public List<Company> queryByComCondition(CompanyQueryCondition condition) throws SQLException {
		List<Company> clist=new ArrayList<Company>();
		List<Object> params=new ArrayList<>();
		StringBuffer sb=new StringBuffer("select * from tbl_baseinfo c left join tbl_position p on c.cid=p.cid "
				+ " where 1=1 and p.state=1 ");
		if(condition.getKd()!=null&&!"".equals(condition.getKd().trim())) {		
			sb.append(" and c.cname like ? ");
			params.add("%"+condition.getKd()+"%");
			}
		if(condition.getLc()==1&&!"".equals(condition.getCity().trim())) {
			sb.append(" and c.ccity = ? ");
			params.add(condition.getCity());
		}
		String sql=sb.toString();
		conn=DBUtil.openConn();
		pst=conn.prepareStatement(sql);
		for(int x=0;x<params.size();x++)
		{
			pst.setObject(x+1, params.get(x));
			
		}
		System.out.println(sql);
		rs=pst.executeQuery();	
		while(rs.next())
		{
			Position p=new Position();			
			p.setPid(rs.getString("pid"));
			p.setPname(rs.getString("pname"));
			p.setPcity(rs.getString("pcity"));
			p.setPfromsalary(rs.getInt("pfromsalary"));
			p.setPtosalary(rs.getInt("ptosalary"));
			p.setPdegree(rs.getString("pdegree"));
			p.setPgood(rs.getString("pgood"));
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
			c.setPosition(p);
			clist.add(c);
		}
		return clist;
	}

}
