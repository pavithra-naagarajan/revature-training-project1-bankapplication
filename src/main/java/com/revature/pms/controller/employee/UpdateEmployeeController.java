package com.revature.pms.controller.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.model.Employee;
import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.EmployeeServiceImpl;

/**
 * Servlet implementation class UpdateEmployeeController
 */
public class UpdateEmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateEmployeeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		int employeeId=(int) session.getAttribute("editEmployeeById");
		boolean res=false;
		String employeeName = request.getParameter("employeeName");
		String mobileNumber = request.getParameter("employeeMobileNumber");
		String employeeMailId = request.getParameter("employeeMailId");
		String employeePassword = request.getParameter("employeePassword");
		
	
		EmployeeService employeeService=new EmployeeServiceImpl();
		res=employeeService.updateEmployee(employeeId,employeeName,mobileNumber,employeeMailId,employeePassword);
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor=lightblue align=center>");
		out.println("<h1>"+employeeName + ", details are updated successfuly!");
		out.println("<h1><a href=EmployeePage.html>EmployeePage</a>");
	

	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
