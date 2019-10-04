package kr.hkit.shoppingmall.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.hkit.shoppingmall.model.ProductVO;

public class MemberProductDAO extends ProductDAO {
	//구매리스트
	public static List<ProductVO> getPurchaseList(ProductVO param) {
		List<ProductVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.i_purchase, B.i_product, B.nm, B.price, B.pic, B.yn_sale, B.qty, "
				+ " A.qty as purchase_qty, A.price as purchase_price, TO_CHAR(a.r_dt, 'YYYY-MM-dd') as r_dt "
				+ " FROM T_PURCHASE A "
				+ " INNER JOIN T_PRODUCT B "
				+ " ON a.i_product = b.i_product "
				+ " WHERE i_member = ? "
				+ " ORDER BY A.r_dt DESC ";
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);
			ps.setInt(1, param.getI_member());
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setI_purchase(rs.getInt("i_purchase"));
				vo.setI_product(rs.getInt("i_product"));
				vo.setNm(rs.getString("nm"));
				vo.setPurchase_qty(rs.getInt("purchase_qty"));
				vo.setPurchase_price(rs.getInt("purchase_price"));
				vo.setPrice(rs.getInt("price"));
				vo.setPic(rs.getString("pic"));
				vo.setYn_sale(rs.getInt("yn_sale"));
				vo.setQty(rs.getInt("qty"));
				vo.setR_dt(rs.getString("r_dt"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}		
		
		return list;
	}
	
	public static int regBasket(ProductVO vo) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_basket "
				+ " (i_basket, i_member, i_product, qty, price) "								
				+ " SELECT nvl(max(i_basket), 0) + 1, "
				+ " ?, ?, ?, ? FROM t_basket ";
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getI_member());			
			ps.setInt(2,  vo.getI_product());
			ps.setInt(3,  vo.getQty());
			ps.setInt(4,  vo.getPrice());			
			result = ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps);
		}
		return result;
	}
	
	//장바구니 리스트
	public static List<ProductVO> getBasketProductList() {
		List<ProductVO> list = new ArrayList();
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = " SELECT A.i_basket, A.i_product " + 
				", B.nm, A.qty as purchase_qty, A.price as purchase_price " +
				", B.pic, B.qty, B.price " + 
				" FROM t_basket A " + 
				" INNER JOIN t_product B " + 
				" ON A.i_product = B.i_product ";
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				ProductVO vo = new ProductVO();
				vo.setI_basket(rs.getInt("i_basket"));
				vo.setI_product(rs.getInt("i_product"));
				vo.setNm(rs.getString("nm"));
				vo.setPurchase_qty(rs.getInt("purchase_qty"));
				vo.setPurchase_price(rs.getInt("purchase_price"));
				vo.setPrice(rs.getInt("price"));
				vo.setPic(rs.getString("pic"));
				vo.setQty(rs.getInt("qty"));
				list.add(vo);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps, rs);
		}		
		
		return list;
	}
	
	//구매
	public static int regPurchase(ProductVO vo) {
		int result = 0;
		Connection con = null;
		PreparedStatement ps = null;
		
		String sql = " INSERT INTO t_purchase "
				+ " (i_purchase, i_member, i_product, qty, price) "								
				+ " SELECT nvl(max(i_purchase), 0) + 1, "
				+ " ?, ?, ?, ? FROM t_purchase ";
		
		try {
			con = DBConn.getConn();
			ps = con.prepareStatement(sql);
			ps.setInt(1, vo.getI_member());			
			ps.setInt(2,  vo.getI_product());
			ps.setInt(3,  vo.getQty());
			ps.setInt(4,  vo.getPrice());			
			result = ps.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBConn.close(con, ps);
		}
		return result;
	}
}
