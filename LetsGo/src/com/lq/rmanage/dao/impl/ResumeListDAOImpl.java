package com.lq.rmanage.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SystemUtils;

import com.lq.rmanage.dao.dao.ResumeListDAO;
import com.lq.rmanage.domain.ReseiveId;
import com.lq.rmanage.domain.ResumeList;

import Util.DBUtil;

public class ResumeListDAOImpl implements ResumeListDAO {
	
	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	@Override
	public List<ResumeList> queryByCid(ReseiveId ri) {
		List<ResumeList> resumeList=new ArrayList<>();
		List<Object> params=new ArrayList<>();
		StringBuffer sb=new StringBuffer("select r.uid,r.cid,r.pid,r.ddate,r.rstate,r.rform,r.newdate,b.cname,b.ccity,p.pname,p.pstate,p.pfromsalary,p.pexperience,p.pdegree,u.uname,u.usex,u.uaccount,u.uworkexp,u.utel,e.degree,e.sname,we.position,we.cno,wj.wcity,wj.wposition from " + 
				"(select uid,cid,pid,ddate,rform,rstate,newdate from tbl_rmanage) as r join " + 
				"(select id,uname,usex,uaccount,uworkexp,utel from tbl_user) as u on r.uid=u.id join " + 
				"(select uid,degree,sname from tbl_edu) as e on r.uid=e.uid join " + 
				"(select uid,position,cno from tbl_workexp) as we on r.uid=we.uid join " + 
				"(select uid,wcity,wposition from tbl_wjob) as wj on r.uid=wj.uid join " + 
				"(select pid,pname,pstate,pfromsalary,pexperience,pdegree from tbl_position) as p on r.pid=p.pid join " + 
				"(select cid,cname,ccity from tbl_baseinfo) as b on b.cid=r.cid " + 
				"where 1=1 ");
		if(ri.getCid()!=null&&!"".equals(ri.getCid().trim())) {
			sb.append(" and r.cid = ? ");
			params.add(ri.getCid());
		}
		if(ri.getPid()!=null&&!"".equals(ri.getPid().trim())) {
			sb.append(" and r.pid = ? ");
			params.add(ri.getPid());
		}
		if(ri.getId()!=null&&!"".equals(ri.getId().trim())) {
			sb.append(" and r.uid = ? ");
			params.add(ri.getId());
		}
		if(ri.getRstate()!=null&&!"".equals(ri.getRstate().trim())&&!"5".equals(ri.getRstate().trim())) {
			sb.append(" and r.rstate = ? ");
			params.add(ri.getRstate());
		}else if(ri.getRstate()!=null&&!"".equals(ri.getRstate().trim())&&"5".equals(ri.getRstate().trim())&&ri.getId()!=null&&!"".equals(ri.getId().trim())) {
			sb.append(" and r.rstate in ('0','5') ");
		}else if(ri.getRstate()!=null&&!"".equals(ri.getRstate().trim())){
			sb.append(" and r.rstate = '5' ");
		}else if((ri.getRstate()==null||"".equals(ri.getRstate().trim()))&&(ri.getPid()!=null&&!"".equals(ri.getPid().trim()))) {
			sb.append(" and r.rstate in ('1','2','3','4','5') ");
		}
		try {
			conn=DBUtil.openConn();
			String sql=sb.toString();
			pst=conn.prepareStatement(sql);
			for(int x=0;x<params.size();x++) {
				pst.setObject(x+1, params.get(x));
			}
			rs=pst.executeQuery();
			while(rs.next())
			{
				String rstate="";
				String rform="";
				String usex="";
				if("1".equals(rs.getString("rstate"))){
					rstate="待处理简历";
				}else if("2".equals(rs.getString("rstate"))){
					rstate="待定简历";
				}else if("3".equals(rs.getString("rstate"))){
					rstate="已过滤简历";
				}else if("4".equals(rs.getString("rstate"))){
					rstate="已通知面试简历";
				}else if("5".equals(rs.getString("rstate"))){
					rstate="不合适简历";
				}else if("0".equals(rs.getString("rstate"))){
					rstate="不合适简历";
				}
				
				if("0".equals(rs.getString("rform"))) {
					rform="在线简历";
				}else if("1".equals(rs.getString("rform"))) {
					rform="附件简历";
				}
				
				if("0".equals(rs.getString("usex"))) {
					usex="男";
				}else if("1".equals(rs.getString("usex"))) {
					usex="女";
				}
				ResumeList r=new ResumeList();
				r.setUid(rs.getString("uid"));
				r.setCid(rs.getString("cid"));
				r.setPid(rs.getString("pid"));
				r.setRstate(rstate);
				r.setPfromsalary(rs.getString("pfromsalary"));
				r.setPname(rs.getString("pname"));
				r.setNewdate(rs.getString("newdate"));
				r.setDdate(rs.getString("ddate"));
				r.setRform(rform);
				r.setUsex(usex);
				r.setUname(rs.getString("uname"));
				r.setUdegree(rs.getString("degree"));
				r.setSname(rs.getString("sname"));
				r.setUworkexp(rs.getString("uworkexp"));
				r.setWcity(rs.getString("wcity"));
				r.setPosition(rs.getString("position"));
				r.setCno(rs.getString("cname"));
				r.setCcity(rs.getString("ccity"));
				r.setWposition(rs.getString("wposition"));
				r.setUaccount(rs.getString("uaccount"));
				r.setUtel(rs.getString("utel"));
				resumeList.add(r);
			}
			return resumeList;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, pst, conn);
		}
		return null;
	}

	@Override
	public void updateByUid(String cid, String rstate, String[] uid,String[] pid) throws SQLException {
		String sql="update tbl_rmanage set rstate=?,newdate=sysdate() where cid=? and uid=? and pid=?";
		conn=DBUtil.openConn();
		pst=conn.prepareStatement(sql);
		for(int x=0;x<uid.length;x++) {
			pst.setString(1, rstate);
			pst.setString(2, cid);
			pst.setString(3, uid[x]);
			pst.setString(4, pid[x]);
			pst.addBatch();
		}
		pst.executeBatch();
	}

	@Override
	public int queryForCount(ReseiveId ri) {
		List<Object> params=new ArrayList<>();
		StringBuffer sb=new StringBuffer("select count(*) from " + 
				"(select uid,cid,pid,ddate,rform,rstate,newdate from tbl_rmanage) as r join " + 
				"(select id,uname,usex,uaccount,uworkexp,utel from tbl_user) as u on r.uid=u.id join " + 
				"(select uid,degree,sname from tbl_edu) as e on u.id=e.uid join " + 
				"(select uid,position,cno from tbl_workexp) as we on u.id=we.uid join " + 
				"(select uid,wcity,wposition from tbl_wjob) as wj on u.id=wj.uid join " + 
				"(select pid,pname,pstate,pfromsalary,pexperience,pdegree from tbl_position) as p on r.pid=p.pid join " + 
				"(select cid,cname,ccity from tbl_baseinfo) as b on b.cid=r.cid " + 
				"where 1=1 ");
		if(ri.getCid()!=null&&!"".equals(ri.getCid().trim())) {
			sb.append(" and r.cid = ? ");
			params.add(ri.getCid());
		}else if(ri.getPid()!=null&&!"".equals(ri.getPid().trim())) {
			sb.append(" and r.pid = ? ");
			params.add(ri.getPid());
		}
		if(ri.getId()!=null&&!"".equals(ri.getId().trim())) {
			sb.append(" and r.uid = ? ");
			params.add(ri.getId());
		}
		if(ri.getRstate()!=null&&!"".equals(ri.getRstate().trim())&&!"5".equals(ri.getRstate().trim())) {
			sb.append(" and r.rstate = ? ");
			params.add(ri.getRstate());
		}else if(ri.getRstate()!=null&&!"".equals(ri.getRstate().trim())&&"5".equals(ri.getRstate().trim())&&ri.getId()!=null&&!"".equals(ri.getId().trim())) {
			sb.append(" and r.rstate in ('0','5') ");
		}else {
			sb.append(" and r.rstate = '5' ");
		}
		try {
			conn=DBUtil.openConn();
			String sql=sb.toString();
			pst=conn.prepareStatement(sql);
			for(int x=0;x<params.size();x++) {
				pst.setObject(x+1, params.get(x));
			}
			rs=pst.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, pst, conn);
		}
		return 0;
	}

	@Override
	public int queryRstate1(String cid) {
		String sql="SELECT count(*) FROM tbl_rmanage where rstate='1' and cid=?";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, cid);
			rs=pst.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, pst, conn);
		}
		return 0;
	}
	@Override
	public int queryRstate3(String cid) {
		String sql="SELECT count(*) FROM tbl_rmanage where rstate='3' and cid=?";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, cid);
			rs=pst.executeQuery();
			while(rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, pst, conn);
		}
		return 0;
	}
}
