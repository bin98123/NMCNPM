<%@ page language="java"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
	<form action="Login View" method="post">
		<table>
			<tr>
				<%
				// 				String userName = (String) request.getAttribute("Invalid Username or Password. Username and Password are case-sensitive.");
				String userName = (String) request.getAttribute("Invalid");
				if (userName == null || userName == "")
					userName = "";
				%>
				<td width="68%" align="right"><%=userName%></td>
			</tr>
			<tr>
				<td width="68%" align="right"><h2>UserName:</h2></td>
				<td><h2>
						<input type="text" size="32" name="userName"
							value="${registeredUser.userName}">
					</h2></td>
			<tr>
			<tr>
				<td width="68%" align="right"><h2>Password:</h2></td>
				<td><h2>
						<input type="password" size="32" name="Password"
							value="${registeredUser.userName}">
					</h2></td>
			<tr>
				<td width="68%"><input type="submit" value="Đăng nhập"
					name="submit"></td>
		</table>
	</form>
</body>
</html>