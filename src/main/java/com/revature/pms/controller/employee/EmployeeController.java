package com.revature.pms.controller.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.revature.pms.model.Employee;

import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeController
 */
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String employeeName = request.getParameter("employeeName");
		String mobileNumber = request.getParameter("employeeMobileNumber");
		String employeeMailId = request.getParameter("employeeMailId");
		String employeePassword = request.getParameter("employeePassword");
		int balance = Integer.parseInt(request.getParameter("employeeBalance"));
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date dateCreated = new Date();
		String registrationDate = formatter.format(dateCreated);
		
	Employee employee = new Employee(0 , employeeName, mobileNumber, employeeMailId, employeePassword, balance, registrationDate);
		
		EmployeeService employeeService=new EmployeeServiceImpl();
		employeeService.addEmployee(employee);
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor=lightblue align=center>");
		out.println("<h1>"+employeeName + ", congrats you have successfully opened an account in our bank with balance of INR "+balance);
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
