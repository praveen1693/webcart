package com.webcart.service;

import java.util.List;

import com.webcart.db.MemberDAO;
import com.webcart.entity.Member;
import com.webcart.entity.Order;
import com.webcart.entity.OrderItem;
import com.webcart.entity.Product;

public class MemberService {

	public static boolean create(Member member)
	{
		MemberDAO dao = new MemberDAO();
		return dao.create(member);
	}
	
	public static boolean loginCheck(String userName, String password)
	{
		MemberDAO dao = new MemberDAO();
		return dao.loginCheck(userName,password);
	}
	
	public static boolean addToCart(String user,String pid)
	{
		MemberDAO dao = new MemberDAO();
		return dao.addToCart(user,pid);
	}
	
	public static List<Product> getCart(String user)
	{
		MemberDAO dao = new MemberDAO();
		return dao.getCart(user);
	}
	
	public static boolean delete(String user, String pid)
	{
		MemberDAO dao = new MemberDAO();
		return dao.delete(user, pid);
	}
	
	public static boolean addOrderItem(OrderItem o)
	{
		MemberDAO dao = new MemberDAO();
		return dao.addOrderItem(o);
	}
	
	public static boolean addOrderDetails(Order o)
	{
		MemberDAO dao = new MemberDAO();
		return dao.addOrderDetails(o);
	}
	
	public static boolean deleteCartItems(String user)
	{
		MemberDAO dao = new MemberDAO();
		return dao.deleteCartItems(user);
	}
	
	public static List<Order> getOrderDetails(String user)
	{
		MemberDAO dao = new MemberDAO();
		return dao.getOrderDetails(user);
	}

}
