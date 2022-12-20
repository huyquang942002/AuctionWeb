<%@page import="entity.User"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Add Product</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <link rel="stylesheet" type="text/css" href="css/user.css">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
   
 </head>
<body bgcolor="#efefef" onload="error('<%=request.getParameter("error") %>','<%=((User)session.getAttribute("user"))/* .getLevel() */ %>')">
<div class="top-parent">
    <div class="top-title">
        <div class="top-title-left">
            <a href="<%=path%>/user.jsp">
            <font size="5" color="#5de" class="top-title-text">Quay Lại</font>
            </a>
        </div>
        <div class="top-title-center" style="display: none" id="adminDiv">
        </div>
        <div class="top-title-right">
            <a href="<%=path%>"><font size="5" color="#e56" class="top-title-text">Trang Chủ</font></a>
        </div>
    </div>
</div>
<% if(session.getAttribute("user") != null){ %>
<div class="content-div">
    <div class="content">
        <div class="content-top">
            <div class="content-top-left">
                <div class="content-top-left-icon">
<%--                     <img src="<%=path+"/" %>${user.icon}" width="100%" height="100%" style="border-radius: 50%;"> --%>
                    <img alt="" src="img/name.jpg" width="100%" height="100%" style="border-radius: 50%;">
                </div>
                <div class="content-top-left-right">
                    <div class="content-top-left-right-name">
                        <font size="5" color="#554">TênUser:${user.name }</font>
                    </div>
                    <div class="content-top-left-right-id">
                        <font size="4" color="#554">PID:</font>
                        <font size="4" color="#e33">${user.id }</font>
                    </div>
                </div>
            </div>
        </div>
        <div class="content-center">
            <form action="AddCommodityServlet?userId=${user.id }" method="post" enctype="multipart/form-data" style="margin-top: 20px;">
            Giá khởi điểm：<input name="price" id="inputPrice" onkeyup="value=value.replace(/[^(\d)]/g,'');if(value.length>7)value=value.slice(0,7)"/><br/>
			Giới thiệu：<input name="introduce" id="inputIntroduce" style="width:330px;    width: 330px;margin-left: 26px;margin-top: 10px;" onkeyup="if(value.length>40)value=value.slice(0,40)" /><br/>
			Loại sản phẩm
			<select name="select" style="margin-left: 5px;margin-top: 10px;">
			      <option value="book">Sách</option>
			      <option value="watch">Đồng Hồ</option>
			      <option value="stamp">Thời trang</option>
			      <option value="wine">Rượu</option>
			</select><br/>
                      Chọn hình ảnh：<input type="file" name="uploadFile" id="File" style="width: 75px;"/> <br/><br/>
            <input type="submit" value="Xác nhận đấu giá" onclick=" return SumbitJudge()"/>
            </form>
        </div>
    </div>
</div>
<%}else{%>
    <div>Thông tin đăng nhập của bạn đã hết hạn, vui lòng đăng nhập lại</div>
    <%}%>
   	<br>
<script type="text/javascript">
function SumbitJudge() {
// 	alert("sada");
    var inputPrice=document.getElementById("inputPrice").value;
    var inputIntroduce=document.getElementById("inputIntroduce").value;
	var fileVal=document.getElementById("File").value;
// 	alert(fileVal);
	if (!inputPrice) {
		alert("Vui lòng nhập giá khởi điểm!");
		return false;
	}
	else if (!inputIntroduce) {
		alert("Vui lòng nhập mô tả của cuộc đấu giá!");
		return false;
	}
	else if(!fileVal){
	    alert("Xin vui lòng tải lên một hình ảnh!");
	    return false;
	}
	return true;
}
</script>   	
<script type="text/javascript" src="js/user.js"></script>
</body>
</html>
