package com.revature.pms.controller.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.model.Customer;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerDeposit
 */
public class CustomerDeposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerDeposit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int customerId=(int) session.getAttribute("customerId");
		String customerPassword= (String) session.getAttribute("customerPassword");
		
		//int customerId = Integer.parseInt(request.getParameter("customerId"));
		int customerAmount = Integer.parseInt(request.getParameter("amount"));
		//String customerPassword = request.getParameter("customerPassword");
		boolean result = false;
		int balance=0;
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body bgcolor=lightblue align=center>");
		CustomerService customerService=new CustomerServiceImpl();
		result=customerService.isCustomerExists(customerId);
		if(result==true) {
			if(customerAmount<0)
				out.println("<h3>You cannot deposit negative amount!");
			else {
					balance=customerService.depositOfCustomer(customerId,customerPassword,customerAmount);
					out.println("<h3>Amount is deposited successfully!");
					out.println("<h3>After deposit the balance is :"+balance);
			}
			
				
			}
		else
			out.println("<h3>customer not exist for given customer Id!");
		out.println("<br><br><br><a href=CustomerPage.html>Customer Personal Page</a>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
