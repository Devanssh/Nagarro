

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
  <%@page import="java.sql.*,eliving.dbutil.*"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete Users</title>
</head>
<body>


	<div>
		<form action="/eliving/delete">
			<%
				String strsql = "select * from logininfo";
				ResultSet rs = CrudOperation.fetchData(strsql);
			%>
<%

HttpSession hs= request.getSession(false);
String u_id=(String)hs.getAttribute("userinfo");
%>

			<table border="2">
			<tr>
			<th>select</th>
				<th>userid</th>
				<th>userpass</th>
				<th>usertype</th>
			</tr>
		
		<%while (rs.next()) {%>

		<tr>
		<th><input type="checkbox" name="chkdelete" value="<%=rs.getString("userid")%>">
		</th></tr>
		
		<tr>
			<th><%=rs.getString("userid")%></th>
			<th><%=rs.getString("userpass")%></th>
			<th><%=rs.getString("usertype")%></th>
		
		</tr>
			<%}%>
			
			<tr>
			<th colspan=4 align="center">
			<button type="submit">delete</button>
			
	
	</table>
	</form>
	</div>
</body>
</html>

