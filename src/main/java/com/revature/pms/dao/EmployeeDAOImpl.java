package com.revature.pms.dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;

import com.revature.pms.service.CustomerService;
import com.revature.pms.service.CustomerServiceImpl;
import com.revature.pms.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	private static Logger logger = Logger.getLogger("EmployeeDAOImpl");

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();

	@Override
	public boolean addEmployee(Employee employee) {
		Transaction transaction = session.beginTransaction();
		session.save(employee);
		transaction.commit();
		return true;
	}

	@Override
	public boolean updateEmployee(int employeeId, String employeeName, String mobileNumber, String employeeMailId,
			String employeePassword) {

		Transaction transaction = session.beginTransaction();
		Query query = session
				.createQuery("update com.revature.pms.model.Employee set " + "employeeName= '" + employeeName + "'"
						+ " ,employeeMobileNumber =" + mobileNumber + ", employeeMailId= '" + employeeMailId + "'"
						+ " ,employeePassword='" + employeePassword + "'" + "where employeeId = " + employeeId);
		query.executeUpdate();
		transaction.commit();
		return true;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		Transaction transaction = session.beginTransaction();
		Employee employee = getEmployeeById(employeeId);

		session.delete(employee);
		transaction.commit();
		return true;

	}

	@Override
	public Employee getEmployeeById(int employeeId) {
		Employee employee = (Employee) session.load(Employee.class, employeeId);
		return employee;
	}

	@Override
	public List<Employee> getEmployeeByName(String employeeName) {
		Query query = session
				.createQuery("from com.revature.pms.model.Employee where employeeName='" + employeeName + "'");
		return query.list();
	}

	@Override
	public List<Employee> getAllEmployees() {
		Query query = session.createQuery("from com.revature.pms.model.Employee");
		return query.list();
	}

	public boolean isEmployeeExists(int employeeId) {
		Employee employee = (Employee) session.get(Employee.class, employeeId);
		if (employee == null)
			return false;
		else
			return true;
	}

	@Override
	public int withdrawalOfEmployee(int employeeId, String employeePassword, int amount) {
		Transaction transaction = session.beginTransaction();
		int balance = checkBalanceOfEmployee(employeeId);

		logger.info("The Previous balance for :"+employeeId + " is "+balance);
		balance = balance - amount;
		Query query = session.createQuery("update com.revature.pms.model.Employee set employeeBalance=" + balance
				+ "where employeeId = " + employeeId + "and employeePassword='" + employeePassword + "'");
		query.executeUpdate();
		transaction.commit();
		int finalBalance = checkBalanceOfEmployee(employeeId);
		logger.info("The new balance for :" + employeeId + " is " + finalBalance);
		return finalBalance;
	}

	@Override
	public boolean transferAmountForEmployee(int senderId, int receiverId, int amount) {
		Transaction transaction = session.beginTransaction();
		int senderBalance = checkBalanceOfEmployee(senderId);

		senderBalance = senderBalance - amount;
		Query query1 = session.createQuery("update com.revature.pms.model.Employee set employeeBalance=" + senderBalance
				+ "where employeeId = " + senderId);
		query1.executeUpdate();
		
		int receiverBalance = checkBalanceOfEmployee(receiverId);

		receiverBalance = receiverBalance + amount;
		Query query2 = session.createQuery("update com.revature.pms.model.Employee set employeeBalance=" + receiverBalance
				+ "where employeeId = " + receiverId);
		query2.executeUpdate();
		transaction.commit();
	

		return true;

	}

	@Override
	public int depositOfEmployee(int employeeId, String employeePassword, int amount) {
		Transaction transaction = session.beginTransaction();
		int balance = checkBalanceOfEmployee(employeeId);
		logger.info("The Previous balance for :" + employeeId + " is " + balance);
		balance = balance + amount;
		Query query = session.createQuery("update com.revature.pms.model.Employee set employeeBalance=" + balance
				+ "where employeeId = " + employeeId + "and employeePassword='" + employeePassword + "'");
		query.executeUpdate();
		transaction.commit();
		int finalBalance = checkBalanceOfEmployee(employeeId);
		logger.info("The new balance for :" + employeeId + " is " + finalBalance);
		return finalBalance;
	}

	@Override
	// Employee Approval
	public boolean employeeApproval(Customer customer) {

		int balance = customer.getCustomerBalance();
		if (balance < 5000)
			return false;
		else
			return true;

	}

	@Override
	public int checkBalanceOfEmployee(int employeeId) {
		Query query = session.createQuery(
				"select employeeBalance from com.revature.pms.model.Employee where employeeId =" + employeeId);

		int balance = (int) query.list().get(0);

		return balance;

	}

}
