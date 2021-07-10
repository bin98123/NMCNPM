<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
<script src="https://www.google.com/recaptcha/api.js"></script>
</head>
<body>
	<%
		String err = (String) request.getAttribute("err");
	%>
	<!-- HEADER AREA -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- BODY -->
	<form class="formLogin"
		action="http://localhost:8080/WebProject/LoginServlet" method="get">
		<div class="imgcontainer">
			<img src="http://localhost:8080/WebProject/user/img/img_avatar.png"
				alt="Avatar" class="avatar">
		</div>
		<div class="containerLogin">
			<label for="uname"><b>Tài khoản</b></label> <input type="text"
				class="uname" placeholder="Nhập tài khoản" name="uname" required>
			<label for="psw"><b>Mật khẩu</b></label> <input type="password"
				class="password" placeholder="Nhập mật khẩu" name="psw" required><br>
				<div class="g-recaptcha"
			data-sitekey="6LdPij4aAAAAABcpNgb_poiU0lbvLW0x_wG9BoJP"></div>
			<%
				if (err != null) {
			%>
			<span style="color: red">Sai tên đăng nhập hoặc mật khẩu hoặc thiếu Captcha</span>
			<%
				}
			%>
			
			<button type="submit" id="button1">Đăng nhập</button>
			<label> <input type="checkbox" checked="checked"
				name="remember"> Nhớ tài khoản
			</label>
		</div>

		<div class="containerLogin" style="background-color: #f1f1f1">
			<a href="http://localhost:8080/WebProject/user/index.jsp"><button type="button" class="cancelbtn">Trở về</button></a> <span
				class="psw">Quên <a
				href="http://localhost:8080/WebProject/user/forgotpassword.jsp">mật
					khẩu?</a></span>
		</div>
	</form>
	<!-- Footer AREA -->
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>