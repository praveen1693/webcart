package com.webcart.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webcart.entity.Member;
import com.webcart.exception.WebException;
import com.webcart.service.MemberService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		System.out.println(userName + " - " + password);
		
		if(userName.equals("") || password.equals(""))
		{
			throw new WebException("Invalid input, textfields cannot be empty");
		}
		
		
		if(MemberService.loginCheck(userName,password))
		{
			//validating the user login
			HttpSession session = request.getSession(true);
			System.out.println(session.getId());
			
			session.setAttribute("USERNAME", userName);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/menu.jsp");
			rd.forward(request, response);
		}
		else
		{
			System.out.println("Invalid login");
			RequestDispatcher rd = request.getRequestDispatcher("index.html");
			rd.forward(request, response);

		}
		}
		catch(WebException e)
		{
			e.getDetails();
		}
		
		
	}

}
