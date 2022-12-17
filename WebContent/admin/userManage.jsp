<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="entity.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/admin/";
List<User> users = new ArrayList<User>();
users = (List<User>) request.getAttribute("users");
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>User</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1" />
<link rel="stylesheet" type="text/css" href="css/bid.css">
<link rel="stylesheet" type="text/css" href="css/goods.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
</head>
<body>
	<div class="top-parent">
		<div class="top-title">
			<div class="top-title-left">
				<a href="<%=path %>/admin/index.jsp" style="text-decoration: none;"> <font size="6" color="#191970" class="top-title-text">Quản lí</font>
				</a>
			</div>
		</div>
	</div>
	<div>
		<div class="content-div">
			<div class="content">
				<div class="content-table">
					<table class="table table-striped">
						<tr>
							<th>ID</th>
							<th>username</th>
							<th>user password</th>
							<th>Sales Quantity</th>
							<th>Purchase quantity</th>
							<th>User rights</th>
							<th></th>
						</tr>
						<%
	                    int i;
	                    int maxPage=users.size();
	                    int start=Integer.parseInt(request.getParameter("start"));
	                    int end=Integer.parseInt(request.getParameter("end"));
	                    if(end>=maxPage)
	                    {
	                    	end=maxPage;
	                    }
	//                     out.print(maxPage);
	                    %>
	                    <%for(i=start;i<end;i++){%>
						
						<tr>
							<td><font style="font-weight: bold;"><%=users.get(i).getId() %></font></td>
							<td><%=users.get(i).getName()%></td>
							<td><%=users.get(i).getPassword()%></td>
							<td><%=users.get(i).getAuction_number()%></td>
							<td><%=users.get(i).getBought_number()%></td>
							<%if(users.get(i).getAdmin()==0) {%>
							<td>Người quản trị </td>
							<%}else{%>
							<td>Khách hàng</td>
							<%}%>

							<td>
								<%if(users.get(i).getAdmin()==1){%> 
								<a href="<%=path %>/UserManageServlet?changeAdmin=ok&userId=<%=users.get(i).getId()%>&start=<%=start%>&end=<%=end%>">Trở thành quản trị viên</a>
								<%}else{ %> 
								<a href="<%=path %>/UserManageServlet?changeAdmin=no&userId=<%=users.get(i).getId()%>&start=<%=start%>&end=<%=end%>">Trở thành khách hàng</a> <%} %>
							</td>
						</tr>
						<%} %>
					</table>
				</div>
<!-- 				<div class="bottom-div">
					<div style="float: right; margin-right: 2%;"></div>
				</div> -->

                <div class="bottom-div-user">
                    <div style="float: right;margin-right: 2%;">
                    <nav aria-label="Page navigation">
                      <ul class="pagination">
                        <li>
                        <%
                        int preEnd=i-6;
                        int preStart=preEnd-6;
                        if(preStart<=0)
                        {
                        	preStart=0;
                        }
                        preEnd=preStart+6;
                        if(preEnd>=maxPage)
                        {
                        	preEnd=maxPage;
                        }
//                         int preEnd=preStart+4;
                        %>
                          <a href="<%=path %>/UserManageServlet?end=<%=preEnd %>&start=<%=preStart %>" aria-label="Previous">
                            <span aria-hidden="true">&laquo;</span>
                          </a>
                        </li>
                        <li><a href="<%=path %>/UserManageServlet?start=0&end=6">1</a></li>
<%--                         <li><a href="<%=path %>/UserManageServlet?start=6&end=12">2</a></li> --%>
<%--                         <li><a href="<%=path %>/UserManageServlet?start=12&end=18">3</a></li> --%>
                        <li>
                        <%
                        int nextEnd=i+6;
                        if(nextEnd>=maxPage)
                        {
                        	nextEnd=maxPage;
                        }
                        int nextStart=nextEnd-6;
                        if(nextStart<=0)
                        {
                        	nextStart=0;
                        }
                        %>
                          <a href="<%=path %>/UserManageServlet?end=<%=nextEnd %>&start=<%=nextStart %>" aria-label="Next">
                            <span aria-hidden="true">&raquo;</span>
                          </a>
                          <div class="pageDivP">
                          <%
                          int thisMaxPage=maxPage/6;
                          int thisPage=i/6;
                          if(thisMaxPage<=0)
                          {
                        	  thisMaxPage=1;
                          }
                          if(thisPage<=0)
                          {
                        	  thisPage=1;
                          }
                          %>
                          <p><%=thisMaxPage%>Trang</p>
                          <p>Trang<%=thisPage%></p>
                          </div>
                        </li>
                      </ul>
                    </nav>
                    </div>
                </div>
			</div>
		</div>
</body>
</html>
