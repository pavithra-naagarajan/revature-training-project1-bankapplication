

function validateEmployee() {

	var employeeName = document.getElementById("employeeName").value;
	var employeeMobileNumber = document.getElementById("employeeMobileNumber").value;
	var employeeMailId = document.getElementById("employeeMailId").value;
	var employeePassword = document.getElementById("employeePassword").value;
	var confirmPassword = document.getElementById("confirmPassword").value;
	var employeeBalance = document.getElementById("employeeBalance").value;



	if (employeeName.length == 0) {
		alert("Please enter employeeName to proceed further!")
		return false
	}
	else if (employeeMobileNumber.length == 0) {

		alert("Please enter appropriate MobileNumber!")
		return false
	}
	
	else if (employeeMobileNumber.length < 10) {

		alert("Please enter 10 digit MobileNumber!")
		return false
	}
	else if (employeeMailId.length == 0) {

		alert("Please enter appropriate mail Id!")
		return false
	}
	else if (employeePassword.length == 0) {
		alert("Please enter password!")
		return false
	}

	else if (employeePassword.length < 6) {
		alert("Please enter password atleast having 6 characters!")
		return false
	}
	else if (employeePassword.length > 10) {
		alert("Please enter password atmost having 10 characters not more than that!")
		return false
	}


	else if (confirmPassword.length == 0) {
		alert("Please enter confirm password!")
		return false
	}

	else if (employeePassword != confirmPassword) {
		alert("Your password and confirm password are not matched,check it once again!")
		return false
	}
	else if (employeeBalance.length == 0) {
		alert("Please enter appropriate initial balance!")
		return false
	}

	else {
		alert("Employee Account is created!")
		return true
	}
}
