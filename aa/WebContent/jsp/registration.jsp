<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>registration</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style>
.fa {
  padding: 20px;
  font-size: 20px;
  width: 54px;
  text-align: center;
  text-decoration: none;
  margin: 5px 2px;
  border-radius: 50%;
}

.fa:hover {
    opacity: 0.7;
}

.fa-facebook {
  background: #3B5998;
  color: white;
}

.fa-twitter {
  background: #55ACEE;
  color: white;
}

.fa-google {
  background: #dd4b39;
  color: white;
}
.fa-instagram {
  background: #125688;
  color: white;
}
form {
	
}
select[type=text],
input[type=file],input[type=text], input[type=password] {
	padding: 12px 20px;
	margin: 8px 8px;
	display: inline-block;
	box-sizing: border-box;
	border-radius: 4px;
}

button {
	color: white;
	padding: 14px 30px;
	margin: 8px 120px;
	border: none;
	cursor: pointer;
}

button:hover {
	opacity: 0.8;
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
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="/aa/bootfiles/bootstrap.min.css">
<script src="/aa/bootfiles/bootstrap.min.js"></script>
<script src="/aa/bootfiles/jquery-3.1.1.min.js"></script>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="/aa/bootfiles/bootstrap.min.css">
<script src="/aa/bootfiles/bootstrap.min.js"></script>
<script src="/aa/bootfiles/jquery-3.1.1.min.js"></script>
<body>

<h2 style="margin-top: 80px;margin-left: 35%;text-decoration: underline"  >Welcome to Registration Page</h2>

<form method="post" action="/aa/Registration" onsubmit="return confirm('your have done your registration')">
<div style="width: 100%">
<table border=0 style="margin-top: 50px"  align="center" >
<tr>
<th>NAME</th><td><input type="text" name="txtuserid" required="required" placeholder="enter your name" id="txtuserid"></td>
</tr>
<tr>
<th>EMAIL</th><td><input type="text" name="txtuseremail" required="required" placeholder="enter your gmail id" id="txtuseremail"></td>
</tr>
<tr>
<th>PASSWORD</th><td><input type="password" name="txtuserpassword" required="required" placeholder="enter userpassword" id="txtuserpassword"></td>
</tr>
<tr>
<th>CONTACT NUMBER</th><td><input type="text" name="txtuserphone" required="required" placeholder="enter your phone number" id="txtuserphoneno"></td>
</tr>
<tr><th>CITY</th>
<td>

<select name="city" id="city" type="text">
<option value="default">select city</option>
<option value="del">New Delhi</option>
<option value="noi">Noida</option>
<option value="gur">Gurugram</option>
<option value="gur">Haryana</option>
<option value="lko">Lucknow</option>
<option value="vrs">Varanasi</option>
<option value="knp">Kanpur</option>
<option value="gzb">Ghaziabad</option></select></td></tr>

<tr>
<td colspan=5 align="center"><button type="submit" style="margin-top: 40px">submit</button>
<button type="reset" style="margin-left:  50px">reset</button></td>
</tr>
</table>
</form>
<div id="div1" style="display:none;background-color: red;width:300px;height: 300px">
</div>

<div
		style="width: 100%; height: 350px; float: left; background-color: black;margin-top: 100px">
		<div class="container-fluid"><br>
<img src="/aa/images/logo.png" style="width:height/4;height:200px"></div>
		
		<div style="float: right;margin-top: 30px;width: 18%">
		<a href="https://twitter.com/sahayak8" class="fa fa-twitter"></a>
<a href="https://www.facebook.com/sahayakweb/"  class="fa fa-facebook"></a>
<a href="https://www.instagram.com/sahayakempoweringlives/" class="fa fa-instagram" style="margin-right: 5px"></a>
</div>
		<div
			style="margin-top: 100px; text-align: center; font-size: 15px; font-weight: bold; text-decoration: underline;color: silver;">
			
		</div>
	</div>
</body>
</html>