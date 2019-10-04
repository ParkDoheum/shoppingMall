package kr.hkit.shoppingmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConn {
	public static Connection getConn() throws Exception {
		Class.forName("oracle.jdbc.OracleDriver");
		Connection con = DriverManager.getConnection
		                  ("jdbc:oracle:thin:@//localhost:1521/xe", "shopping", "hkit2019");
		return con;
	}
	
	public static void close(Connection con, PreparedStatement ps) {
		if(ps != null) {
			try { ps.close(); } catch(Exception e) { e.printStackTrace(); }
		}		
		if(con != null) {
			try { con.close(); } catch(Exception e) { e.printStackTrace(); }
		}
	}
	
	public static void close(Connection con, PreparedStatement ps, ResultSet rs) {
		close(con, ps);		
		if(rs != null) {
			try { rs.close(); } catch(Exception e) { e.printStackTrace(); }
		}		
	}
}
