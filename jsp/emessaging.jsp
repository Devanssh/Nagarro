<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Expert Compose</title>
<style>
input[type=text] {
	padding: 12px 20px;
	margin: 8px 8px;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
	border-radius: 4px;
}

button {
	background-color: #4CAF50;
	color: white;
	padding: 14px 30px;
	margin: 8px 120px;
	border: none;
	cursor: pointer;
}

button:hover {
	opacity: 0.8;
}

#txtcontent {
	padding: 12px 20px;
	margin: 8px 8px;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
	border-radius: 4px;
}

#mySidenav a {
	position: absolute;
	left: -80px;
	transition: 0.3s;
	padding: 15px;
	width: 100px;
	text-decoration: none;
	font-size: 20px;
	color: white;
	border-radius: 0 5px 5px 0;
}

#mySidenav a:hover {
	left: 0;
}

#view {
	top: 220px;
	background-color: #4CAF50;
}

#update {
	top: 320px;
	background-color: #2196F3;
}

#delete {
	top: 420px;
	background-color: #f44336;
}

#contact {
	top: 520px;
	background-color: #555
}
/* for right */
#mySidenav1 a {
	position: absolute;
	right: -80px;
	transition: 0.3s;
	padding: 15px;
	width: 100px;
	text-align: right;
	text-decoration: none;
	font-size: 20px;
	color: white;
	border-radius: 5px 0px 0px 5px;
}

#mySidenav1 a:hover {
	right: 0;
}

#msg {
	top: 220px;
	background-color: #4CAF50;
}

#tip {
	top: 320px;
	background-color: #2196F3;
}

#search {
	top: 420px;
	background-color: #f44336;
}

#feedback {
	top: 520px;
	background-color: #555
}

form {
	border: 4px solid #4CAF50;
}

.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
}

img.avatar {
	width: 50%;
	border-radius: 80%;
}

.container {
	padding: 16px;
}
</style>
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
<div style="width: 100%; height: 500px">

	<div
		style="width: 40%; height: 400px; margin: 0 auto; margin-top: 200px">

		<form method=post action="/eliving/emessage">
			<table align="center">
				<tr>
					<th>ReceiverId</th>
					<th></th>

					<td><input type="text" name="txtrec" required="required"
						placeholder="Enter receiver id" id="txtrec"></td>
				</tr>

				<tr>
					<th>SenderId</th>
					<th></th>

					<td><input type="text" name="txtsend" required="required"
						placeholder="Write your id" id="txtsend" value="<%=u_id %>"></td>
				</tr>
				<tr>
					<th>Subject</th>
					<th></th>


					<td><input type="text" name="txtsub" required="required"
						placeholder="Enter Subject" id="txtsub"></td>
				</tr>
				<tr>
					<th>Message</th>
					<th></th>

					<td><input type="text" name="txtmsg" required="required"
						placeholder="Enter message" id="txtmsg"></td>
				</tr>

				<tr>
					<th>Upload</th>
					<th></th>
					<td style="margin-bottom: 10px"><input type="file" name="fl" id="fl"></td>
				</tr>


				<tr>
					<td style="margin-bottom: 10px" align="center" colspan=3><button
							type="submit">Send</button></td>
				</tr>
			</table>
		</form>
	</div>

	</div>
</body>
</html>