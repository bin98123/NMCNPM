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
			<h1>????ng k??</h1>
			<p>L??m ??n ??i???n v??o m???c d?????i ????y ????? t???o t??i kho???n</p>
			<hr>

			<label for="user"><b>T??i kho???n</b></label> <input type="text"
				placeholder="Nh???p t??i kho???n" name="user" id="email" required> <label
				for="psw"><b>M???t kh???u</b></label> <input type="password"
				placeholder="Nh???p m???t kh???u" name="psw" id="psw" required> <label
				for="psw-repeat"><b>Nh???p l???i m???t kh???u</b></label> <input
				type="password" placeholder="Nh???p l???i m???t kh???u" name="psw-repeat"
				id="psw-repeat" required>
			<%
				if (err != null && err.equalsIgnoreCase("this username has already used")) {
			%>
			<span style="color: red">T??n ng?????i d??ng n??y ???? ???????c s??? d???ng</span>
			<%
				} else if (err != null && err.equalsIgnoreCase("That password doesn't match. Try again")) {
			%>
			<span style="color: red">M???t kh???u ???? kh??ng kh???p. H??y th??? l???i</span>
			<%
				} else if (err != null && err.equalsIgnoreCase("invalid username")) {
			%>
			<span style="color: red">T??n t??i kho???n kh??ng h???p l???</span>
			<%
				}
			%>
			<hr>

			<p>
				B???n ???? ?????ng ?? v???i ??i???u kho???n n??y <a href="#">Terms & Privacy</a>.
			</p>
			<button type="submit" class="registerbtn">????ng k??</button>
		</div>

		<div class="container signin" style="width: 100%">
			<p>
				???? c?? t??i kho???n? <a
					href="http://localhost:8080/WebProject/admin/login.jsp">????ng
					nh???p</a>.
			</p>
		</div>
	</form>
	<!-- Footer AREA -->
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>