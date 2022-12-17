
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
        alert("头像更换失败");
    }else if(error == "ok"){
        alert("头像更换成功");
    }
}
function yanzheng(){
    var user_icon = document.getElementById("user_icon").value;
    if(user_icon == ""){
        alert("请选择上传的头像！");
        return false;
    }
    return true;
}
function modifyUser(){
	var msg = document.getElementById("msg");
	var username = document.getElementById("username").value;
	if(msg.style.display == ""){
		//用户名已存在，不能修改
		alert("该用户名已存在");
		return false;
	}
	if(username == ""){
		alert("用户名不能为空");
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
        	//alert("后台返回的返回值： "+request.responseText);
        	if(request.responseText == "1"){
        		//用户已存在
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

