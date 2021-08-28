package com.revature.pms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "employees")


public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	@Column
	private String employeeName;
	@Column
	private String employeeMobileNumber;
	@Column
	private String employeeMailId;
	@Column
	private String employeePassword;
	@Column
	private int employeeBalance;
	@Column
	private String registrationDate;

	public Employee() {

	}
	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeMobileNumber() {
		return employeeMobileNumber;
	}

	public void setEmployeeMobileNumber(String employeeMobileNumber) {
		this.employeeMobileNumber = employeeMobileNumber;
	}

	public String getEmployeeMailId() {
		return employeeMailId;
	}

	public void setEmployeeMailId(String employeeMailId) {
		this.employeeMailId = employeeMailId;
	}

	public String getEmployeePassword() {
		return employeePassword;
	}

	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}

	public int getEmployeeBalance() {
		return employeeBalance;
	}

	public void setEmployeeBalance(int employeeBalance) {
		this.employeeBalance = employeeBalance;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", employeeMobileNumber="
				+ employeeMobileNumber + ", employeeMailId=" + employeeMailId + ", employeePassword=" + employeePassword
				+ ", employeeBalance=" + employeeBalance + ", registrationDate=" + registrationDate + "]";
	}

	public Employee(int employeeId, String employeeName, String employeeMobileNumber, String employeeMailId,
			String employeePassword, int employeeBalance, String registrationDate) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeMobileNumber = employeeMobileNumber;
		this.employeeMailId = employeeMailId;
		this.employeePassword = employeePassword;
		this.employeeBalance = employeeBalance;
		this.registrationDate = registrationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeBalance;
		result = prime * result + employeeId;
		result = prime * result + ((employeeMailId == null) ? 0 : employeeMailId.hashCode());
		result = prime * result + ((employeeMobileNumber == null) ? 0 : employeeMobileNumber.hashCode());
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + ((employeePassword == null) ? 0 : employeePassword.hashCode());
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
		Employee other = (Employee) obj;
		if (employeeBalance != other.employeeBalance)
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (employeeMailId == null) {
			if (other.employeeMailId != null)
				return false;
		} else if (!employeeMailId.equals(other.employeeMailId))
			return false;
		if (employeeMobileNumber == null) {
			if (other.employeeMobileNumber != null)
				return false;
		} else if (!employeeMobileNumber.equals(other.employeeMobileNumber))
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (employeePassword == null) {
			if (other.employeePassword != null)
				return false;
		} else if (!employeePassword.equals(other.employeePassword))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		return true;
	}

}
