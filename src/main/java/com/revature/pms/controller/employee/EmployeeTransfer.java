package com.revature.pms.controller.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeTransfer
 */
public class EmployeeTransfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int senderId = Integer.parseInt(request.getParameter("senderId"));
		int receiverId = Integer.parseInt(request.getParameter("receiverId"));
		int amount = Integer.parseInt(request.getParameter("amount"));
		PrintWriter out = response.getWriter();
		boolean result = false;
		response.setContentType("text/html");
		out.println("<html><body bgcolor=lightblue align=center>");
		EmployeeService employeeService = new EmployeeServiceImpl();
		result = employeeService.transferAmountForEmployee(senderId, receiverId, amount);
		if (result == true) {
			out.println("<h3>Amount is successfully transferred!");
			int debitorBalance = employeeService.checkBalanceOfEmployee(senderId);
			int creditorBalance = employeeService.checkBalanceOfEmployee(receiverId);
			out.println("<h3>The Debitor Balance after transfer of " + amount + " is " + debitorBalance);
			out.println("<h3>The Creditor Balance after transfer of " + amount + " is " + creditorBalance);
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
