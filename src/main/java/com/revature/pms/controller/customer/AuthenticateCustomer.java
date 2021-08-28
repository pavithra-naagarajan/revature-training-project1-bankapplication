package com.revature.pms.controller.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;

/**
 * Servlet implementation class AuthenticateCustomer
 */
public class AuthenticateCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthenticateCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }
    
   
  
	
    protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	
		
		
		String customerName = request.getParameter("username");
		String password = request.getParameter("password");
		int flag=0;
		int customerId=0;
		CustomerService customerService = new CustomerServiceImpl();
		List<Customer> customerList=customerService.getAllCustomers();

		for(Customer c:customerList) {
			if(c.getCustomerName().equals(customerName) &&c.getCustomerPassword().equals(password))
				customerId=c.getCustomerId();
		}
		HttpSession session = request.getSession();
		session.setAttribute("customerName", customerName);
		session.setAttribute("customerPassword", password);
		session.setAttribute("customerId", customerId);

		PrintWriter out = response.getWriter();
		
		response.setContentType("text/html");
		out.println("<html><body bgcolor=lightblue align=center>");
		
		for(Customer c:customerList) {
			
			if(c.getCustomerName().equals(customerName) ){
				if(c.getCustomerPassword().equals(password) ){
			
				flag=1;
				break;
				}
			}
			else 
				flag=0;	
		}
			
		if(flag==1) {
			out.println("<h3>You have logged in at : " + new java.util.Date());
			/*
			 * out.println("<br>Your name is : " + customerName);
			 * out.println("<br>Your password is : " + password);
			 */
			out.println("<br/><br/><a href=CustomerPage.html>Customer Page</a>");
			
		}
		else {
			out.println("<br><h3>Your login details are not matched!Try again");
			out.println("<br/><br/><a href=Login.html>Login Again</a>");
		}
		
		boolean alreadyVisited = false;
		Cookie allCookies[] = request.getCookies();

		
		
		

		if (allCookies == null) {
			
		} else {
			for (Cookie c : allCookies) {
				if (c.getName().equals(customerName)) {
					alreadyVisited = true;
					break;
				}
			}
		}

		if (alreadyVisited) {
			out.println("<h4>Your have already visited my website : " + customerName);

		} else {
			out.println("<h4>You are first time visitor " + customerName);
			Cookie c = new Cookie(customerName, customerName);
			c.setMaxAge(1000*60*60*24*30);
			response.addCookie(c);
		}

		
		out.println("</body></html>");
	}

}
