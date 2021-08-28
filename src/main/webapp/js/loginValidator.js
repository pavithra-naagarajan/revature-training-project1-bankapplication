function validate() {
	var username = document.getElementById("username").value;
	var password = document.getElementById("password").value;
	if (username.length == 0) {
		alert("please enter userName to proceed further!")
		return false
	}
	else if (password.length == 0) {
		alert("please enter password")
		return false
	}
	else if (password.length > 0) {
		if (password.length < 6) {
			alert("please enter password atleast having 6 characters!")
			return false
		}
		else if (password.length > 10) {
			alert("please enter password atmost having 10 characters not more than that!")
			return false
		}
	
	else {
		alert("Welcome : " + username)
		return true
	}

}
}