<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="java.lang.String"%>
<!DOCTYPE html>
<html>
<head>
<title>Register</title>
<script src="https://www.google.com/recaptcha/api.js"></script>
<script src="https://kit.fontawesome.com/b10aab807b.js"></script>
<!-- Favicon
		============================================ -->
		<link
	href="http://localhost:8080/WebProject/admin/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="http://localhost:8080/WebProject/admin/css/sb-admin-2.min.css"
	rel="stylesheet">
<link rel="shortcut icon" type="image/x-icon"
	href="http://localhost:8080/WebProject/admin/img/favicon.jpg">

<!-- Fonts
		============================================ -->
<link
	href='https://fonts.googleapis.com/css?family=Raleway:400,700,600,500,300,800,900'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Roboto:400,400italic,500,300,300italic,500italic,700'
	rel='stylesheet' type='text/css'>

<!-- CSS  -->

<!-- Bootstrap CSS
		============================================ -->
<link rel="stylesheet"
	href="http://localhost:8080/WebProject/admin/css/bootstrap.min.css">

<!-- font-awesome.min CSS
		============================================ -->
<link rel="stylesheet"
	href="http://localhost:8080/WebProject/admin/css/font-awesome.min.css">

<!-- Mean Menu CSS
		============================================ -->
<link rel="stylesheet"
	href="http://localhost:8080/WebProject/admin/css/meanmenu.min.css">

<!-- owl.carousel CSS
		============================================ -->
<link rel="stylesheet"
	href="http://localhost:8080/WebProject/admin/css/owl.carousel.css">

<!-- owl.theme CSS
		============================================ -->
<link rel="stylesheet"
	href="http://localhost:8080/WebProject/admin/css/owl.theme.css">

<!-- owl.transitions CSS
		============================================ -->
<link rel="stylesheet"
	href="http://localhost:8080/WebProject/admin/css/owl.transitions.css">

<!-- Price Filter CSS
		============================================ -->
<link rel="stylesheet"
	href="http://localhost:8080/WebProject/admin/css/jquery-ui.min.css">

<!-- nivo-slider css
		============================================ -->
<link rel="stylesheet"
	href="http://localhost:8080/WebProject/admin/css/nivo-slider.css">

<!-- animate CSS
		============================================ -->
<link rel="stylesheet"
	href="http://localhost:8080/WebProject/admin/css/animate.css">

<!-- jquery-ui-slider CSS
		============================================ -->
<link rel="stylesheet"
	href="http://localhost:8080/WebProject/admin/css/jquery-ui-slider.css">

<!-- normalize CSS
		============================================ -->
<link rel="stylesheet"
	href="http://localhost:8080/WebProject/admin/css/normalize.css">

<!-- main CSS
		============================================ -->
<link rel="stylesheet"
	href="http://localhost:8080/WebProject/admin/css/main.css">

<!-- style CSS
		============================================ -->
<link rel="stylesheet"
	href="http://localhost:8080/WebProject/admin/style.css">

<!-- responsive CSS
		============================================ -->
<link rel="stylesheet"
	href="http://localhost:8080/WebProject/admin/css/responsive.css">

<script
	src="http://localhost:8080/WebProject/admin/js/vendor/modernizr-2.8.3.min.js"></script>
<link rel="stylesheet"
	href="http://localhost:8080/WebProject/admin/css/login.css">
<link rel="stylesheet"
	href="http://localhost:8080/WebProject/admin/css/register.css">

</head>
<body>
	<!-- HEADER AREA -->
	<!-- BODY -->
	<%
		String err = (String) request.getAttribute("err");
	%>
	<form action="http://localhost:8080/WebProject/RegisterServlet"
		method="get">
		<div class="containerRegister">
			<h1>Đăng ký</h1>
			<p>Làm ơn điền vào mục dưới đây để tạo tài khoản</p>
			<hr>

			<label for="user"><b>Tài khoản</b></label> <input type="text"
				placeholder="Nhập tài khoản" name="user" id="email" required> <label
				for="psw"><b>Mật khẩu</b></label> <input type="password"
				placeholder="Nhập mật khẩu" name="psw" id="psw" required> <label
				for="psw-repeat"><b>Nhập lại mật khẩu</b></label> <input
				type="password" placeholder="Nhập lại mật khẩu" name="psw-repeat"
				id="psw-repeat" required>
			<%
				if (err != null && err.equalsIgnoreCase("this username has already used")) {
			%>
			<span style="color: red">Tên người dùng này đã được sử dụng</span>
			<%
				} else if (err != null && err.equalsIgnoreCase("That password doesn't match. Try again")) {
			%>
			<span style="color: red">Mật khẩu đó không khớp. Hãy thử lại</span>
			<%
				} else if (err != null && err.equalsIgnoreCase("invalid username")) {
			%>
			<span style="color: red">Tên tài khoản không hợp lệ</span>
			<%
				}
			%>
			<hr>

			<p>
				Bạn đã đồng ý với điều khoản này <a href="#">Terms & Privacy</a>.
			</p>
			<button type="submit" class="registerbtn">Đăng ký</button>
		</div>

		<div class="container signin" style="width: 100%">
			<p>
				Đã có tài khoản? <a
					href="http://localhost:8080/WebProject/admin/login.jsp">Đăng
					nhập</a>.
			</p>
		</div>
	</form>
	<!-- Footer AREA -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>