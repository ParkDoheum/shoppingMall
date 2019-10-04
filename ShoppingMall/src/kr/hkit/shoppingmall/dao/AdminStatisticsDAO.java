package kr.hkit.shoppingmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.hkit.shoppingmall.model.StatisticsVO;

public class AdminStatisticsDAO {
	//월별 통계
	public static List<StatisticsVO> getStatisticsMon(StatisticsVO param) {
		List<StatisticsVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.r_dt, A.qty, A.totalPrice, B.nm, B.pic, B.price "
				+ " FROM ( "
				+ " SELECT TO_CHAR(r_dt, 'yyyy-mm') as r_dt, i_product, sum(qty) as qty, sum(price) as totalPrice "
				+ " FROM T_PURCHASE ";
				
		if(param.getI_product() > 0) {
			sql += " WHERE i_product = " + param.getI_product();
		}
		
				sql += " GROUP BY TO_CHAR(r_dt, 'yyyy-mm'), i_product "
				+ " HAVING TO_CHAR(r_dt, 'yyyy-mm') = ? "
				+ " ) A INNER JOIN T_PRODUCT B "
				+ " ON A.i_product = B.i_product ";
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);			
			ps.setString(1, param.getYearMon());
			rs = ps.executeQuery();
			while(rs.next()) {
				StatisticsVO vo = new StatisticsVO();
				vo.setR_dt(rs.getString("r_dt"));
				vo.setQty(rs.getInt("qty"));
				vo.setTotalPrice(rs.getInt("totalPrice"));
				vo.setNm(rs.getString("nm"));
				vo.setPic(rs.getString("pic"));
				vo.setPrice(rs.getInt("price"));
				
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}			
		
		return list;
	}
	
	//일별 통계
	public static List<StatisticsVO> getStatisticsDay(StatisticsVO param) {
		List<StatisticsVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.r_dt, A.i_product, B.pic, B.nm, B.price, A.qty, A.totalPrice "
				+ " FROM ( "
				+ " SELECT TO_CHAR(r_dt, 'yyyy-mm-dd') as r_dt, i_product, sum(qty) as qty, sum(price) as totalPrice "
				+ " FROM T_PURCHASE  "
				+ " GROUP BY TO_CHAR(r_dt, 'yyyy-mm-dd'), i_product "
				+ " ) A "
				+ " INNER JOIN T_PRODUCT B "
				+ " ON A.i_product = B.i_product "
				+ " WHERE A.r_dt BETWEEN ? AND ? "
				+ " ORDER BY A.r_dt ";
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);		
			ps.setString(1, param.getS_dt());
			ps.setString(2, param.getE_dt());
			rs = ps.executeQuery();
			while(rs.next()) {
				StatisticsVO vo = new StatisticsVO();
				vo.setR_dt(rs.getString("r_dt"));
				vo.setI_product(rs.getInt("i_product"));
				vo.setNm(rs.getString("nm"));
				vo.setPrice(rs.getInt("price"));
				vo.setQty(rs.getInt("qty"));
				vo.setPic(rs.getString("pic"));
				vo.setTotalPrice(rs.getInt("totalPrice"));				
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}		
		return list;
	}
}
