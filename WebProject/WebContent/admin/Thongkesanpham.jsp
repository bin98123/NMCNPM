<%@page import="dao.SanPhamDao"%>
<%@page import="model.MatHang"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>
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

<title>Thống kê kê sản phẩm</title>

</head>
<jsp:include page="header.jsp"></jsp:include>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-4 text-gray-800"></h1>

	<div>
		<h1>Thống Kê sản phẩm</h1>
		<hr>
	</div>
	<% SanPhamDao dao = new SanPhamDao();
	ArrayList<MatHang> listSanPham = dao.getListProductStatistical();
	request.setAttribute("list", listSanPham);
	%>
	<form
		action="http://localhost:8080/WebProject/ThongKeHoiDap?action=thongke"
		method="post">
		<div style="display: flex; margin-top: 45px">
			
		</div>
	</form>
	<div
		style="border-radius: 6px; text-align: center; padding: 10px; margin-top: 10px; color: white; background-color: #36b9cc">

		<span>Danh sách sản phẩm</span>

	</div>
	<div class="card shadow mb-4" style="margin-top: 10px">
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							
							<th>Mã MH</th>
							<th>Tên</th>
							<th>Giá mua</th>
							<th>Giá bán</th>
							<th>Ngày SX</th>
							<th>SL nhập</th>
							<th>SL bán</th>
							<th>Ngày nhập</th>
						
						</tr>
					</thead>
						<c:forEach items="${list}" var="li">
						<tr>
								<td>${li.maMH}</td>
								<td>${li.tenMH}</td>
								<td>${li.giaMua}</td>
								<td>${li.giaBan}</td>
								<td>${li.ngaySX}</td>
								<td>${li.slNhap}</td>
								<td>${li.slBan}</td>
								<td>${li.ngayNhap}</td>
								</tr>
						 </c:forEach>
					</tbody>
					
				</table>
			</div>
		</div>
	</div>
</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<!-- Footer -->
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>