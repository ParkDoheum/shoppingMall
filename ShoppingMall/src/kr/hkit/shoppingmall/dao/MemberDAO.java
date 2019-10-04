package kr.hkit.shoppingmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.hkit.shoppingmall.model.MemberVO;

public class MemberDAO {
	public static int join(MemberVO vo) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_member "
				+ " ( i_member, mid, mpw, nm ) "				
				+ " SELECT (nvl(max(i_member), 0) + 1), ?, ?, ? "
				+ " FROM t_member ";
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getMid());
			ps.setString(2, vo.getMpw());
			ps.setString(3, vo.getNm());
			result = ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps);
		}
		return result;
	}
	

	public static MemberVO login(String mid) {
		MemberVO result = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT * FROM t_member WHERE mid = ? ";
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);
			ps.setString(1, mid);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = new MemberVO();
				result.setI_member(rs.getInt("i_member"));
				result.setMid(rs.getString("mid"));
				result.setMpw(rs.getString("mpw"));
				result.setNm(rs.getString("nm"));
				result.setR_date(rs.getString("r_date"));
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}
		
		return result;
	}
	
	public static MemberVO getMember(MemberVO vo) {
		MemberVO result = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = " SELECT * FROM t_member WHERE ";
		if(vo.getI_member() > 0) {
			sql += " i_member = " + vo.getI_member();
		}		
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = new MemberVO();
				result.setI_member(rs.getInt("i_member"));
				result.setMid(rs.getString("mid"));
				result.setMpw(rs.getString("mpw"));
				result.setNm(rs.getString("nm"));
				result.setR_date(rs.getString("r_date"));				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}
		
		return result;
	}
	
	//비밀번호 변경
	public static int changePw(MemberVO vo) {
		int result = 0;		
		Connection con = null;
		PreparedStatement ps = null;
		String sql = " UPDATE t_member SET mpw = ? WHERE i_member = ? ";
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);
			ps.setString(1, vo.getMpw());
			ps.setInt(2, vo.getI_member());
			result = ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps);
		}
		
		return result;
	}
}
