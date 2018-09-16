<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Tip Management</title>

<script>
function main()
{
	var b= true//to print all error messages together
	var sub=document.getElementById("txtsub").value;
	var con=document.getElementById("txtcontent").value;
	//alert(ui)
	
	if(checkEmpty(sub)==false)
		{
		//alert("UserId filed can't be empty")
		//document.getElementById("msg").innerHTML="Subject Required"
		//return false// this will give false to onsubmit function and control will not go to true
		b=false//for printing together
		
		}

		if(checkEmpty(con)==false)
		{
		//alert("Password field can't be empty")
		//document.getElementById("msg1").innerHTML="Content can't be empty"
		//return false
		b= false//for printing together
		}
		else{
			alert("posted successfully")
		}
		return b;
}
		</script>

</head>
<body>
	
	<div
		style="width: 40%; height: 300px; margin: 0 auto; margin-top: 150px">

		<form method=post action="/eliving/A" onsubmit="return main()">
	
			<table align="center">
				<tr>
					<th>Subject</th>
					<th></th>
					
					<td><input type="text" name="txtsub" required="required"
						placeholder="Enter Subject" id="txtsub"></td>
				</tr>
				
				<tr>
					<th>Content</th>
					<th></th>
					
					<td><textarea rows=4 cols=22 name="txtcontent" required="required"
							placeholder="Write your content" id="txtcontent"></textarea></td>
				</tr>
				<br><br>
				<tr>
				<td style="margin-bottom: 5px" align="center" colspan=3><button  type="submit">Post</button></td>
			</tr></table>
		</form>
	</div>

	
</body>
</html>



