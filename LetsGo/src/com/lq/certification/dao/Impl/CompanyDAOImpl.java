package com.lq.certification.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lq.certification.dao.dao.CompanyDAO;
import com.lq.certification.domain.Company;

import Util.DBUtil;

public class CompanyDAOImpl implements CompanyDAO {
	PreparedStatement pst;
	Connection conn;
	ResultSet rs;
	@Override
	public boolean add(Company c) {
		String sql="insert into tbl_baseinfo values(?,?,?,?,?,?,?,?,?,?)";
		try {
			conn=DBUtil.openConn();
			pst=conn.prepareStatement(sql);
			pst.setString(1, c.getCid());
			pst.setString(2, c.getUid());
			pst.setString(3, c.getCname());
			pst.setString(4, c.getCsite());
			pst.setString(5, c.getCcity());
			pst.setString(6, c.getCfield());
			pst.setString(7, c.getClarge());
			pst.setString(8, c.getCdevelop());
			pst.setString(9, c.getCinvest());
			pst.setString(10, c.getCdescribe());
			
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(pst, conn);
		}
		return false;
	}

}
