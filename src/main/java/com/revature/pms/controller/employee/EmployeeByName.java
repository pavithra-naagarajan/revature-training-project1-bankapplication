package com.revature.pms.controller.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;
import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;
import com.revature.pms.service.EmployeeService;
import com.revature.pms.service.EmployeeServiceImpl;

/**
 * Servlet implementation class EmployeeByName
 */
public class EmployeeByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeByName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String employeeName = request.getParameter("employeeName");

		

		PrintWriter out = response.getWriter();

		response.setContentType("text/html");
		out.println("<html><body bgcolor=lightblue align=center>");
		
		EmployeeService employeeService = new EmployeeServiceImpl();
		

		List<Employee> employees = employeeService.getEmployeeByName(employeeName);
		if(employees.size()==0)
			out.println("<h3>Employee not exist for given name!");
		else {

		for (Employee employee : employees) {
			out.println("<h3>Employee Id:" + employee.getEmployeeId());
			out.println("<h3>Employee Name:" + employee.getEmployeeName());
			out.println("<h3>Employee Mobile Number:" + employee.getEmployeeMobileNumber());
			out.println("<h3>Employee Mail Id:" + employee.getEmployeeMailId());
			out.println("<h3>Employee Password:" + employee.getEmployeePassword());
			out.println("<h3>Employee Balance:" + employee.getEmployeeBalance());
			out.println("<h3>Employee registration date:" + employee.getRegistrationDate());
			out.println("<h4>************************************************************");

		}
		}
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
