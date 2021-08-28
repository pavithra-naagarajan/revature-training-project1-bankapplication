function validateCustomer() {

	var customerName = document.getElementById("customerName").value;
	var customerMobileNumber = document.getElementById("customerMobileNumber").value;
	var customerMailId = document.getElementById("customerMailId").value;
	var customerPassword = document.getElementById("customerPassword").value;
	var confirmPassword = document.getElementById("confirmPassword").value;
	var customerBalance = document.getElementById("customerBalance").value;



	if (customerName.length == 0) {
		alert("Please enter CustomerName to proceed further!")
		return false
	}
	else if (customerMobileNumber.length == 0) {

		alert("Please enter appropriate MobileNumber!")
		return false
	}
	
	else if (customerMobileNumber.length < 10) {

		alert("Please enter 10 digit MobileNumber!")
		return false
	}
	else if (customerMailId.length == 0) {

		alert("Please enter appropriate mail Id!")
		return false
	}
	else if (customerPassword.length == 0) {
		alert("Please enter password!")
		return false
	}

	else if (customerPassword.length < 6) {
		alert("Please enter password atleast having 6 characters!")
		return false
	}
	else if (customerPassword.length > 10) {
		alert("Please enter password atmost having 10 characters not more than that!")
		return false
	}


	else if (confirmPassword.length == 0) {
		alert("Please enter confirm password!")
		return false
	}

	else if (customerPassword != confirmPassword) {
		alert("Your password and confirm password are not matched,check it once again!")
		return false
	}
	else if (customerBalance.length == 0) {
		alert("Please enter appropriate initial balance!")
		return false
	}

	else {
		alert("Customer Account is created!")
		return true
	}
}
