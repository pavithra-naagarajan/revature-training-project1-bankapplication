package com.revature.pms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="customers")

public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int customerId;
	@Column
	private String customerName;
	@Column
	private String customerMobileNumber;
	@Column
	private String customerMailId;
	@Column
	private String customerPassword;
	@Column
	private int customerBalance;
	@Column
	private String registrationDate;
	
	public Customer() {
		
	}
	public Customer(int customerId, String customerName, String customerMobileNumber, String customerMailId,
			String customerPassword, int customerBalance, String registrationDate) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerMobileNumber = customerMobileNumber;
		this.customerMailId = customerMailId;
		this.customerPassword = customerPassword;
		this.customerBalance = customerBalance;
		this.registrationDate = registrationDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerMobileNumber() {
		return customerMobileNumber;
	}
	public void setCustomerMobileNumber(String customerMobileNumber) {
		this.customerMobileNumber = customerMobileNumber;
	}
	public String getCustomerMailId() {
		return customerMailId;
	}
	public void setCustomerMailId(String customerMailId) {
		this.customerMailId = customerMailId;
	}
	public String getCustomerPassword() {
		return customerPassword;
	}
	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}
	public int getCustomerBalance() {
		return customerBalance;
	}
	public void setCustomerBalance(int customerBalance) {
		this.customerBalance = customerBalance;
	}
	public String getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + customerBalance;
		result = prime * result + customerId;
		result = prime * result + ((customerMailId == null) ? 0 : customerMailId.hashCode());
		result = prime * result + ((customerMobileNumber == null) ? 0 : customerMobileNumber.hashCode());
		result = prime * result + ((customerName == null) ? 0 : customerName.hashCode());
		result = prime * result + ((customerPassword == null) ? 0 : customerPassword.hashCode());
		result = prime * result + ((registrationDate == null) ? 0 : registrationDate.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (customerBalance != other.customerBalance)
			return false;
		if (customerId != other.customerId)
			return false;
		if (customerMailId == null) {
			if (other.customerMailId != null)
				return false;
		} else if (!customerMailId.equals(other.customerMailId))
			return false;
		if (customerMobileNumber == null) {
			if (other.customerMobileNumber != null)
				return false;
		} else if (!customerMobileNumber.equals(other.customerMobileNumber))
			return false;
		if (customerName == null) {
			if (other.customerName != null)
				return false;
		} else if (!customerName.equals(other.customerName))
			return false;
		if (customerPassword == null) {
			if (other.customerPassword != null)
				return false;
		} else if (!customerPassword.equals(other.customerPassword))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", customerName=" + customerName + ", customerMobileNumber="
				+ customerMobileNumber + ", customerMailId=" + customerMailId + ", customerPassword=" + customerPassword
				+ ", customerBalance=" + customerBalance + ", registrationDate=" + registrationDate + "]";
	}
	
	
	

	
}
