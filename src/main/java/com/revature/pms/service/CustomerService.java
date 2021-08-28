package com.revature.pms.service;

import java.util.List;

import com.revature.pms.model.Customer;

public interface CustomerService {
	
public boolean addCustomer(Customer customer);

public boolean deleteCustomer(int customerId);
public Customer getCustomerById(int customerId);
public List<Customer> getCustomerByName(String customerName);
public List<Customer> getAllCustomers();

public boolean transferAmountForCustomer(int senderId, int receiverId, int amount);
public int checkBalanceOfCustomer(int customerId);
public int withdrawalOfCustomer(int customerId,String customerPassword,int amount);
public int depositOfCustomer(int customerId,String customerPassword,int amount);
public boolean isCustomerExists(int customerId);
public boolean updateCustomer(int customerId, String customerName, String customerMobileNumber, String customerMailId,
		String customerPassword);
}
