package com.revature.pms.controller.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;
import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.EmployeeServiceImpl;

/**
 * Servlet implementation class AuthenticateEmployee
 */
public class AuthenticateEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthenticateEmployee() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String employeeName = request.getParameter("username");
		String password = request.getParameter("password");
		int employeeId=0;
		EmployeeService employeeService = new EmployeeServiceImpl();
		List<Employee> employeeList = employeeService.getAllEmployees();
		
		for(Employee e:employeeList) {
			if(e.getEmployeeName().equals(employeeName) &&e.getEmployeePassword().equals(password))
				employeeId=e.getEmployeeId();
		}
		HttpSession session = request.getSession();
		session.setAttribute("employeeName", employeeName);
		session.setAttribute("employeePassword", password);
		session.setAttribute("employeeId", employeeId);


		int flag = 0;
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor=lightblue align=center >");

		for (Employee e : employeeList) {
			if (e.getEmployeeName().equals(employeeName)) {
				if (e.getEmployeePassword().equals(password)) {
					flag = 1;
					break;
				}
			} else
				flag = 0;
		}
		if (flag == 1) {
			out.println("<h3>You have logged in at : " + new java.util.Date());
			/*
			 * out.println("<br>Your name is : " + employeeName);
			 * out.println("<br>Your password is : " + password);
			 */

			out.println("<br/><br/><a href=EmployeePage.html>Employee Page</a>");
		} else {
			out.println("<br><h3>Your login details are not matched!Try again");
			out.println("<br/><br/><a href=Login.html>Login Again</a>");

		}
		boolean alreadyVisited = false;
		Cookie allCookies[] = request.getCookies();

		if (allCookies == null) {

		} else {
			for (Cookie c : allCookies) {
				if (c.getName().equals(employeeName)) {
					alreadyVisited = true;
					break;
				}
			}
		}

		if (alreadyVisited) {
			out.println("<h3>Your have already visited my website : " + employeeName);

		} else {
			out.println("<h3>You are first time visitor " + employeeName);
			Cookie c = new Cookie(employeeName, employeeName);
			c.setMaxAge(1000 * 60 * 60 * 24 * 30);
			response.addCookie(c);
		}

		out.println("</body></html>");
	}

}
