package kr.hkit.shoppingmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.hkit.shoppingmall.model.AdminVO;
import kr.hkit.shoppingmall.model.MemberVO;

public class AdminDAO {
	
	public static AdminVO login(String mid) {
		AdminVO result = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT * FROM t_admin WHERE mid = ? ";
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = new AdminVO();
				result.setI_admin(rs.getInt("i_admin"));
				result.setMid(rs.getString("mid"));
				result.setMpw(rs.getString("mpw"));
				result.setNm(rs.getString("nm"));
			}
		} catch(Exception e) {
			
		} finally {
			DBConn.close(con, ps, rs);
		}
		
		return result;
	}
}
