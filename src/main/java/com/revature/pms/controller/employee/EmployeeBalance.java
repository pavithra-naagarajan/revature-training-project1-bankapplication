package com.revature.pms.controller.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pms.model.Employee;
import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeBalance
 */
public class EmployeeBalance extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeBalance() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		

		int employeeId = Integer.parseInt(request.getParameter("employeeId"));
	
		
		boolean result=false;
		
		
		
		response.setContentType("text/html");
		out.println("<html><body bgcolor=lightblue align=center>");
		EmployeeService employeeService = new EmployeeServiceImpl();
		result=employeeService.isEmployeeExists(employeeId);
		if(result==true) {
			
			int balance=employeeService.checkBalanceOfEmployee(employeeId);
			out.println("<h3>The balance for :"+employeeId + " is "+balance);
			
			
		}
		else
			out.println("<h3>Employee not exist for given employee Id!");
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
