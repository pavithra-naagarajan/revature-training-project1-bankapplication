package com.revature.pms.dao;

import java.util.List;


import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.revature.pms.model.Customer;
import com.revature.pms.model.Employee;
import com.revature.pms.util.HibernateUtil;

public class CustomerDAOImpl implements CustomerDAO {
	private static Logger logger = Logger.getLogger("CustomerDAOImpl");

	SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
	Session session = sessionFactory.openSession();

	public boolean addCustomer(Customer customer) {
		Transaction transaction = session.beginTransaction();
		session.save(customer);
		transaction.commit();
		return true;
	}

	public boolean updateCustomer(int customerId, String customerName, String customerMobileNumber,
			String customerMailId, String customerPassword) {

		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("update com.revature.pms.model.Customer set "
				+ "customerName= '" + customerName+"'"+" ,customerMobileNumber ="+customerMobileNumber+
				", customerMailId= '"+customerMailId+"'"+" ,customerPassword='"+customerPassword+"'"+
				"where customerId = " + customerId );
		query.executeUpdate();
		transaction.commit();
		return true;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		Transaction transaction = session.beginTransaction();
		Customer customer = getCustomerById(customerId);

		session.delete(customer);
		transaction.commit();
		return true;

	}

	@Override
	public Customer getCustomerById(int customerId) {
		Customer customer = (Customer) session.get(Customer.class, customerId);
		return customer;
	}

	@Override
	public List<Customer> getCustomerByName(String customerName) {
		Query query = session
				.createQuery("from com.revature.pms.model.Customer where customerName='" + customerName + "'");
		return query.list();
	}

	@Override
	public List<Customer> getAllCustomers() {
		Query query = session.createQuery("from com.revature.pms.model.Customer");
		return query.list();
	}

	@Override
	public boolean transferAmountForCustomer(int senderId, int receiverId, int amount) {
		
		Transaction transaction = session.beginTransaction();
		int senderBalance = checkBalanceOfCustomer(senderId);

		senderBalance = senderBalance - amount;
		Query query1 = session.createQuery("update com.revature.pms.model.Customer set customerBalance=" + senderBalance
				+ "where customerId = " + senderId);
		query1.executeUpdate();
		
		int receiverBalance = checkBalanceOfCustomer(receiverId);

		receiverBalance = receiverBalance + amount;
		Query query2 = session.createQuery("update com.revature.pms.model.Customer set customerBalance=" + receiverBalance
				+ "where customerId = " + receiverId);
		query2.executeUpdate();
		transaction.commit();
	

		return true;

	}

	@Override
	// HQL - Hibernate Query Language
	// instead of working on tables and columns in works on POJOS and properties
	public int checkBalanceOfCustomer(int customerId) {
		Query query = session
				.createQuery("select customerBalance from com.revature.pms.model.Customer where customerId = " + customerId);
		int balance = (int) query.list().get(0);
		
		return balance;
		
	

	}

	@Override
	public int withdrawalOfCustomer(int customerId, String customerPassword, int amount) {
		Transaction transaction = session.beginTransaction();
		int balance = checkBalanceOfCustomer(customerId);
		logger.info("The Previous balance for :" + customerId + " is " + balance);
		balance = balance - amount;
		Query query = session.createQuery("update com.revature.pms.model.Customer set customerBalance=" + balance
				+ "where customerId = " + customerId + "and customerPassword= '" + customerPassword + "'");
		query.executeUpdate();
		transaction.commit();
		int finalBalance = checkBalanceOfCustomer(customerId);
		logger.info("The new balance for :" + customerId + " is " + finalBalance);
		return finalBalance;
	}

	@Override
	public int depositOfCustomer(int customerId, String customerPassword, int amount) {
		Transaction transaction = session.beginTransaction();
		int balance = checkBalanceOfCustomer(customerId);
		logger.info("The Previous balance for :" + customerId + " is " + balance);
		balance = balance + amount;
		Query query = session.createQuery("update com.revature.pms.model.Customer set customerBalance=" + balance
				+ "where customerId = " + customerId + "and customerPassword='" + customerPassword + "'");
		query.executeUpdate();
		transaction.commit();
		int finalBalance = checkBalanceOfCustomer(customerId);
		logger.info("The new balance for :" + customerId + " is " + finalBalance);
		return finalBalance;
	}

	@Override
	public boolean isCustomerExists(int customerId) {
		Customer customer = (Customer) session.get(Customer.class, customerId);
		if (customer == null)
			return false;
		else
			return true;
		
		
	}

}
