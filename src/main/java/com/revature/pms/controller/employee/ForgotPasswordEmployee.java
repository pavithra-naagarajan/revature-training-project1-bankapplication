package com.revature.pms.controller.employee;

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

import com.revature.pms.model.Employee;
import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.EmployeeServiceImpl;
import com.revature.pms.util.HibernateUtil;

/**
 * Servlet implementation class ForgotPasswordEmployee
 */
public class ForgotPasswordEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPasswordEmployee() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int employeeId=Integer.parseInt(request.getParameter("userId"));
		String employeeName = request.getParameter("username");
		String employeePassword = request.getParameter("password");
		
		
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor=lightblue align=center>");
		EmployeeService employeeService=new EmployeeServiceImpl();
		List<Employee> employees=employeeService.getAllEmployees();
		for(Employee e:employees) {
			if(e.getEmployeeId()==employeeId) {
				
				Transaction transaction = session.beginTransaction();
				Query query = session
						.createQuery("update com.revature.pms.model.Employee set " + "employeePassword= '" + employeePassword + "'"
								+"where employeeId = " + employeeId);
				query.executeUpdate();
				transaction.commit();
				
				
				out.println("<h1>"+employeeName + ", password is changed successfuly!");

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
