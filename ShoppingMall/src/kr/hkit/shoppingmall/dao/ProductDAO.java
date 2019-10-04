package kr.hkit.shoppingmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.hkit.shoppingmall.model.ProductVO;

public class ProductDAO {
	public static int getTotalPages(int viewCnt, String search) {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT ceil(count(i_product) / ?) FROM t_product ";
		
		if(search != null && !search.equals("")) {			
			sql += " WHERE nm like '%" + search + "%' ";
		}
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);
			ps.setInt(1,  viewCnt);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}	
		return result;
	}
	
	public static List<ProductVO> getProductList(ProductVO param) {
		List<ProductVO> list = new ArrayList();
		int currentPage = param.getCurrentPage();
		int viewPageCnt = param.getViewPageCnt();
		
		int eIndex = currentPage * viewPageCnt;
		int sIndex = eIndex - (viewPageCnt - 1);
		
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT * FROM ("
				+ " SELECT A.*, ROW_NUMBER() OVER(ORDER BY i_product) AS NUM "
				+ " FROM t_product A ";
		
		int whereCnt = 0;		
		
		if(param != null) {
			if(param.getYn_sale() == 1) {
				whereCnt++;
				sql = " WHERE A.yn_sale = 1 ";
			}
			
			if(param.getSearch() != null && !param.getSearch().equals("")) {
				if(whereCnt == 0) {
					sql += " WHERE ";
				} else {
					sql += " AND ";
				}
				whereCnt++;				
				sql += " A.nm like '%" + param.getSearch() + "%' ";
			}
		}		
		
		sql += " ORDER BY i_product "
			+ " ) WHERE NUM BETWEEN ? AND ? "; 

		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);
			ps.setInt(1, sIndex);
			ps.setInt(2, eIndex);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setI_product(rs.getInt("i_product"));
				vo.setNm(rs.getString("nm"));
				vo.setPic(rs.getString("pic"));
				vo.setPrice(rs.getInt("price"));
				vo.setQty(rs.getInt("qty"));
				vo.setYn_sale(rs.getInt("yn_sale"));				
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}		
		
		return list;
	}
	
	public static ProductVO getProduct(int i_product) {
		ProductVO vo = null;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT * FROM t_product WHERE i_product = ? ";
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);
			ps.setInt(1, i_product);
			rs = ps.executeQuery();
			if(rs.next()) {
				vo = new ProductVO();
				vo.setI_product(rs.getInt("i_product"));
				vo.setNm(rs.getString("nm"));
				vo.setPic(rs.getString("pic"));
				vo.setPrice(rs.getInt("price"));
				vo.setQty(rs.getInt("qty"));
				vo.setInfo(rs.getString("info"));
				vo.setYn_sale(rs.getInt("yn_sale"));				
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}		
		return vo;
	}
	
	
	
	
}
