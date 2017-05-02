function emailCheck(){
	var email = document.getElementById('email').value;
	var regex = /^([0-9A-Za-z\-_\.]+)@([0-9a-z]+\.[a-z]{2,3}(\.[a-z]{2})?)$/g;
	if (regex.test(email)){
		var user_name = email.replace( regex, "$1" );
		var domain_name = email.replace( regex, "$2" );
		return true;
	}
	else{
		window.alert("您输入的电子邮件地址不合法");
		document.getElementById('email').value="";
		return false;
	}
}