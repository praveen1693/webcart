package com.webcart.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.webcart.entity.Order;
import com.webcart.entity.OrderItem;
import com.webcart.entity.Product;
import com.webcart.service.MemberService;

/**
 * Servlet implementation class OrderServlet
 */
public class OrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("USERNAME");
		List<Order> orders = new ArrayList<>();
		
		//code to extract order details
		orders = MemberService.getOrderDetails(user);
		
		if(orders.isEmpty())
		{
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/emptyorders.jsp");
			rd.forward(request, response);
		}else
		{
			request.setAttribute("ORDERS", orders);
			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/myorder.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("USERNAME");
		List<Product> cart = MemberService.getCart(user);
		
		float subTotal =0 ;
		String uniqueID = UUID.randomUUID().toString();
		String orderId = uniqueID.substring(0, 15);
		System.out.println(orderId);
		
		
		for(int i=0;i<cart.size();i++)
		{
			subTotal+=cart.get(i).getQuantity()*Integer.parseInt(cart.get(i).getPrice());
		}
		
		//code to fill orders
		Calendar c = Calendar.getInstance();//adding 7 days
		Date orderDate = c.getTime();
		c.add(Calendar.DATE, 7);
		Date dlvDate = c.getTime();
		float tax = (float) (18.0*subTotal/100.0);
		float grandtotal = subTotal + tax;
		MemberService.addOrderDetails(new Order(user,orderId, subTotal, tax, grandtotal, orderDate, dlvDate, "Success"));
		
		//code to fill orderItems table
		subTotal=0;
		for(int i=0;i<cart.size();i++)
		{
			subTotal = cart.get(i).getQuantity()*Integer.parseInt(cart.get(i).getPrice());
			MemberService.addOrderItem(new OrderItem(orderId, cart.get(i).getPid(), cart.get(i).getQuantity(), subTotal));
		}
		//code to pass the values to a new .jsp and display order
		request.setAttribute("CART", cart);
		request.setAttribute("ORDERID", orderId);
		request.setAttribute("SUBTOTAL", subTotal);
		request.setAttribute("ORDERDATE", orderDate);
		request.setAttribute("DLVDATE", dlvDate);
		request.setAttribute("TAX", tax);
		request.setAttribute("GRANDTOTAL", grandtotal);
		
		//code to delete all items in cart
		MemberService.deleteCartItems(user);
		
		RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/neworder.jsp");
		rd.forward(request, response);
	}
	

}
