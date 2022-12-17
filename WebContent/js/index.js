function myAuction(session_user){
    var user = session_user;
    if(user != "null"){
    	alert("Vui lòng đăng nhập！");
		return false;
    }
	return true;
}