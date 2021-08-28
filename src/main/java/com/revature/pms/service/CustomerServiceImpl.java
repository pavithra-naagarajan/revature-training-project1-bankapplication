package com.revature.pms.service;

import java.util.List;

import org.apache.log4j.Logger;

import com.revature.pms.dao.CustomerDAO;
import com.revature.pms.dao.CustomerDAOImpl;
import com.revature.pms.model.Customer;

public class CustomerServiceImpl implements CustomerService {
	private static Logger logger = Logger.getLogger("EmployeeDAOImpl");

	CustomerDAO customerDAO=new CustomerDAOImpl();
	@Override
	public boolean addCustomer(Customer customer) {
		return customerDAO.addCustomer(customer);
	}

	@Override
	public boolean updateCustomer(int customerId, String customerName, String customerMobileNumber, String customerMailId,
			String customerPassword) {
		return customerDAO.updateCustomer(customerId,customerName,customerMobileNumber,customerMailId,customerPassword);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		return customerDAO.deleteCustomer(customerId);
	}

	@Override
	public Customer getCustomerById(int customerId) {
		return customerDAO.getCustomerById(customerId);
	}

	@Override
	public List<Customer> getCustomerByName(String customerName) {
		return customerDAO.getCustomerByName(customerName);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerDAO.getAllCustomers();
	}

	@Override
	public boolean transferAmountForCustomer(int senderId, int receiverId, int amount) {
		return customerDAO.transferAmountForCustomer(senderId, receiverId, amount);

	}

	@Override
	public int checkBalanceOfCustomer(int customerId) {
		return customerDAO.checkBalanceOfCustomer(customerId); 
	}

	@Override
	public int withdrawalOfCustomer(int customerId,String customerPassword,int amount) {
		
			return customerDAO.withdrawalOfCustomer(customerId,customerPassword,amount);
		
	
	}
	@Override
	public int depositOfCustomer(int customerId,String customerPassword,int amount){

			return customerDAO.depositOfCustomer(customerId, customerPassword, amount);			
			
	}

	@Override
	public boolean isCustomerExists(int customerId) {
		return customerDAO.isCustomerExists(customerId);
	}

}
