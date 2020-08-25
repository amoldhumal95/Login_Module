function pass(){
	var p1 = document.frm.pwd.value;
	var p2 = document.frm.pwd1.value;
	if(p1 == "" || p2 == "")
	document.getElementById("msg").innerHTML = "<font color=green size=2px>Password cannot be empty!</font>";
	else if(p1 == p2)
	document.getElementById("msg").innerHTML = "<font color=green size=1px>Password Matched!</font>";
	else
	document.getElementById("msg").innerHTML = "<font color=red size=1px>Check password !!!</font>";
}

