package com.lq.resume.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lq.resume.dao.dao.ResumeDAO;
import com.lq.resume.domain.Edu;
import com.lq.resume.domain.Pexp;
import com.lq.resume.domain.ResumeManage;
import com.lq.resume.domain.Wexp;
import com.lq.resume.domain.Wjob;
import com.lq.user.domain.User;

import Util.DBUtil;

public class ResumeDAOImpl implements ResumeDAO{

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	@Override
	public Wjob addWjob(Wjob wj) {
		String sql="insert into tbl_wjob values(?,?,?,?,?)";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, wj.getUid());
			pst.setString(2, wj.getWcity());
			pst.setInt(3, wj.getWstate());
			pst.setString(4, wj.getWposition());
			pst.setString(5, wj.getWsalary());
			pst.executeUpdate();
			return wj;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(pst, conn);
		}
		return null;
	}
	@Override
	public Wexp addWexp(Wexp we) {
		String sql="insert into tbl_workexp values(?,?,?,?,?,?,?)";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, we.getUid());
			pst.setString(2, we.getCno());
			pst.setString(3, we.getPosition());
			pst.setInt(4, we.getStartYear());
			pst.setInt(5, we.getStartMonth());
			pst.setInt(6, we.getEndYear());
			pst.setInt(7, we.getEndMonth());
			pst.executeUpdate();
			return we;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(pst, conn);
		}
		return null;
	}
	@Override
	public Pexp addPexp(Pexp p) {
		String sql="insert into tbl_pexp values(?,?,?,?,?,?,?,?)";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, p.getUid());
			pst.setString(2, p.getPname());
			pst.setString(3, p.getPosition());
			pst.setInt(4, p.getStartYear());
			pst.setInt(5, p.getStartMonth());
			pst.setInt(6, p.getEndYear());
			pst.setInt(7, p.getEndMonth());
			pst.setString(8, p.getDescribe());
			pst.executeUpdate();
			return p;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(pst, conn);
		}
		return null;
	}
	@Override
	public Edu addEdu(Edu e) {
		String sql="insert into tbl_edu values(?,?,?,?,?,?)";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, e.getUid());
			pst.setString(2, e.getSname());
			pst.setString(3, e.getDegree());
			pst.setString(4, e.getPname());
			pst.setInt(5, e.getFromdate());
			pst.setInt(6, e.getTodate());
			pst.executeUpdate();
			return e;
		} catch (SQLException e1) {
			e1.printStackTrace();
		}finally {
			DBUtil.close(pst, conn);
		}
		return null;
	}
	@Override
	public User updateUser(User u) {
		String sql="update tbl_user set uname=?,usex=?,udegree=?,uworkexp=?,utel=?,uaccount=? "
				+ "where id=?";
		System.out.println(u.getId());
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, u.getUname());
			pst.setString(2, u.getUsex());
			pst.setString(3, u.getUdegree());
			pst.setString(4, u.getUworkexp());
			pst.setString(5, u.getUtel());
			pst.setString(6, u.getUaccount());
			pst.setString(7, u.getId());
			pst.executeUpdate();
			return u;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(pst, conn);
		}
		return null;
	}
	@Override
	public Wjob queryByUid(String uid) {
		String sql="select * from tbl_wjob wj left join tbl_workexp we on wj.uid=we.uid " + 
				"			left join tbl_pexp p on wj.uid=p.uid " + 
				"           left join tbl_edu e on wj.uid=e.uid " + 
				"           where wj.uid=?";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, uid);
			rs=pst.executeQuery();
			while(rs.next()) {
				//设置Wjob
				Wjob wj=new Wjob();
				wj.setUid(rs.getString(1));
				wj.setWcity(rs.getString(2));
				wj.setWstate(rs.getInt(3));
				wj.setWposition(rs.getString(4));
				wj.setWsalary(rs.getString(5));
				//设置Wexp
				Wexp we=new Wexp();
				we.setCno(rs.getString(7));
				we.setPosition(rs.getString(8));
				we.setStartYear(rs.getInt(9));
				we.setStartMonth(rs.getInt(10));
				we.setEndYear(rs.getInt(11));
				we.setEndMonth(rs.getInt(12));
				wj.setWe(we);
				//设置Pexp
				Pexp p=new Pexp();
				p.setPname(rs.getString(14));
				p.setPosition(rs.getString(15));
				p.setStartYear(rs.getInt(16));
				p.setStartMonth(rs.getInt(17));
				p.setEndYear(rs.getInt(18));
				p.setEndMonth(rs.getInt(19));
				wj.setP(p);
				//设置Edu
				Edu e=new Edu();
				e.setSname(rs.getString(22));
				e.setDegree(rs.getString(23));
				e.setPname(rs.getString(24));
				e.setFromdate(rs.getInt(25));
				e.setTodate(rs.getInt(26));
				wj.setE(e);
				return wj;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	@Override
	public ResumeManage addRmanage(ResumeManage rm) {
		String sql="insert into tbl_rmanage values(?,?,?,'1',?,sysdate(),null)";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, rm.getCid());
			pst.setString(2, rm.getUid());
			pst.setString(3, rm.getPid());
			pst.setInt(4, rm.getRform());
			pst.executeUpdate();
			return rm;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

}
