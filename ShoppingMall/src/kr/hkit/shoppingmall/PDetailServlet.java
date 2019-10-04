package kr.hkit.shoppingmall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.hkit.shoppingmall.dao.AdminProductDAO;
import kr.hkit.shoppingmall.dao.MemberProductDAO;
import kr.hkit.shoppingmall.dao.ProductDAO;
import kr.hkit.shoppingmall.model.MemberVO;
import kr.hkit.shoppingmall.model.ProductVO;

@WebServlet("/pDetail")
public class PDetailServlet extends CustomerServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGetChild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i_product = Integer.parseInt(request.getParameter("i_product"));
		request.setAttribute("vo", MemberProductDAO.getProduct(i_product));
		Util.view("pDetail", request, response);
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("PDetailServlet - doPost");
		request.setCharacterEncoding("UTF-8");
		
		HttpSession ss = request.getSession();
		MemberVO mVo = (MemberVO)ss.getAttribute("loginMember");
		
		String type = request.getParameter("type");
		int i_product = Integer.parseInt(request.getParameter("i_product"));
		int qty = Integer.parseInt(request.getParameter("qty"));
		int price = Integer.parseInt(request.getParameter("price"));
		ProductVO vo = new ProductVO();
		vo.setI_product(i_product);
		vo.setQty(qty);
		vo.setI_member(mVo.getI_member());
		vo.setPrice(price);
		
		if(type.equals("1")) { //장바구니
			MemberProductDAO.regBasket(vo);
		} else if (type.equals("2")) { //구매
			int result = MemberProductDAO.regPurchase(vo);
			if(result == 1) {
				AdminProductDAO.modProductQty(2, vo);
			}
		}
		
		response.sendRedirect("pList");
	}
}
