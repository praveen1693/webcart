package com.webcart.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webcart.entity.Product;
import com.webcart.service.MemberService;

/**
 * Servlet implementation class ShowCartServlet
 */
public class ShowCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("USERNAME");
		
		List<Product> cart = (MemberService.getCart(user));
		System.out.println(cart.size());
		if(cart.isEmpty())
		{			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/noitemsincart.jsp");
			rd.forward(request, response);
		}
		else
		{
			request.setAttribute("PRODUCT_LIST", cart);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/showcart.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("USERNAME");
		System.out.println(user);
		
		String action = request.getParameter("ACTION");
		if("CREATE".equals(action))
		{
			
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/showcart.jsp");
			rd.forward(request, response);
		}
		else if("DELETE".equals(action))
		{
			String pid = request.getParameter("hdnpid");
		
			System.out.println(pid);
		
			MemberService.delete(user, pid);
		}
		List<Product> cart = MemberService.getCart(user);
		request.setAttribute("PRODUCT_LIST", cart);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/showcart.jsp");
		rd.forward(request, response);
	}

}
