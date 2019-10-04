package kr.hkit.shoppingmall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.hkit.shoppingmall.model.MemberVO;

public abstract class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected abstract void doGetChild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession ss = request.getSession();
		MemberVO loginAdmin = (MemberVO)ss.getAttribute("loginMember");		
		if(loginAdmin == null) {
			response.sendRedirect("login");
			return;
		}
		
		doGetChild(request, response);
	}
}
