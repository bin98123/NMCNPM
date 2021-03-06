<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>login</title>
<script src="https://www.google.com/recaptcha/api.js"></script>
<script src="https://kit.fontawesome.com/b10aab807b.js"></script>
<!-- Favicon
		============================================ -->
		<link
	href="/admin/vendor/fontawesome-free/css/all.min.css"
	rel="stylesheet" type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
	rel="stylesheet">

<!-- Custom styles for this template-->
<link
	href="/admin/css/sb-admin-2.min.css"
	rel="stylesheet">
<link rel="shortcut icon" type="image/x-icon"
	href="/admin/img/favicon.jpg">

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
	href="/admin/css/bootstrap.min.css">

<!-- font-awesome.min CSS
		============================================ -->
<link rel="stylesheet"
	href="/admin/css/font-awesome.min.css">

<!-- Mean Menu CSS
		============================================ -->
<link rel="stylesheet"
	href="/admin/css/meanmenu.min.css">

<!-- owl.carousel CSS
		============================================ -->
<link rel="stylesheet"
	href="/admin/css/owl.carousel.css">

<!-- owl.theme CSS
		============================================ -->
<link rel="stylesheet"
	href="/admin/css/owl.theme.css">

<!-- owl.transitions CSS
		============================================ -->
<link rel="stylesheet"
	href="/admin/css/owl.transitions.css">

<!-- Price Filter CSS
		============================================ -->
<link rel="stylesheet"
	href="/admin/css/jquery-ui.min.css">

<!-- nivo-slider css
		============================================ -->
<link rel="stylesheet"
	href="/admin/css/nivo-slider.css">

<!-- animate CSS
		============================================ -->
<link rel="stylesheet"
	href="/admin/css/animate.css">

<!-- jquery-ui-slider CSS
		============================================ -->
<link rel="stylesheet"
	href="/admin/css/jquery-ui-slider.css">

<!-- normalize CSS
		============================================ -->
<link rel="stylesheet"
	href="/admin/css/normalize.css">

<!-- main CSS
		============================================ -->
<link rel="stylesheet"
	href="/admin/css/main.css">

<!-- style CSS
		============================================ -->
<link rel="stylesheet"
	href="/admin/style.css">

<!-- responsive CSS
		============================================ -->
<link rel="stylesheet"
	href="/admin/css/responsive.css">

<script
	src="/admin/js/vendor/modernizr-2.8.3.min.js"></script>
<link rel="stylesheet"
	href="/admin/css/login.css">
<link rel="stylesheet"
	href="/admin/css/register.css">

</head>
<body>
	<%
		String err = (String) request.getAttribute("err");
	%>
	<!-- HEADER AREA -->
<jsp:include page="header.jsp"></jsp:include>
	<!-- BODY -->
	<form class="formLogin"
		action="/LoginServlet" method="get">
		<div class="imgcontainer">
			<img src="http://localhost:8080/WebProject/admin/img/img_avatar.png"
				alt="Avatar" class="avatar">
		</div>
		<div class="containerLogin">
			<label for="uname"><b>T??i kho???n</b></label> <input type="text"
				class="uname" placeholder="Nh???p t??i kho???n" name="uname" required>
			<label for="psw"><b>M???t kh???u</b></label> <input type="password"
				class="password" placeholder="Nh???p m???t kh???u" name="psw" required><br>
				<div class="g-recaptcha"
			data-sitekey="6LdPij4aAAAAABcpNgb_poiU0lbvLW0x_wG9BoJP"></div>
			<%
				if (err != null) {
			%>
			<span style="color: red">Sai t??n ????ng nh???p ho???c m???t kh???u ho???c thi???u Captcha</span>
			<%
				}
			%>
			
			<button type="submit" id="button1">????ng nh???p</button>
			<label> <input type="checkbox" checked="checked"
				name="remember"> Nh??? t??i kho???n
			</label>
		</div>

		<div class="containerLogin" style="background-color: #f1f1f1">
<!-- 			<a href="http://localhost:8080/WebProject/admin/index.jsp"><button type="button" class="cancelbtn">Tr??? v???</button></a> <span -->
			<a href="index.jsp"><button type="button" class="cancelbtn">Tr??? v???</button></a> <span
				class="psw">Qu??n 
<!-- 				<a href="http://localhost:8080/WebProject/admin/forgotpassword.jsp">m???t -->
				<a href="forgotpassword.jsp">m???t
					kh???u?</a></span>
		</div>
	</form>
	<!-- Footer AREA -->
	<jsp:include page="footer.jsp"></jsp:include>
	
</body>
</html>