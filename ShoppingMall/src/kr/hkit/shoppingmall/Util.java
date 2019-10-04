package kr.hkit.shoppingmall;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Util {
	private final static String TEMPLATE = "template.jsp";
	public final static int VIEW_PAGE_CNT = 5;
	
	public static void view(String jspName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setAttribute("view", jspName);
		request.getRequestDispatcher(TEMPLATE).forward(request, response);
	}
	
	public static void adminView(String jspName, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.setAttribute("view", jspName);
		request.getRequestDispatcher("/admin/template.jsp").forward(request, response);
	}
}
