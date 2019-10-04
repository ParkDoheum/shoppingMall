package kr.hkit.shoppingmall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.hkit.shoppingmall.dao.MemberProductDAO;

@WebServlet("/basket")
public class BasketServlet extends CustomerServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGetChild(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setAttribute("list", MemberProductDAO.getBasketProductList());
		Util.view("basket", request, response);
	}
}
