package com.revature.pms.controller.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;
import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.EmployeeServiceImpl;

/**
 * Servlet implementation class CustomerByName
 */
public class CustomerByName extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerByName() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String customerName = request.getParameter("customerName");

		
		CustomerService customerService = new CustomerServiceImpl();
		

		List<Customer> customers = customerService.getCustomerByName(customerName);
		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		out.println("<html><body bgcolor=lightblue align=center>");
	if(customers.size()==0)
		out.println("<h3>Customer is not exist for given name!");

	else {	
		for (Customer customer : customers) {
			out.println("<h3>Customer Id:" + customer.getCustomerId());
			out.println("<h3>Customer Name:" + customer.getCustomerName());
			out.println("<h3>Customer Mobile Number:" + customer.getCustomerMobileNumber());
			out.println("<h3>Customer Mail Id:" + customer.getCustomerMailId());
			out.println("<h3>Customer Password:" + customer.getCustomerPassword());
			out.println("<h3>Customer Balance:" + customer.getCustomerBalance());
			out.println("<h3>Customer registration date:" + customer.getRegistrationDate());
			out.println("<h4>************************************************************");


		}
	}

		out.println("<br><br><br><a href=EmployeePage.html>Employee Page</a>");

	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
