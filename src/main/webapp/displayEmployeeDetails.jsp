<%@page import="com.revature.pms.model.Employee"%>
<%@page import="com.revature.pms.controller.employee.DeleteEmployee"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee details</title>
</head>
<body bgcolor="lightblue">
	<h2><center>Employee details</center></h2>
	<%
	List<Employee> employees = (List<Employee>) session.getAttribute("allEmployees");
	%>
	<center><table cellpadding="10" cellspacing="10" border="5"  bordercolor="rgb(201, 76, 76)">
		<th>Employee Id</th>
		<th>Employee Name</th>
		<th>Password</th>
		<th>Email</th>
		<th>Mobile Number</th>
		<th>Registration Date</th>
		<th>Balance</th>
		
		<%
		for (int i = 0; i < employees.size(); i++) {
			Employee employee = employees.get(i);
		%>
		<tr>
			<td><%=employee.getEmployeeId()%></td>
			<td><%=employee.getEmployeeName()%></td>
			<td><%=employee.getEmployeePassword()%></td>
			<td><%=employee.getEmployeeMailId() %></td>
			<td><%=employee.getEmployeeMobileNumber()%></td>
			<td><%=employee.getRegistrationDate()%></td>
			<td><%=employee.getEmployeeBalance()%></td>
			
			

		</tr>
		<%
		}
		%>

	</table></center>

	<br><br><br>
	<a href ="EmployeePage.html">Employee Page</a>
</body>
</html>