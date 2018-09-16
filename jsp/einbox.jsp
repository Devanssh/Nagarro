<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.*,eliving.dbutil.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<style>

form {
	border: 4px solid #4CAF50;
}
</style>
<body>



<%

HttpSession hs= request.getSession(false);
String u_id=(String)hs.getAttribute("userinfo");%>
<div style="width: 60%; height: 350px; margin: 0 auto; margin-top: 200px">


<form>
<%String strsql="select * from sentitem where receiverid=?";
ResultSet rs= CrudOperation.fetchData(u_id,strsql);
%>

<table align="center">
<tr><th style="font-family: Showcard Gothic; font-size: 20px;text-decoration: underline">Sender Id</th>
<th style="font-family: Showcard Gothic; font-size: 20px;text-decoration: underline">Date</th>
<th style="font-family: Showcard Gothic; font-size: 20px;text-decoration: underline">Subject</th>
<th style="font-family: Showcard Gothic; font-size: 20px;text-decoration: underline">Message</th>
<th style="font-family: Showcard Gothic; font-size: 20px;text-decoration: underline">Documents</th>
</tr>

<%
while(rs.next())
{ %>
<tr><th><%=rs.getString("senderid")%></th><th><%=rs.getDate("dateofmsg") %></th><th><%=rs.getString("subject") %></th>
<th><%=rs.getString("message")%></th><th><%=rs.getString("documents")%></th>
</tr> 
<%
}
%>
 
 </table>

		</form>
	</div>
 




</body>
</html>