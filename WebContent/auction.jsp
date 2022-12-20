<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="entity.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
if(session.getAttribute("user")==null){
	response.sendRedirect("login.jsp");
}else{
%>

<html>
<head>
<title>Auction Web</title>
</head>
<body bgcolor="#f9f9f9">
<div><a href="<%=path%>"><font size="+2">Trang chủ</a></font> </div><br>
<br><br>
<div style="width: 60%; height: 5%; text-align: center;">         
<font size="5">Thời gian đấu giá còn lại: </font><font size="6" color="red" id="time"></font>
</div><br><br>
<div style="margin:0 auto; width: 60%;height: 55%; background-color: rgb(255,255,255);">
<div style="float: left; width:25%; height:100%; margin: 50 60;">
			<style type="text/css">
			div img{
				cursor: pointer;
				transition: all 0.1s;
			}
			div img:hover{
				transform: scale(1.2);
			}
			</style>
<img src="<%=path%>/${commodity.picture}" style="width: 200px;height: 200px;"> <br><br><br>
<font size="+1">Loại: ${commodity.type}</font><br><br><br>
<font size="+1" color="#000000">Người Bán:${user.name}</font><br><br>
</div>
<div style="float: left; width:40%; height:80%; margin: 50 60;">
<font size="" color="#000000">Tên:   ${commodity.introduce}</font><br><br><br>
Bắt đầu:   ${commodity.date}<br><br>
Giá khởi điểm:   $:  ${commodity.price}<br><br><br>
Giá cao nhất hiện tại: $:  ${commodity.maxPrice}<br><br><br>
Người trả giá cao nhất id:   ${commodity.winnerId}<br><br>
</div>
</div>
<div style="margin:0 auto; width: 60%;height: 20%; background-color: #FdFdFd;">
<div style="margin:0 auto; float:left; margin-right: 20%;">
 <form action="" method="post" onsubmit="return auction()">
 	<input type="hidden" name="user_id" value="${user.id}">
	<input type="hidden" name="goods_id" value="${commodity.id}">
	<input type="hidden" name="type" value="${commodity.type}">
	
	<%if(session.getAttribute("user") == null){ %>
		<input type="hidden" name="winner_id" value="error" id="winner_id" >
	<%}else{ %>
		<input type="hidden" name="winner_id" value="<%=((User)session.getAttribute("user")).getId()%>" id="winner_id">
	<%} %>
Nhập giá：<input type="text" name="max_price" id="price" style="border-bottom:1 solid black;background:;" onkeyup="value=value.replace(/[^(\d)]/g,'');if(value.length>7)value=value.slice(0,7)"> <input type="submit" value="Đấu giá" id="submit">

</form>
</div>
<div style="text-align:center; float:left; margin-right: 20%;">
</div>
</div>
<script type="text/javascript">
function auction() {
	
	var type = "<%=request.getAttribute("type")%>";
	var maxPrice ="<%=request.getAttribute("maxPrice")%>";
// 	alert("type:"+type);
	var price = "<%=request.getAttribute("price")%>";
//  	alert("price:"+price);
//  	alert("maxPrice:"+maxPrice);
	var session = document.getElementById("winner_id").value;
// 	var max_price = parseFloat(document.getElementById("price").value);
	var max_price1 = document.getElementById("price").value;
	if (max_price1=="") {
		alert("Giá thầu không được để trống!");
	    return false;
	}
	var max_price=parseFloat(document.getElementById("price").value);
	var ss=max_price <= maxPrice;
	var cs=max_price <= price;

	if(session == "error") {
		alert("vui lòng đăng nhập trước!");
		return false;
	} 
	else if(type=="book") {
		if(ss){
			alert("Giá đấu thầu không được thấp hơn hoặc bằng giá gốc!");
			return false;
		}
		if(cs) {
			alert("Giá đấu thầu không được thấp hơn hoặc bằng giá khởi điểm!")
			return false;
		}
// 		alert("book");
		return true;
	} 
	else if(type == "watch") {
		if(ss) {
			alert("Giá đấu thầu không được thấp hơn hoặc bằng giá gốc!");
			return false;
		}
		if(cs) {
			alert("Giá đấu thầu không được thấp hơn hoặc bằng giá khởi điểm!")
			return false;
		}
// 		alert("watch");
		return true;
	}
	else if(type == "stamp") {
		if(ss) {
			alert("Giá đấu thầu không được thấp hơn hoặc bằng giá gốc!");
			return false;
		}
		if(cs) {
			alert("Giá đấu thầu không được thấp hơn hoặc bằng giá khởi điểm!")
			return false;
		}
// 		alert("stamp");
		return true;
	}
	else if(type == "wine") {
		if(ss) {
			alert("Giá đấu thầu không được thấp hơn hoặc bằng giá gốc!");
			return false;
		}
		if(cs) {
			alert("Giá đấu thầu không được thấp hơn hoặc bằng giá khởi điểm!")
			return false;
		}
		return true;
	}
	return false;
}	
	window.onload=timer;
	function timer(){
		var date = document.getElementById("time");
		var submit = document.getElementById("submit");
		var button = document.getElementById("endprice");
		var second = "<%=request.getAttribute("time")%>";
		var time=second;
		if(time<=0){
			submit.value = "Đấu giá";
			submit.disabled=true;
			button.disabled=true;
			date.innerHTML = "Mặt hàng này đã được bán đấu giá";
		}else{

//                 alert(time);
                var ss=time/1000;
				var seconds = parseInt(ss % 60);
				var minutes = parseInt((ss - seconds) / 60 % 60);
				var hours = parseInt(((ss-seconds)/60-minutes)/60%24);
				var days = parseInt((((ss-seconds)/60-minutes)/60-hours) / 24);
				var interval = setInterval(function(){
					time = days+":"+hours+":"+minutes +":"+seconds;
					date.innerHTML = time;
					seconds--;
					if(seconds <=0){
						if(minutes<=0){
							if(hours<=0){
								if(days<=0){
									submit.disabled=true;
									button.disabled=true;
									days=0;hours=0;minute=0;seconds=0;
									alert("đấu giá đã kết thúc");
									submit.value = "Đấu giá";
									clearInterval(interval);
									bid();
								}
								days--;
								hours=24;
							}
							hours--;
							minutes=60;
						}
						minutes--;
						seconds=59;
					}
					
				},1000);
			}
          function bid(){
        	var type = "<%=request.getAttribute("type")%>";
         	var url = "AddOrderServlet";
         	var request = new XMLHttpRequest();
         	request.open("POST", url, true);
         	request.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
         	if (type=="book") {
         		request.send("type=book&goods_id=${commodity.id}&user_id=${commodity.userId}&winner_id=${commodity.winnerId}&bid_price=${commodity.maxPrice}");
			}
         	else if (type=="watch") {
         		request.send("type=book&goods_id=${commodity.id}&user_id=${commodity.userId}&winner_id=${commodity.winnerId}&bid_price=${commodity.maxPrice}");
			}
         	else if (type=="stamp") {
         		request.send("type=book&goods_id=${commodity.id}&user_id=${commodity.userId}&winner_id=${commodity.winnerId}&bid_price=${commodity.maxPrice}");
			}
         	else if (type=="wine") {
         		request.send("type=book&goods_id=${commodity.id}&user_id=${commodity.userId}&winner_id=${commodity.winnerId}&bid_price=${commodity.maxPrice}");
			} 
         } 
	}
</script>
<%} %>
</body>
</html>