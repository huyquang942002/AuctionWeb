
var button1 = document.getElementById("button1");
button1.style.color = "red";
function display(button){
    var content1 = document.getElementById("content1");
    var content2 = document.getElementById("content2");
    var button1 = document.getElementById("button1");
    var button2 = document.getElementById("button2");
    if(button == 1){
        button1.style.color = "red";
        button2.style.color = "#abb";
        content1.style.display = "";
        content2.style.display = "none";
    }
    if(button == 2){
        button2.style.color = "red";
        button1.style.color = "#abb";
        content1.style.display = "none";
        content2.style.display = "";
    }
}
function openIcon(){
    var iconDiv = document.getElementById("iconDiv");
    iconDiv.style.display = "";
}
function closeIcon(){
    var iconDiv = document.getElementById("iconDiv");
    iconDiv.style.display = "none";
}
function error(error,isAdmin){
	var adminDiv = document.getElementById("adminDiv");
	if(isAdmin == "0"){
		adminDiv.style.display = "";
	}
    if(error == "error"){
        alert("Thay thế hình đại diện không thành công");
    }else if(error == "ok"){
        alert("Đã đổi avatar thành công");
    }
}
function yanzheng(){
    var user_icon = document.getElementById("user_icon").value;
    if(user_icon == ""){
        alert("Vui lòng chọn một hình đại diện để tải lên！");
        return false;
    }
    return true;
}
function modifyUser(){
	var msg = document.getElementById("msg");
	var username = document.getElementById("username").value;
	if(msg.style.display == ""){
		alert("Tên người dùng này đã tồn tại");
		return false;
	}
	if(username == ""){
		alert("Tên người dùng không được để trống");
		return false;
	}
	return true;
}
function registerUserName(){
		var request = new XMLHttpRequest();
		var username = document.getElementById("username").value;
		var msg = document.getElementById("msg");
		var url = "UserNameServlet";
		request.open("POST",url,true);
		request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		request.onreadystatechange=function(){
        if(request.readyState==4&&request.status==200||request.status==0){
        	if(request.responseText == "1"){
        		msg.style.display = "";
        	}else{
        		msg.style.display = "none";
        	}    			
        }
    };
		request.send("username="+username);
}
function diplayModifyName(){
	var userDiv = document.getElementById("userDiv");
	if(userDiv.style.display = "none"){
		userDiv.style.display = "";
	}
}
function closeUser(){
    var userDiv = document.getElementById("userDiv");
    userDiv.style.display = "none";
}

