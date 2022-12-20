<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String error = request.getParameter("login");
if(error == null){
	error = "";
}
%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>User login</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <link rel="stylesheet" href="css/base.css">
    <link rel="stylesheet" href="css/iconfont.css">
    <link rel="stylesheet" href="css/reg.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    	var error = "<%=error%>";
    	function errorLogin(){

	    	if(error == "error"){
	    		alert("Tên người dùng hoặc mật khẩu bị sai, vui lòng đăng nhập lại!");
    		}
    	
    	}
    </script>
</head>
<body onload="errorLogin()">
<div id="ajax-hook"></div>
<div class="wrap" style="background: url(img/background1.jpg) no-repeat center;">
    <div class="wpn">
        <div class="form-data pos">
            <a href="index.jsp"><img src="img/logo.png" class="head-logo"></a>
            <div class="change-login">
                <p class="account_number on">Đăng Nhập</p>
<!--                 <p class="message">SMS login</p> -->
            </div>
            <form action="LoginServlet" method="post">
            <div class="form1">
                <p class="p-input pos">
                    <label for="num">Username</label>
                    <input type="text" id="num" name="username">
                    <span class="tel-warn num-err hide"><em>Account or password error, please re-enter</em><i class="icon-warn"></i></span>
                </p>
                <p class="p-input pos">
                    <label for="pass">please enter password</label>
                    <input type="password" style="display:none"/>
                    <input type="password" id="pass" autocomplete="new-password" name="password"/>
                    <span class="tel-warn pass-err hide"><em>Account or password error, please re-enter</em><i class="icon-warn"></i></span>
                </p>
            </div>
            <div class="r-forget cl">
                <a href="register.jsp" class="z">Register an account</a>
<!--                 <a href="./getpass.jsp" class="y">Forgot password</a> -->
            </div>
            <button class="lang-btn off log-btn">Đăng Nhập</button>
            
            </form>
            <p class="right">online auction system by © 2022</p>
        </div>
    </div>
</div>
<script src="js/jquery.js"></script>
<script src="js/agree.js"></script>
<script src="js/login.js"></script>
</body>
</html>
