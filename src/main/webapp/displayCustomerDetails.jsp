<%@page import="com.revature.pms.model.Customer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Details</title>
</head>
<body bgcolor="lightblue">
	<h2><center>Customer details</center></h2>
	<%
	List<Customer> customers = (List<Customer>) session.getAttribute("allCustomers");
	%>
	<center><table cellpadding="10" cellspacing="10" border="5"  bordercolor="rgb(201, 76, 76)">
		<th>Customer Id</th>
		<th>Customer Name</th>
		<th>Customer Password</th>
		<th>Email</th>
		<th>Mobile Number</th>
		<th>Registration Date</th>
		<th>Balance</th>
		<th>Delete</th>
		<%
		for (int i = 0; i < customers.size(); i++) {
			Customer customer = customers.get(i);
		%>
		<tr>
			<td><%=customer.getCustomerId()%></td>
			<td><%=customer.getCustomerName()%></td>
			<td><%=customer.getCustomerPassword()%></td>

			<td><%=customer.getCustomerMailId()%></td>
			<td><%=customer.getCustomerMobileNumber()%></td>
			<td><%=customer.getRegistrationDate()%></td>
			<td><%=customer.getCustomerBalance()%></td>

			<td><a
				href="DeleteCustomer?customerId=<%=customer.getCustomerId()%>">Delete</a></td>

		</tr>
		<%
		}
		%>

	</table></center><br><br><br>

	<a href ="EmployeePage.html">Employee Page</a>
</body>
</html>