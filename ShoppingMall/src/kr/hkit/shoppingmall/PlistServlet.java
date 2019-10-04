package kr.hkit.shoppingmall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.hkit.shoppingmall.dao.AdminProductDAO;
import kr.hkit.shoppingmall.dao.MemberProductDAO;
import kr.hkit.shoppingmall.model.ProductVO;

@WebServlet("/pList")
public class PlistServlet extends CustomerServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGetChild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String search = request.getParameter("search");		
		int currentPage = request.getParameter("currentPage") == null ? 1 : Integer.parseInt(request.getParameter("currentPage"));
		int totalPages = AdminProductDAO.getTotalPages(Util.VIEW_PAGE_CNT, search);
		
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPages", totalPages);		
		
		ProductVO param = new ProductVO();
		param.setYn_sale(1);
		param.setViewPageCnt(Util.VIEW_PAGE_CNT);
		param.setSearch(search);
		param.setCurrentPage(currentPage);
		
		request.setAttribute("css", "pList");		
		request.setAttribute("list", MemberProductDAO.getProductList(param));
		Util.view("pList", request, response);
	}
}
