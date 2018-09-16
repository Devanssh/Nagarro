<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/aa/bootfiles/bootstrap.min.css">
<script src="/aa/bootfiles/bootstrap.min.js"></script>
<script src="/aa/bootfiles/jquery-3.1.1.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/aa/bootfiles/bootstrap.min.css">
<script src="/aa/bootfiles/bootstrap.min.js"></script>
<script src="/aa/bootfiles/jquery-3.1.1.min.js"></script>
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

input[type=text], input[type=password] {
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

</head>
<body>
<nav class="navbar navbar-default">

	<div class="container"
		style="height: 200px; background-color: black; width: 100%">

		<div class="navbar-header">

			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#myNavbar">

				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>

		</div>
		<div class="collapse navbar-collapse" id="myNavbar">
			<ul class="nav navbar-nav">
				<li><a href="/aa/html/index.html" style="margin-top: 40px"><h3 style="color: silver;">Home</h3></a></li>

					
				<li><a href="/aa/jsp/about.jsp"
					style="margin-top: 40px"><h3 style="color: silver;">About Us</h3></a></li>	
					
					<div class="container-fluid" style="margin-left: 250%"><br>
<img src="/aa/images/logo.png" style="width:height/4;height:120px"></div>
				
				
			</ul>
			
			
			<ul class="nav navbar-nav navbar-right">
			
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">
       <h3 style="color: silver;">
							<span class="glyphicon glyphicon-user" style="color: gray;margin-top: 20px"></span><a href="/aa/jsp/registration.jsp">	Sign Up</a>
						</h3></a>
        
				<!-- <li><a href="/eliving/jsp/actype.jsp" style="margin-top: 10px"><h3>
							<span class="glyphicon glyphicon-user"></span>Sign Up
						</h3></a></li -->
				
			</ul>
		
		</div>
	</div>

</div>
<form method="post" action="/aa/Don">
<table align="center" style="margin-top: 50px">
 <tr>
				<th>First Name</th>
				<td><input type="text" placeholder="Enter your name"
					name="uid" id="uid" required></td>
			</tr>
			<tr>
				<th>Last Name</th>
				<td><input type="text" placeholder="Enter your lastname"
					name="uid1" id="uid1" required></td>
			</tr>
			 <tr><th><p style="margin-top: 5%">Gender</p></th>
<td>   <input type="radio" name="optradio" value="regular" style="margin-left: 5%">Male
   
   <input type="radio" name="optradio" value="work from home" style="margin-left: 5%">Female</td>
    </tr>
    <tr>
				<th>Blood Group</th>
				<td><input type="text" placeholder="Enter your bloodgroup"
					name="uid2" id="uid2" required></td>
			</tr>
			<tr>
			<th>
<p >Organ Donate</p></th>

  <td>    <input type="checkbox" value="all organs" name="a"  style="margin-left: 5%" >All Organs

      <input type="checkbox" value="cornea" name="a" style="margin-left: 2%">Cornea(eyes)
    
      <input type="checkbox" value="kidneys" name="a" style="margin-left: 2%">Kidneys
   
      <input type="checkbox" value="heart" name="a" style="margin-left: 2%">Heart
  
       <input type="checkbox" value="lungs" name="a"  style="margin-left: 5%">Lungs</td>
   
</tr>
<tr>
				<td align="center"> <button type="submit" style="margin-top: 30px">Sign In</button></td>
			</tr>
</table>			
</form>

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