package kr.hkit.shoppingmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.hkit.shoppingmall.model.ProductVO;

public class AdminProductDAO extends ProductDAO {

	public static int getIproductForInsert() {
		int result = 0;
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT nvl(max(i_product), 0) + 1 FROM t_product ";
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				result = rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}
		
		return result;
	}
	
	public static void regProduct(ProductVO vo) {
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_product"
				+ " (i_product, nm, price, pic, info) "
				+ " VALUES "				
				+ " (?, ?, ?, ?, ?) ";
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getI_product());
			ps.setString(2, vo.getNm());
			ps.setInt(3,  vo.getPrice());
			ps.setString(4,  vo.getPic());
			ps.setString(5,  vo.getInfo());
			ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps);
		}
	}
	
	public static int modProduct(ProductVO vo) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " UPDATE t_product "
				+ " SET nm = ?, "
				+ " price = ?, "
				+ " pic = ?, "
				+ " yn_sale = ?, "
				+ " info = ? "
				+ " WHERE i_product = ? ";
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);			
			ps.setString(1, vo.getNm());
			ps.setInt(2,  vo.getPrice());
			ps.setString(3,  vo.getPic());
			ps.setInt(4,  vo.getYn_sale());
			ps.setString(5,  vo.getInfo());
			ps.setInt(6, vo.getI_product());
			result = ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps);
		}						  
		
		return result;
	}
	
	//상품 수량 변경 <ie(1): 입고, (2):출고>
	public static int modProductQty(int ie, ProductVO vo) { 
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " UPDATE t_product SET ";
		if(ie == 1) {
			sql += " qty = qty + ? ";
		} else if (ie == 2) {
			sql += " qty = qty - ? ";
		} else {
			return 0;
		}				
		sql += " WHERE i_product = ? ";
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);			
			ps.setInt(1, vo.getQty());			
			ps.setInt(2, vo.getI_product());
			result = ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps);
		}						  
		
		return result;
	}
	
	
	
	//입고처리
	public static int importProduct(ProductVO vo) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_product_import "
				+ " (i_pi, i_product, qty, price) "
				+ " VALUES "
				+ " ( "
				+ "   (SELECT nvl(max(i_pi), 0) + 1 FROM t_product_import) "
				+ "   , ?, ?, " //1, 2
				+ "   (SELECT price * ? from t_product where i_product = ?) " //3, 4
				+ " ) ";
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getI_product());
			ps.setInt(2,  vo.getQty());
			ps.setInt(3,  vo.getQty());
			ps.setInt(4, vo.getI_product());
			result = ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps);
		}
		return result;
	}
	
	//입고 리스트
	public static List<ProductVO> getProductImportList() {
		List<ProductVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.i_pi, B.nm, A.qty, A.price, A.i_dt "
				+ " FROM T_PRODUCT_IMPORT A "
				+ " INNER JOIN T_PRODUCT B "				
				+ " ON A.i_product = B.i_product "
				+ " ORDER BY A.i_dt DESC ";
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);			
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setI_pi(rs.getInt("i_pi"));
				vo.setNm(rs.getString("nm"));
				vo.setQty(rs.getInt("qty"));
				vo.setPrice(rs.getInt("price"));
				vo.setI_dt(rs.getString("i_dt"));
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
