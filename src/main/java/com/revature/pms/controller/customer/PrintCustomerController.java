package com.revature.pms.controller.customer;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.model.Customer;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;


    		 
    		public class PrintCustomerController extends HttpServlet {
    			private static final long serialVersionUID = 1L;
    		       
    		    /**
    		     * @see HttpServlet#HttpServlet()
    		     */
    		    public PrintCustomerController() {
    		        super();
    		        // TODO Auto-generated constructor stub
    		    }

    			/**
    			 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    			 */
    			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    					CustomerService customerService = new CustomerServiceImpl();
    					List<Customer> customers = customerService.getAllCustomers();
    					
    					HttpSession session = request.getSession();
    					session.setAttribute("allCustomers", customers);
    					
    					RequestDispatcher dispatcher = request.getRequestDispatcher("displayCustomerDetails.jsp");
    					dispatcher.forward(request, response);
    			}

    		


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
