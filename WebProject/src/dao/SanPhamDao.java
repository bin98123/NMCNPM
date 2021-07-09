package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DonViTinh;
import model.LoaiHang;
import model.SanPham;



public class SanPhamDao implements IDAO<SanPham> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
public SanPhamDao() throws SQLException {
	conn=Connect.getConnection();
}
// GET LIST PRODUCT
public ArrayList<SanPham> getListProduct() {
	ArrayList<SanPham> listSanPham = new ArrayList<SanPham>();
	
	try {
		pstmt = conn.prepareStatement("SELECT * FROM MatHang");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			String  MaMh = rs.getString("MaMH");
			String Ten = rs.getString("Ten");
			double  giamua = rs.getDouble("giamua");
			double  giaban = rs.getDouble("giaban");
			int  soluongnhap = rs.getInt("Slnhap");
			int  soluongban = rs.getInt("slban");
			String Malh = rs.getString("malh");
			String Madvt = rs.getString("Madvt");
			LoaiHang loaiHang=new LoaiHangDao().getByKey(Malh);
			DonViTinh donViTinh=new DonViTinhDao().getByKey(Madvt);
			
			SanPham sanpham = new SanPham(MaMh, Ten, giamua, giaban, soluongnhap, soluongban, loaiHang,donViTinh);
			listSanPham.add(sanpham);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		try {
			if (pstmt != null) {
				pstmt.close();
			}
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	return listSanPham;
}
@Override
public SanPham getByKey(String key) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public SanPham getByKeyS(List<String> key) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public boolean insert(SanPham key) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean update(SanPham key) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean delete(SanPham key) {
	// TODO Auto-generated method stub
	return false;
}

public static void main(String[] args) throws SQLException {
	SanPhamDao dao=new SanPhamDao();
	ArrayList<SanPham> list=dao.getListProduct();
	for (SanPham sanPham : list) {
		System.out.println(sanPham);
	}
}
}
