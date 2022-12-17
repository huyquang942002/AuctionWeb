<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Login Success</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script type="text/javascript">
  	var i=5;
  	window.onload=time;
  	function time(){
  		var s = document.getElementById("s");
  		s.innerText = i;
  		i--;
		window.setTimeout('time()', 1000); 
  	}
  </script>
  </head>
  
  <body>
    <div style="width: 100%;height: 100%;position: absolute;">
	    <div style="float: left;width: 100px;height: 100px;margin-top: 10%;margin-left: 30%;">
	    </div>
	    <div style="float: left;margin-top: 13%;text-align: center;">
	    <font size="6" color="#A2A778">Đăng nhập thành công！Sau</font><font size="6" color="red" id="s">5</font><font size="6" color="#A2A778">Chuyển đến trang chủ</font>
	    <br><br><br>
	    <a href="index.jsp" ><font size="4" >Click vào đây để chuyển về trang chủ nhanh</font></a>
	    </div>
    </div>
    <%response.setHeader("refresh","5;URL=index.jsp"); %>
  </body>
  
</html>
