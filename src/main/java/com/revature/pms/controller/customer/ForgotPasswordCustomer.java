package com.revature.pms.controller.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;
import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.EmployeeServiceImpl;
import com.revature.pms.util.HibernateUtil;

/**
 * Servlet implementation class ForgotPasswordCustomer
 */
public class ForgotPasswordCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordCustomer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int customerId=Integer.parseInt(request.getParameter("userId"));
		String customerName = request.getParameter("username");
		String customerPassword = request.getParameter("password");
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor=lightblue align=center>");
		CustomerService customerService=new CustomerServiceImpl();
		List<Customer> customers=customerService.getAllCustomers();
		for(Customer c:customers) {
			if(c.getCustomerId()==customerId) {
				
				Transaction transaction = session.beginTransaction();
				Query query = session
						.createQuery("update com.revature.pms.model.Customer set " + "customerPassword= '" + customerPassword + "'"
								+" where customerId = " + customerId);
				query.executeUpdate();
				transaction.commit();
				
				
				out.println("<h1>"+customerName + ", password is changed successfuly!");

			}
		}
		
		out.println("<h1><a href=Login.html>Login</a>");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
