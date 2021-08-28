function validator() {
var password = document.getElementById("password").value;
var confirmPassword = document.getElementById("confirmPassword").value;
if (password != confirmPassword) {
	alert("Your password and confirm password are not matched,check it once again!")
	return false
}
else{
	alert("successfully changed!")
	return true}
}