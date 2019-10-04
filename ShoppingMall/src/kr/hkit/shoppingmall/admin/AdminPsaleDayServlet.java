package kr.hkit.shoppingmall.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.hkit.shoppingmall.Util;
import kr.hkit.shoppingmall.dao.AdminStatisticsDAO;
import kr.hkit.shoppingmall.model.StatisticsVO;

@WebServlet("/admin/pSaleDay")
public class AdminPsaleDayServlet extends AdminServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGetChild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s_dt = request.getParameter("s_dt");
		String e_dt = request.getParameter("e_dt");
		
		request.setAttribute("s_dt", s_dt);
		request.setAttribute("e_dt", e_dt);
		
		if(s_dt != null && e_dt != null) {
			StatisticsVO param = new StatisticsVO();
			param.setS_dt(s_dt);
			param.setE_dt(e_dt);
			
			request.setAttribute("list", AdminStatisticsDAO.getStatisticsDay(param));	
		}
		
		Util.adminView("pSaleDay", request, response);
	}
}
