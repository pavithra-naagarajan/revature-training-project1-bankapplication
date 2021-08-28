package com.revature.pms.controller.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.model.Employee;
import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeWithdraw
 */
public class EmployeeWithdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeWithdraw() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		int employeeId=(int) session.getAttribute("employeeId");
		String employeePassword= (String) session.getAttribute("employeePassword");
		//int employeeId = Integer.parseInt(request.getParameter("employeeId"));
		int employeeAmount = Integer.parseInt(request.getParameter("amount"));
		//String employeePassword = request.getParameter("employeePassword");
		boolean result = false;

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		out.println("<html><body bgcolor=lightblue align=center>");
		EmployeeService employeeService = new EmployeeServiceImpl();
		result = employeeService.isEmployeeExists(employeeId);

		int balance = employeeService.checkBalanceOfEmployee(employeeId);
		if (result == true) {
			if (employeeAmount < 0)
				out.println("<h3>You cannot withdraw negative amount!");
			else if (balance > employeeAmount && employeeAmount >0) {
				balance = employeeService.withdrawalOfEmployee(employeeId, employeePassword, employeeAmount);
				out.println("<h3>Amount is withdrawn successfully!");
				out.println("<h3>After withdrawal the balance is :" + balance);
			}
			if (balance < employeeAmount)
				out.println("your balance is insufficient to make withdraw!");

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
