package com.revature.pms.controller.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;

/**
 * Servlet implementation class EmpCheckCustBalance
 */
public class EmpCheckCustBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpCheckCustBalance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		int customerId = Integer.parseInt(request.getParameter("customerId"));

		boolean result = false;

		response.setContentType("text/html");
		out.println("<html><body bgcolor=lightblue align=center>");
		CustomerService customerService = new CustomerServiceImpl();
		result = customerService.isCustomerExists(customerId);
		if (result == true) {

			int balance = customerService.checkBalanceOfCustomer(customerId);
			out.println("<h3>The balance for :" + customerId + " is " + balance);

		} else
			out.println("<h3>Customer not exist for given employee Id!!");
		
	
		
		
		out.println("<br><br><a href=EmployeePage.html>EmployeePage</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
