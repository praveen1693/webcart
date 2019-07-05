package com.webcart.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.webcart.entity.Member;
import com.webcart.entity.Order;
import com.webcart.entity.OrderItem;
import com.webcart.entity.Product;


public class MemberDAO {

	
	//inserting values to register n login table
	public boolean create(Member member)
	{
		String sql0 = "select userName from register where userName = ?";
		String sql1 = "insert into register values(?,?,?,?,?)";
		String uName=null;
		int row = 0;
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps0 = conn.prepareStatement(sql0);
			ps0.setString(1, member.getUserName());
			ResultSet rs = ps0.executeQuery();
			if(rs != null && rs.next())
			{
				uName = rs.getString(1);
			}
			if(uName != null && uName.equals(member.getUserName()))
			{
				System.out.println("Username already in use. Select another one");
				return false;
			}
			PreparedStatement ps1 = conn.prepareStatement(sql1);	
			ps1.setString(1, member.getUserName());
			ps1.setString(2, member.getPassword());
			ps1.setString(3, member.getName());
			ps1.setString(4, member.getPhNo());
			ps1.setString(5, member.getMailId());
			row = ps1.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return (row>0);
	}
	
	public boolean loginCheck(String userName, String password)
	{
		
		boolean validate = false;
		String sql="select password from register where userName=?";
		String p = null;
		
		try(Connection conn = DBConnectionManager.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, userName);
			ResultSet rs = ps.executeQuery();
			if(rs != null && rs.next())
			{
				p = rs.getString(1);
			}
			
			if(p != null && p.equals(password))
			{
				validate = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return validate;
	}
	
	public boolean addToCart(String user, String pid)
	{
		int row = 0;
		String sql1 = "select productId from cart where userName=? and productId=?";
		String sql2 = "insert into cart value(?,?,?)";
		String sql3 = "update cart set quantity = quantity+? where userName=? and productId=?";
		String dummyPid = null;
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setString(1, user);
			ps1.setString(2, pid);
			ResultSet rs = ps1.executeQuery();
			if(rs !=null && rs.next())
			{
				dummyPid = rs.getString(1);
			}
			if(dummyPid != null && dummyPid.equals(pid))
			{
				PreparedStatement ps3 = conn.prepareStatement(sql3);
				ps3.setInt(1, 1);
				ps3.setString(2, user);
				ps3.setString(3, pid);
				row = ps3.executeUpdate();
			}
			else
			{
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setString(1,user);
				ps2.setString(2, pid);
				ps2.setInt(3, 1);
				row = ps2.executeUpdate();
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}	
		return row>0;
	}
	
	public List<Product> getCart(String user)
	{
		
		List<String> productIdList = new ArrayList<>();
		String price = "0";
		List<Product> pList = new ArrayList<>();
		String sql0 = "select productId from cart where userName=?";
		String sql1 = "select price from product where productId = ?";
		String sql2 = "select quantity from cart where userName=? and productId = ?";
		
		try(Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement ps0 = conn.prepareStatement(sql0);
			ps0.setString(1, user);
			ResultSet rs = ps0.executeQuery();
			while(rs != null && rs.next())
			{
				productIdList.add(rs.getString(1));
				System.out.println(rs.getString(1));
			}
			
			for(String p : productIdList)
			{
				PreparedStatement ps1 = conn.prepareStatement(sql1);
				ps1.setString(1, p );
				ResultSet rs1 = ps1.executeQuery();
				if(rs1 != null && rs1.next())
				{
					System.out.println(rs1.getString(1));
					price = rs1.getString(1);
				}	
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setString(1, user);
				ps2.setString(2, p);
				ResultSet rs2 = ps2.executeQuery();
				if(rs2 != null && rs2.next())
				{
					pList.add(new Product(p, price, rs2.getInt(1)));
				}
			}
			return pList;
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return pList;
	
	}
	
	public boolean delete(String user, String pid)
	{
		int row=0; 
		String sql1 = "select quantity from cart where userName=? and productId=?";
		String sql2 = "delete from cart userName=? and productId=?";
		String sql3 = "update cart set quantity = quantity-? where userName=? and productId=?";
		
		try(Connection conn = DBConnectionManager.getConnection()){
			int q = 0;
			PreparedStatement ps1 = conn.prepareStatement(sql1);
			ps1.setString(1, user);
			ps1.setString(2, pid);
			ResultSet rs1 = ps1.executeQuery();
			if(rs1 != null && rs1.next())
			{
				q = rs1.getInt(1);
			}
			if(q == 1)
			{
				PreparedStatement ps2 = conn.prepareStatement(sql2);
				ps2.setString(1, user);
				ps2.setString(2, pid);
				row = ps2.executeUpdate();
			}
			else
			{
				PreparedStatement ps3 = conn.prepareStatement(sql3);
				ps3.setInt(1, 1);
				ps3.setString(2, user);
				ps3.setString(3, pid);
				row = ps3.executeUpdate();
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		System.out.println("row" +row);
		return row>0;
	}
	
	public boolean addOrderItem(OrderItem o)
	{
		int row = 0;
		String sql = "insert into orderitem values(?,?,?,?)";
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, o.getOrderId());
			ps.setString(2, o.getProductId());
			ps.setInt(3, o.getQuantity());
			ps.setFloat(4,o.getSubtotal());
			row = ps.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}

		return row>0;
	}
	
	public boolean addOrderDetails(Order o)
	{
		int row=0;
		String sql = "insert into orders values(?,?,?,?,?,?,?,?)";
		
		java.sql.Date dlvDate = new java.sql.Date(o.getDlvDate().getTime());
		java.sql.Date orderDate = new java.sql.Date(o.getOrderDate().getTime());
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, o.getOrderId());
			ps.setString(2, o.getUser());
			ps.setFloat(3, o.getSubtotal());
			ps.setFloat(4, o.getTax());
			ps.setFloat(5, o.getGrandtotal());
			ps.setDate(6, orderDate);
			ps.setDate(7, dlvDate);
			ps.setString(8, o.getStatus());
			row = ps.executeUpdate();
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return row>0;
	}
	
	public boolean deleteCartItems(String user)
	{
		int row = 1;
		String sql = "delete from cart where userName = ?";
		
		try(Connection conn = DBConnectionManager.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			row = ps.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return row>0;
	}
	
	public List<Order> getOrderDetails(String user)
	{
		String sql = "select orderid,subTotal,tax,GrandTotal,orderDate,dlvDate,status from orders where userid = ?";
		List<Order> orders = new ArrayList<>(); 
		
		try(Connection conn = DBConnectionManager.getConnection())
		{
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ResultSet rs = ps.executeQuery();
			while(rs != null && rs.next())
			{
				orders.add(new Order(user, rs.getString(1), rs.getFloat(2), rs.getFloat(3), rs.getFloat(4), rs.getDate(5), rs.getDate(6), rs.getString(7)));
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return orders;
	}
}
