<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String error = request.getParameter("register");
if(error == null){
	error = "";
}
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>Đăng ký người dùng</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <script src="js/jquery.js"></script>
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/iconfont.css">
    <link rel="stylesheet" href="css/reg.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
    <script src="js/jquery.validate.js"></script>
    <script src="js/jquery.validate.min.js"></script>
</head>
<body onload="registerError()">
    
    <div class="wrap" style="background: url(img/background.jpg) no-repeat center;">
        <div class="wpn">
            <div class="form-data pos">
                <a href="index.jsp"><img src="img/logo.png" class="head-logo"></a>
                <!--<p class="tel-warn hide"><i class="icon-warn"></i></p>-->
                <form action="RegisterServlet" method="post" id="myform">
                    <p class="p-input pos">
                        <label for="tel">tên tài khoản</label>
                        <input type="text" id="username" autocomplete="off" name="username" onchange="registerUserName()">
                        <span class="tel-warn tel-err" style="display:none;" id="msg"><em>tên đăng kí đã được sử dụng</em><i class="icon-warn"></i></span>
                        <span class="tel-warn tel-err "><font id="name_error"></font></span>
                    </p>
                    <p class="p-input pos " id="pass">
                        <label for="passport">nhập mật khẩu</label>
                        <input type="password" id="pass1" name="password">
                        <span class="tel-warn pwd-err hide"><em></em><i class="icon-warn" style="margin-left: 5px"></i></span>
                    </p>
                    <p class="p-input pos " id="confirmpwd">
                        <label for="passport2">Xác nhận mật khẩu</label>
                        <input type="password" id="pass2" name="newpassword">
                        <span class="tel-warn confirmpwd-err hide"><em></em><i class="icon-warn" style="margin-left: 5px"></i></span>
                        <span class="tel-warn tel-err "><font id="pass_error"></font></span>
                    </p>
                    <button class="lang-btn" id="submit" type="submit">Đăng ký</button>
                </form>
                <div class="bottom-info">Bạn đã có tài khoản ?<a href="login.jsp">Đăng nhập ngay bây giờ</a></div>
                <p class="right"> by © 2019</p>
            </div>
        </div>
    </div>
    
    <script src="js/agree.js"></script>
<!--     <script src="js/reg.js"></script> -->
    <script type="text/javascript">
    
//     $.validator.setDefaults({
// 		    submitHandler: function() {
// // 		      alert("提交事件!");
// 		    }
// 		});
		function format() {
		// 在键盘按下并释放及提交后验证提交表单
		  $("#myform").validate({
			    rules: {
			     
			    	username: {
				        required: true,
				        minlength: 2,
				        maxlength:5
				      },
			    	
			    	password: {
			        required: true,
			        minlength: 5,
			        maxlength:10
			      }
			 
			    },
			    messages: {
			    
			    	password: {
			        required: "请输入密码",
			        minlength: "密码长度不能小于 5 位",
			        maxlength:"密码长度不能大于10位"
			      },
			      username: {
				        required: "请用户名",
				        minlength: "用户名长度不能小于 1 位",
				        maxlength:"用户名长度不能大于5位"
				      }
			  
			    }
			});
		};
    
    //js异步请求验证用户名的api（UserNameServlet）
 		function registerUserName(){
 				var request = new XMLHttpRequest();
 				var username = document.getElementById("username").value;
 				var msg = document.getElementById("msg");
 				var url = "UserNameServlet";
 				request.open("POST",url,true);
 				request.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
 				request.onreadystatechange=function(){
		        	//获取返回的验证码
		        	if(request.readyState==4&&request.status==200||request.status==0){
// 		        		alert("后台返回的返回值： "+request.responseText);
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
        format();
    	var submitBtn = document.getElementById("submit");
 		submitBtn.onclick = function (event) {
 		
	 		var name=document.getElementById("username").value;
	    	var name_error=document.getElementById("name_error").innerText;
	    	var pass1=document.getElementById("pass1").value;
	    	var pass2=document.getElementById("pass2").value;
	    	var pass_error=document.getElementById("pass_error").innerText;
	    	var msg = document.getElementById("msg");
	    	if(msg.style.display == ""){
	    		alert("tên đăng kí đã được sử dụng");
	    		return false;
	    	}
  			if(name==""||pass1==""&&pass1==""||name==""){
    			alert("Tên người dùng hoặc mật khẩu không được để trống");
    			name_error = "Tên người dùng hoặc mật khẩu không được để trống";
    			
    		}else if(pass1 != pass2){
    			alert("hai mật khẩu khác nhau");
    			pass_error = "hai mật khẩu khác nhau";
    			
    		}else{
    			
    			return true;
    		}
    		return false;
 		};
 		
    </script>
</body>
</html>