package kr.hkit.shoppingmall.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.hkit.shoppingmall.Util;
import kr.hkit.shoppingmall.dao.AdminProductDAO;
import kr.hkit.shoppingmall.model.ProductVO;

@WebServlet("/admin/pReg")
public class AdminPregServlet extends AdminServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGetChild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("i_product", AdminProductDAO.getIproductForInsert());
		Util.adminView("pReg", request, response);
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ProductVO vo = new ProductVO();
		vo.setI_product(Integer.parseInt(request.getParameter("i_product")));
		vo.setNm(request.getParameter("nm"));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		vo.setPic(request.getParameter("pic"));		
		vo.setInfo(request.getParameter("info"));
		AdminProductDAO.regProduct(vo);
		response.sendRedirect("pReg");
	}
}
