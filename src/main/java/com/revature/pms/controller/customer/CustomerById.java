package com.revature.pms.controller.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pms.model.Customer;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerById
 */
public class CustomerById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		
		boolean result=false;
		
		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		out.println("<html><body bgcolor=lightblue align=center>");
		CustomerService customerService = new CustomerServiceImpl();
		result=customerService.isCustomerExists(customerId);
		if(result==true) {
			Customer customer=customerService.getCustomerById(customerId);

			out.println("<h3>Customer Name:"+customer.getCustomerName());
			out.println("<h3>Customer Mobile Number:"+customer.getCustomerMobileNumber());
			out.println("<h3>Customer Mail Id:"+customer.getCustomerMailId());
			out.println("<h3>Customer Password:"+customer.getCustomerPassword());
			out.println("<h3>Customer Balance:"+customer.getCustomerBalance());
			out.println("<h3>Customer registration date:"+customer.getRegistrationDate());
			
			
		}
		else
			out.println("<h3>Customer not exist for given customer Id!");
		out.println("<br><br><br><a href=EmployeePage.html>Employee Personal Page</a>");
	
			
		}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
