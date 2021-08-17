<%@page import="dao.SanPhamDao"%>
<%@page import="model.MatHang"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<!DOCTYPE html>
<html>
<head>

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