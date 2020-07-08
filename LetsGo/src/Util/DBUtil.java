package Util;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

import java.sql.PreparedStatement;

public class DBUtil {
	//
		private static ThreadLocal<Connection> local=new ThreadLocal<>();
		static {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		public static Connection openConn() throws SQLException {
			Connection conn=local.get();//
			if(conn==null) {
				conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=utf8", "root", "123456");
				local.set(conn);//ֵ
			}
			return conn;//
		}
		public static void close(Connection conn) {
			close(null,null,conn);
		}
		public static void close(PreparedStatement pst,Connection conn) {
			close(null,pst,conn);
		}
		
		public static void close(ResultSet rs,PreparedStatement pst,Connection conn) {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pst!=null) {
				try {
					pst.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null) {
				try {
					conn.close();
					local.remove();//
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

}
