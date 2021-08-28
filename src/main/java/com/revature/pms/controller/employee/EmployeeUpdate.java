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
 * Servlet implementation class EmployeeUpdate
 */
public class EmployeeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeUpdate() {
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
		HttpSession session = request.getSession();
		session.setAttribute("editEmployeeById", employeeId);
		
		
		
		
		response.setContentType("text/html");
		out.println("<html><body bgcolor=lightblue align=center>");
		EmployeeService employeeService = new EmployeeServiceImpl();
		result = employeeService.isEmployeeExists(employeeId);

		if (result == true) {
			List<Employee> employeeList = employeeService.getAllEmployees();
			for (Employee e : employeeList) {
				if (e.getEmployeeId() == employeeId) {
					RequestDispatcher dispatcher = request.getRequestDispatcher("EditEmployee.html");
					dispatcher.forward(request, response);

				}
			}

		} else
			out.println("<h3>Employee not exist for given employee Id!");
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
