package com.revature.pms.service;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.pms.model.Customer;

public class CustomerServiceImplTest {
	CustomerService customerService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		customerService = new CustomerServiceImpl();
	}

	@After
	public void tearDown() throws Exception {
		customerService = null;
	}

	@Test

	public void testAddCustomer() {
		Customer customer = new Customer(122, "Arun", "8867205331", "tufailahmedkhan@gmail.com", "neha@123", 5000,
				"2020-02-12");
		assertEquals(true, customerService.addCustomer(customer));

	}

	@Test
	public void testDeleteCustomer() {
		Customer customer = new Customer(122, "Arun", "8867205331", "tufailahmedkhan@gmail.com", "neha@123", 5000,
				"2020-02-12");
		customerService.addCustomer(customer);
		assertEquals(true, customerService.deleteCustomer(122));
	}

	@Test
	public void testGetCustomerById() {

		Customer customer = new Customer(122, "Arun", "8867205331", "tufailahmedkhan@gmail.com", "neha@123", 5000,
				"2020-02-12");
		customerService.addCustomer(customer);
		Customer customer1 = (Customer) customerService.getCustomerById(122);
		assertEquals(customer, customer1);
	}

	@Test
	public void testGetCustomerByName() {
		Customer customer = new Customer(122, "Arun", "8867205331", "tufailahmedkhan@gmail.com", "neha@123", 5000,
				"2020-02-12");
		customerService.addCustomer(customer);
		Customer customer1 = (Customer) customerService.getCustomerByName("Arun");
		assertEquals(customer, customer1);
	}

	@Test
	public void testGetAllCustomers() {
		fail("Not yet implemented");
	}

	@Test
	public void testTransferAmountForCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckBalanceOfCustomer() {
		Customer customer = new Customer(122, "Arun", "8867205331", "tufailahmedkhan@gmail.com", "neha@123", 5000,
				"2020-02-12");
		customerService.addCustomer(customer);
		assertEquals(5000, customerService.checkBalanceOfCustomer(122));
	}

	@Test
	public void testWithdrawalOfCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testDepositOfCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsCustomerExists() {
		Customer customer = new Customer(122, "Arun", "8867205331", "tufailahmedkhan@gmail.com", "neha@123", 5000,
				"2020-02-12");
		customerService.addCustomer(customer);
		assertEquals(true, customerService.isCustomerExists(122));
	}

}
