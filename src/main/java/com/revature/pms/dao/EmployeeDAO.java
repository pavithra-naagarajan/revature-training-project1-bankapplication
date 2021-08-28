package com.revature.pms.dao;

import java.util.List;

import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;

public interface EmployeeDAO {
	public boolean addEmployee(Employee employee);
	
	public boolean deleteEmployee(int employeeId);
	public Employee getEmployeeById(int employeeId);
	public List<Employee>  getEmployeeByName(String employeeName);
	public List<Employee> getAllEmployees();
	public boolean isEmployeeExists(int employeeId);
	
	public int withdrawalOfEmployee(int employeeId,String employeePassword,int amount) ;
	public boolean transferAmountForEmployee(int senderId, int receiverId, int amount);
	public int depositOfEmployee(int employeeId,String employeePassword,int amount)  ;
	public boolean employeeApproval(Customer customer);
	public int checkBalanceOfEmployee(int employeeId);
	public boolean updateEmployee(int employeeId, String employeeName, String mobileNumber, String employeeMailId,
			String employeePassword);
}
