<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>Password User</title>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/modifyUser.css">
</head>
<body onload="yuanPasswordIsOk('<%=request.getParameter("error")%>')">
<div class="parent">
    <div style="width: 100%;height: 80px;"></div>
    <div class="content">
    <form method="post" action="<%=path%>/AlterUserServlet"  onsubmit="return yanzheng()">
    <div>
        <div style="width: 100%;height: 30px;"></div>
        <div class="div-title"><font size="5">Nhập mật khẩu cũ</font></div>
        <div class="div-title">
            <div class="news-title">
                <input type="text" class="form-control" placeholder="Mật khẩu cũ" id="yuanpassword" name="yuanpassword">
            </div>
        </div>
    </div>
    <div>
        <div style="width: 100%;height: 30px;"></div>
        <div class="div-title"><font size="5">Nhập mật khẩu mới</font></div>
        <div class="div-title">
            <div class="news-title">
                <input type="text" class="form-control" placeholder="Mật khẩu mới" id="newpassword" name="newpassword">
            </div>
        </div>
    </div>
    <div>
        <div style="width: 100%;height: 30px;"></div>
        <div class="div-title"><font size="5">Xác nhận mật khẩu mới</font></div>
        <div class="div-title">
            <div class="news-title">
                <input type="text" class="form-control" placeholder="Nhập lại mật khẩu mới" id="password" name="password">
            </div>
        </div>
    </div>
    <input type="hidden" name="user_id" value="<%=request.getParameter("user_id")%>">
    <input type="hidden" name="modify" value="password">
    <div>
        <div style="width: 100%;height: 50px;"></div>
        <div class="div-title">
            <div class="news-title" style="margin-bottom: 20px;">
                <button type="submit" class="btn btn-info">Thay đổi</button>
            </div>
        </div>
    </div>
    </form>
    </div>
</div>
<script type="text/javascript" src="js/modifyUser.js"></script>
</body>
</html>