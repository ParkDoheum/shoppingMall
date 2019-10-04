package kr.hkit.shoppingmall.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.hkit.shoppingmall.Util;
import kr.hkit.shoppingmall.dao.AdminProductDAO;
import kr.hkit.shoppingmall.model.ProductVO;

@WebServlet("/admin/pList")
public class AdminPlistServlet extends AdminServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGetChild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String search = request.getParameter("search") == null ? "" : request.getParameter("search");		
		int currentPage = request.getParameter("currentPage") == null ? 1 : Integer.parseInt(request.getParameter("currentPage"));
		int totalPages = AdminProductDAO.getTotalPages(Util.VIEW_PAGE_CNT, search);
		
		request.setAttribute("search", search);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("totalPages", totalPages);		
		
		ProductVO param = new ProductVO();		
		param.setViewPageCnt(Util.VIEW_PAGE_CNT);
		param.setSearch(search);
		param.setCurrentPage(currentPage);
		
		request.setAttribute("list", AdminProductDAO.getProductList(param));
		Util.adminView("pList", request, response);
	}
}
