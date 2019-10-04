package kr.hkit.shoppingmall.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.hkit.shoppingmall.Util;
import kr.hkit.shoppingmall.dao.AdminProductDAO;
import kr.hkit.shoppingmall.dao.AdminStatisticsDAO;
import kr.hkit.shoppingmall.model.StatisticsVO;

@WebServlet("/admin/pSaleMon")
public class AdminPsaleMonServlet extends AdminServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGetChild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selYear = request.getParameter("selYear");
		String selMon = request.getParameter("selMon");
		int i_product = Integer.parseInt(request.getParameter("i_product") == null ? "0" : request.getParameter("i_product"));
		if(selYear != null && selMon != null) {
			
			if(selMon.length() == 1) {
				selMon = "0" + selMon;
			}
			
			StatisticsVO param = new StatisticsVO();
			param.setYearMon(selYear + "-" + selMon);
			param.setI_product(i_product);
			
			System.out.println(" date : " + param.getYearMon());
			System.out.println(" i_product : " + param.getI_product());
			
			request.setAttribute("selYear", Integer.parseInt(selYear));
			request.setAttribute("selMon", Integer.parseInt(selMon));
			request.setAttribute("i_product", i_product);
			request.setAttribute("dataList", AdminStatisticsDAO.getStatisticsMon(param));	
			
		}
		request.setAttribute("pList", AdminProductDAO.getProductList(null));	
		Util.adminView("pSaleMon", request, response);
	}
}
