<%@page import="java.sql.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page 
import="dao.WatchDao"
import="dao.WatchDaoFactory"
import="entity.Watch"
import="java.util.*"
import="java.text.SimpleDateFormat"
import="entity.*"
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<% 
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
List<User> users = (List<User>)request.getAttribute("users");
List<Commodity> commodity = null;
commodity = (List<Commodity>)request.getAttribute("commodity");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>online auction system</title>
<link rel="stylesheet" href="css/HomePage.css" />
<link rel="stylesheet" href="css/SerchBox.css" />
<link rel="stylesheet" href="css/CategoryStyle.css" />

<script type="text/javascript" src="js/jquery-2.1.0.js" ></script>
</head>
<body>
<div class="HomePageTitle">
		
		<nav>
			<%
				if (session.getAttribute("user") == null) {
			%>  
			<a href="<%=path%>/login.jsp"><font color="#A6686A">Xin chào, vui lòng đăng nhập </font></a>
			<%
				} else {
			%>  
			        <a href="<%=path %>/UserServlet?user_id=<%=((User)session.getAttribute("user")).getId() %>"><font color="#A6686A">Chào mừng,${user.name} </font></a> 
			<a href="<%=path%>/IndexServlet?login=no"><font color="#A6686A"><font color="#D6686A">đăng xuất</font> </font></a>
			<%
				}
			%>

			<a href="index.jsp">Chào mừng đến với Auction.com</a>
		</nav>
	</div>

	<div class="HomePageTitle2">
	    <div class="serchBox">
		<form action="SerchServlet" name="search" class="search" method="post" ><br>
			<input type="text" id="serchInput" name="serchInput" placeholder="Tìm kiếm"/>
			<input type="submit" id="serchBtn" value="Tìm kiếm" onclick=" return SumbitJudge()"/>
		</form>
		</div>
	</div>
	<script type="text/javascript">
function SumbitJudge() {
// 	alert("sada");
    var input=document.getElementById("serchInput").value;
	if (!input) {
		alert("Nhập nội dung tìm kiếm!");
		return false;
	}
	return true;
}
</script>
	<!-- 导航栏 -->
	<div class="Navigation1">
		<nav>
			<!--超链接标签-->
			<a href="<%=path%>/index.jsp">Trang chủ</a>
			<a href="<%=path%>/watch.jsp">Đồng hồ</a>
			<a href="<%=path%>/stamp.jsp">Tem</a>
			<a href="<%=path%>/book.jsp">Sách</a>
			<a href="<%=path%>/wine.jsp">Rượu</a>
		</nav>
	</div>

	<div class="watchBox">
		<div class="h1Box">
			<p class="h1">kết quả tìm kiếm</p>
		</div>
		<div class="watchBox2" id="watchBox2">
			<p class="h2">Duyệt</p>
			<%
			if(!commodity.isEmpty()){
			for(int i=0;i<commodity.size();i++){
				if(commodity.get(i).getState()==2)
				{
					continue;
				} 
			%>
        	<a href="<%=path%>/AuctionServlet?id=<%=commodity.get(i).getCommodityId() %>&type=<%=commodity.get(i).getType()%>" style="width: 20%;height: 35%" >
<div>
               <img src="<%=path+"/"+commodity.get(i).getPicture() %>">
                     <% long Ms=commodity.get(i).getDate().getTime();
                        long TotalMS = commodity.get(i).getDate().getTime()+259200000;
                        SimpleDateFormat myFmt=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	                  %>
               <p><%=commodity.get(i).getIntroduce() %></p>
               <p class="p2" id="" style="position: absolute;border: 2px;">thời gian còn lại:<%=myFmt.format(TotalMS)%></p>
          </div>
               </a>
            <%} } %>
       </div>
	</div>
</body>
</html>