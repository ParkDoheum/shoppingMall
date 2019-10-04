package kr.hkit.shoppingmall.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.hkit.shoppingmall.Util;
import kr.hkit.shoppingmall.dao.AdminProductDAO;
import kr.hkit.shoppingmall.model.ProductVO;

@WebServlet("/admin/pImport")
public class AdminPimportServlet extends AdminServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGetChild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("importList", AdminProductDAO.getProductImportList());
		request.setAttribute("productList", AdminProductDAO.getProductList(null));
		Util.adminView("pImport", request, response);
	}	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ProductVO vo = new ProductVO();
		vo.setI_product(Integer.parseInt(request.getParameter("i_product")));		
		vo.setQty(Integer.parseInt(request.getParameter("qty")));		
		
		int result = AdminProductDAO.importProduct(vo);
		if(result == 1) {
			AdminProductDAO.modProductQty(1, vo);	
		}				
		response.sendRedirect("pImport");
	}
}
