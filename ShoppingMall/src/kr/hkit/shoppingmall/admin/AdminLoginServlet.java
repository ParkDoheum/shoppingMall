package kr.hkit.shoppingmall.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.hkit.shoppingmall.Util;
import kr.hkit.shoppingmall.dao.AdminDAO;
import kr.hkit.shoppingmall.model.AdminVO;

@WebServlet("/admin/login")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession ss = request.getSession();
		AdminVO loginAdmin = (AdminVO)ss.getAttribute("loginAdmin");		
		if(loginAdmin != null) {
			response.sendRedirect("home");
			return;
		}
		Util.adminView("login", request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		
		AdminVO vo = AdminDAO.login(mid);
		request.setAttribute("mid", mid);
				
		if(vo == null) {
			request.setAttribute("msg", "존재하지 않는 아이디입니다.");
			doGet(request, response);
		} else {
			if(vo.getMpw().equals(mpw)) {
				HttpSession ss = request.getSession();
				ss.setAttribute("loginAdmin", vo);
				response.sendRedirect("home");
			} else {
				request.setAttribute("msg", "비밀번호를 확인해 주세요.");
				doGet(request, response);	
			}
		}
	}

}
