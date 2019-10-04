package kr.hkit.shoppingmall.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.hkit.shoppingmall.Util;
import kr.hkit.shoppingmall.model.AdminVO;

@WebServlet("/admin/home")
public class AdminHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss = request.getSession();
		AdminVO loginAdmin = (AdminVO)ss.getAttribute("loginAdmin");		
		if(loginAdmin == null) {
			response.sendRedirect("login");
			return;
		}
		
		Util.adminView("home", request, response);
	}
}
