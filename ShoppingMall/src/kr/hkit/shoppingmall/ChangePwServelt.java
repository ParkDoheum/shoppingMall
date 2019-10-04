package kr.hkit.shoppingmall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.hkit.shoppingmall.dao.MemberDAO;
import kr.hkit.shoppingmall.model.MemberVO;

@WebServlet("/changePw")
public class ChangePwServelt extends CustomerServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGetChild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		//request.setAttribute("list", MemberProductDAO.getProductList());
		Util.view("changePw", request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String currentPw = request.getParameter("currentPw");
		String newPw = request.getParameter("newPw");
		
		HttpSession hs = request.getSession();
		MemberVO ssVo = (MemberVO)hs.getAttribute("loginMember");
		
		MemberVO mVo = MemberDAO.getMember(ssVo);
		
		String msg = "";
		if(!mVo.getMpw().equals(currentPw)) {
			msg = "비밀번호가 맞지 않습니다.";			
		} else {
			MemberVO param = new MemberVO();
			param.setI_member(ssVo.getI_member());
			param.setMpw(newPw);
			int result = MemberDAO.changePw(param);
			
			if(result == 1) {
				msg = "비밀번호를 수정하였습니다.";
			} else {
				msg = "비밀번호를 수정을 실패하였습니다.";
			}
		}		
		
		request.setAttribute("msg", msg);
		doGet(request, response);
	}
}


