package kr.hkit.shoppingmall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.hkit.shoppingmall.dao.MemberProductDAO;
import kr.hkit.shoppingmall.model.MemberVO;
import kr.hkit.shoppingmall.model.ProductVO;

@WebServlet("/purchaseList")
public class PurchaseListServlet extends CustomerServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGetChild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession hs = request.getSession();
		MemberVO mVo = (MemberVO) hs.getAttribute("loginMember");
		
		int i_member = mVo.getI_member();
		System.out.println("i_member : " + i_member);
		ProductVO param = new ProductVO();
		param.setI_member(mVo.getI_member());
		
		request.setAttribute("list", MemberProductDAO.getPurchaseList(param));
		Util.view("purchaseList", request, response);
	}
}
