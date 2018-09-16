<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
		HttpSession hs = request.getSession(false);
		String u_id = (String) hs.getAttribute("userinfo");
	%>

	<div style="width: 100%; height: 90px">
		<jsp:include page="/jsp/userHeader.jsp">
			<jsp:param value="<%=u_id%>" name="userid" />
		</jsp:include>
	</div>
	<div style="margin-top: 40px">
</div>	
	<div style="width: 100%;height: 550px">
	<div style="width: 100%;height: 250px;margin-top: 120px">
	<h1 style="font-stretch: wider">MESSAGE SECTION</h1><br><br>
<h1>	<button type="submit">COMPOSE</button></h1>
<h1>	<button type="submit">INBOX</button></h1>
<h1>	<button type="submit">SENT-ITEMS</button></h1>
	
	</div>
	</div>
	
</body>
</html>