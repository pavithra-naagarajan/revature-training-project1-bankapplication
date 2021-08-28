package com.revature.pms.controller.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;
import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.EmployeeServiceImpl;

/**
 * Servlet implementation class UpdateCustomerController
 */
public class UpdateCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int customerId=(int) session.getAttribute("editCustomerById");
		boolean res=false;
		String customerName = request.getParameter("customerName");
		String customerMobileNumber = request.getParameter("customerMobileNumber");
		String customerMailId = request.getParameter("customerMailId");
		String customerPassword = request.getParameter("customerPassword");
		
	
		CustomerService customerService=new CustomerServiceImpl();
		res=customerService.updateCustomer(customerId,customerName,customerMobileNumber,customerMailId,customerPassword);
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor=lightblue align=center>");
		out.println("<h1>"+customerName + ", details are updated successfuly!");
		out.println("<h1><a href=CustomerPage.html>Customer Page</a>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
