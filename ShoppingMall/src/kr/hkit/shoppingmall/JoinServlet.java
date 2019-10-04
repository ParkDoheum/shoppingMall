package kr.hkit.shoppingmall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.hkit.shoppingmall.dao.MemberDAO;
import kr.hkit.shoppingmall.model.MemberVO;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("css", "login");
		Util.view("join", request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO vo = new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		vo.setNm(request.getParameter("nm"));
		
		System.out.println("join - post - vo : " + vo);
		int result = MemberDAO.join(vo);
		
		if(result == 1) { //회원가입 성공
			response.sendRedirect("login");
		} else {
			request.setAttribute("msg", "회원가입 실패");
			doGet(request, response);
		}
		
	}

}
