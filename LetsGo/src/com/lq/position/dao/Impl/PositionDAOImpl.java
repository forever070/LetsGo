package com.lq.position.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lq.position.domain.Position;
import com.lq.position.dao.dao.PositionDAO;

import Util.DBUtil;

public class PositionDAOImpl implements PositionDAO{
	PreparedStatement pst;
	Connection conn;
	ResultSet rs;
	
	@Override
	public List<Position> list() {
		List<Position> plist=new ArrayList<>();
		String sql="select * from tbl_position";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				Position p=new Position();
				 p.setPid(rs.getString("pid"));
				 p.setCid(rs.getString("cid"));
				p.setPtype(rs.getString("ptype"));
				p.setPname(rs.getString("pname"));
				p.setPdept(rs.getString("pdept"));
				p.setPstate(rs.getInt("pstate"));
				p.setPfromsalary(rs.getInt("pfromsalary"));
				p.setPtosalary(rs.getInt("ptosalary"));
				p.setPcity(rs.getString("pcity"));
				p.setPexperience(rs.getString("pexperience"));
				p.setPdegree(rs.getString("pdegree"));
				p.setPgood(rs.getString("pgood"));
				p.setPdescribe(rs.getString("pdescribe"));
				p.setPaddr(rs.getString("paddr"));
				p.setState(rs.getInt("state"));
				if (rs.getInt("state")==1) {
					plist.add(p);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,pst,conn);
		}
		return plist;
	}
	@Override
	public boolean off(String pid) {
		// TODO Auto-generated method stub
		String sql="update tbl_position set state = 0 where pid= ?";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, pid);
			
			pst.executeUpdate();
				return true;
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,pst,conn);
		}
		
		return false;
	}
	@Override
	public boolean on(String pid) {
		// TODO Auto-generated method stub
		String sql="update tbl_position set state = 1 where pid= ?";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, pid);
			
			pst.executeUpdate();
				return true;
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,pst,conn);
		}
		
		return false;
	}
	@Override
	public List<Position> listoff() {
		List<Position> plist=new ArrayList<>();
		String sql="select * from tbl_position";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			rs=pst.executeQuery();
			while(rs.next()) {
				Position p=new Position();
				 p.setPid(rs.getString("pid"));
				 p.setCid(rs.getString("cid"));
				p.setPtype(rs.getString("ptype"));
				p.setPname(rs.getString("pname"));
				p.setPdept(rs.getString("pdept"));
				p.setPstate(rs.getInt("pstate"));
				p.setPfromsalary(rs.getInt("pfromsalary"));
				p.setPtosalary(rs.getInt("ptosalary"));
				p.setPcity(rs.getString("pcity"));
				p.setPexperience(rs.getString("pexperience"));
				p.setPdegree(rs.getString("pdegree"));
				p.setPgood(rs.getString("pgood"));
				p.setPdescribe(rs.getString("pdescribe"));
				p.setPaddr(rs.getString("paddr"));
				p.setState(rs.getInt("state"));
				if (rs.getInt("state")==0) {
					plist.add(p);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,pst,conn);
		}
		return plist;
	}
	@Override
	public boolean add(Position p) {
		String sql="insert into tbl_position values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, p.getPid());
			pst.setString(2, p.getCid());
			pst.setString(3, p.getPtype());
			pst.setString(4, p.getPname());
			pst.setString(5, p.getPdept());
			pst.setInt(6, p.getPstate());
			pst.setInt(7, p.getPfromsalary());
			pst.setInt(8, p.getPtosalary());
			pst.setString(9, p.getPcity());
			pst.setString(10, p.getPexperience());
			pst.setString(11, p.getPdegree());
			pst.setString(12, p.getPgood());
			pst.setString(13, p.getPdescribe());
			pst.setString(14, p.getPaddr());
			//pst.setInt(15, p.getState());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(pst, conn);
		}
		return false;
	}
	@Override
	public boolean del(String id) {
		String sql="delete from tbl_position where pid=?";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, id);
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(pst, conn);
		}
		
		return false;
	}
	@Override
	public Position listByPid(String pid,String cid) {
		Position p=new Position();
		String sql="select * from tbl_position where pid=? and cid=?";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1,pid);
			pst.setString(2, cid);
			rs=pst.executeQuery();
			while(rs.next()) {
				 p.setPid(rs.getString("pid"));
				 p.setCid(rs.getString("cid"));
				p.setPtype(rs.getString("ptype"));
				p.setPname(rs.getString("pname"));
				p.setPdept(rs.getString("pdept"));
				p.setPstate(rs.getInt("pstate"));
				p.setPfromsalary(rs.getInt("pfromsalary"));
				p.setPtosalary(rs.getInt("ptosalary"));
				p.setPcity(rs.getString("pcity"));
				p.setPexperience(rs.getString("pexperience"));
				p.setPdegree(rs.getString("pdegree"));
				p.setPgood(rs.getString("pgood"));
				p.setPdescribe(rs.getString("pdescribe"));
				p.setPaddr(rs.getString("paddr"));
				p.setState(rs.getInt("state"));
				if (rs.getInt("state")==1) {
					return p;
				}else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(rs,pst,conn);
		}
		return null;
	}

	
}
