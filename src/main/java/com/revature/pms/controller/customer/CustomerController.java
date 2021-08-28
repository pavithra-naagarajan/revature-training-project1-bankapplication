package com.revature.pms.controller.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pms.model.Customer;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;
import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.EmployeeServiceImpl;

/**
 * Servlet implementation class CustomerController
 */
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CustomerController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean flag = false;
		String customerName = request.getParameter("customerName");
		String mobileNumber = request.getParameter("customerMobileNumber");
		String emailId = request.getParameter("customerMailId");
		String password = request.getParameter("customerPassword");
		int balance = Integer.parseInt(request.getParameter("customerBalance"));

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreated = new Date();
		String registrationDate = formatter.format(dateCreated);

		Customer customer = new Customer(0, customerName, mobileNumber, emailId, password, balance, registrationDate);
		EmployeeService employeeService = new EmployeeServiceImpl();
		CustomerService customerService = new CustomerServiceImpl();
		flag = employeeService.employeeApproval(customer);
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor=lightblue align=center>");
		if (flag == true) {
			customerService.addCustomer(customer);
			out.println("Your account is approved by employee!");
			out.println("<h1>" + customerName
					+ ", congrats you have successfully opened an account in our bank with balance of INR " + balance);
		} else {
			out.println("Your account is denied by employee!");

			out.println("<h2>Sorry your account cannot be created succefully,please deposit initial balance as 5000!");

		}
		out.println("<h2><a href=Login.html>Login</a>");
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
