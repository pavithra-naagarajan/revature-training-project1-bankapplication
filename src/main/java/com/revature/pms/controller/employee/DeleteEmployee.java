package com.revature.pms.controller.employee;

import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.model.Employee;

import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.EmployeeServiceImpl;

/**
 * Servlet implementation class DeleteEmployee
 */
public class DeleteEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int employeeId = Integer.parseInt(request.getParameter("employeeId"));

		boolean result = false;

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		out.println("<html><body bgcolor=lightblue align=center>");
		EmployeeService employeeService = new EmployeeServiceImpl();
		result = employeeService.isEmployeeExists(employeeId);

		if (result == true) {

			employeeService.deleteEmployee(employeeId);
			out.println("<h3>Employee with employeeId :" + employeeId + " is  deleted successfully!");

			
		} else {
			out.println("<h3>Employee not exist for given Employee Id!");

			out.println("<h3>Employee with employeeId :" + employeeId + " is not deleted successfully!");
		}
		out.println("<br><br><br><a href=EmployeePage.html>Employee Personal Page</a>");

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
