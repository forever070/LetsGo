package com.lq.user.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lq.user.dao.dao.UserDAO;
import com.lq.user.domain.User;

import Util.DBUtil;
import Util.MD5Util;

public class UserDAOImpl implements UserDAO {

	private Connection conn;
	private PreparedStatement pst;
	private ResultSet rs;

	@Override
	public boolean register(User u) {
		// TODO Auto-generated method stub
		String sql="insert into tbl_user values (?,?,?,null,null,null,null,null,?)";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, u.getId());
			pst.setString(2, u.getUaccount());
			pst.setString(3, u.getUpassword());
			pst.setInt(4, u.getAuthority());
			pst.executeUpdate();
			return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean login(String uaccount, String upassword) {
		// TODO Auto-generated method stub
		String sql="select * from tbl_user where uaccount = ? and upassword = ?";//�����˺�mima��
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, uaccount);
			pst.setString(2, upassword);
			rs=pst.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return false;
	}
	
	@Override
	public User logincheck(String uaccount,String upassword) {
		// TODO Auto-generated method stub
		String sql="select * from tbl_user where uaccount = ? and upassword = ?";//�����˺�mima��
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, uaccount);
			pst.setString(2, upassword);
			rs=pst.executeQuery();
			if(rs.next()) {
				User u=new User();
				u.setId(rs.getString("id"));
				u.setUaccount(rs.getString("uaccount"));
				u.setUpassword(rs.getString("upassword"));
				
				u.setUname(rs.getString("uname"));
				u.setUsex(rs.getString("usex"));
				u.setUdegree(rs.getString("udegree"));
				u.setUworkexp(rs.getString("uworkexp"));
				u.setUtel(rs.getString("utel"));
				
				u.setAuthority(rs.getInt("authority"));
				return u;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public User queryById(String id) {
		// TODO Auto-generated method stub
		User u=new User();
		String sql="select * from tbl_user where id = ?";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, id);
			rs=pst.executeQuery();
			while(rs.next()) {
				u.setId(rs.getString("id"));
				u.setUaccount(rs.getString("uaccount"));
				u.setUpassword(rs.getString("upassword"));
				u.setUname(rs.getString("uname"));
			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public User queryByAccount(String uaccount) {
		// TODO Auto-generated method stub
		User u=new User();
		String sql="select * from tbl_user where uaccount = ?";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, uaccount);
			rs=pst.executeQuery();
			while(rs.next()) {
				u.setId(rs.getString("id"));
				u.setUaccount(rs.getString("uaccount"));
				u.setUpassword(rs.getString("upassword"));
				//u.setUname(rs.getString("uname"));
			}
			return u;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean update(String id,String password) {
		// TODO Auto-generated method stub
		String sql="update tbl_user set upassword = ? where id = ?";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, id);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateByEmail(String email,String password) {
		// TODO Auto-generated method stub
		String sql="update tbl_user set upassword = ? where uaccount = ?";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, password);
			pst.setString(2, email);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean checkByAccount(String uaccount) {
		
		String sql="select * from tbl_user where uaccount = ?";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, uaccount);
			rs=pst.executeQuery();
			while(rs.next()) {
				User u=new User();
				u.setId(rs.getString("id"));
				u.setUaccount(rs.getString("uaccount"));
				u.setUpassword(rs.getString("upassword"));
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String getCid(String uid) {
		String sql="select cid from tbl_baseinfo where uid=?";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, uid);
			rs=pst.executeQuery();
			while(rs.next())
			{
				return rs.getString("cid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, pst, conn);
		}
		return null;
	}

	@Override
	public String getCname(String uid) {
		String sql="select cname from tbl_baseinfo where uid=?";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, uid);
			rs=pst.executeQuery();
			while(rs.next())
			{
				return rs.getString("cname");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs, pst, conn);
		}
		return null;
	}

	

}
