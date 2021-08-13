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


//thong ke mat hang
public ArrayList<MatHang> getListProductStatistical() {
	ArrayList<MatHang> listSanPham = new ArrayList<MatHang>();

	try {
		pstmt = conn.prepareStatement("SELECT * FROM MatHang");
		rs = pstmt.executeQuery();
		while (rs.next()) {
			String  MaMh = rs.getString("MaMH");
			String Ten = rs.getString("Ten");
			String ngaySX = rs.getString("ngaySX");
			double  giamua = rs.getDouble("giamua");
			double  giaban = rs.getDouble("giaban");
			int  soluongnhap = rs.getInt("Slnhap");
			int  soluongban = rs.getInt("slban");
			String ngaynhap = rs.getString("ngaynhap");

			MatHang sanpham = new MatHang(MaMh, Ten, giamua, giaban, soluongnhap, soluongban,ngaynhap,ngaySX);
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
	SanPham sanpham =null;
	try {
		pstmt = conn.prepareStatement("SELECT * FROM MatHang where MaMH=?");
		pstmt.setString(1, key);
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
			
			 sanpham = new SanPham(MaMh, Ten, giamua, giaban, soluongnhap, soluongban, loaiHang,donViTinh);
			
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
	return sanpham;
}
@Override
public SanPham getByKeyS(List<String> key) {
	// TODO Auto-generated method stub
	return null;
}
@Override
public boolean insert(SanPham key) {
	String  MaMh = key.getMaMH();
	String Ten = key.getTenMH();
	double  giamua = key.getGiaMua();
	double  giaban = key.getGiaBan();
	int  soluongnhap = key.getSlNhap();
	int  soluongban = key.getSlBan();
	String Malh = key.getLoaihang().getMaLh();
	String Madvt = key.getDvt().getMaDvt();
	try {
		pstmt=conn.prepareStatement("insert into MatHang values(?,?,?,?,?,?,?,?,?,?)");
		pstmt.setString(1, MaMh);
		pstmt.setString(2, Ten);
		pstmt.setDouble(3, giamua);
		pstmt.setDouble(4, giaban);
		pstmt.setDate(5,null);
		pstmt.setInt(6, soluongnhap);
		pstmt.setInt(7, soluongban);
		pstmt.setDate(8,null);
		pstmt.setString(9, Malh);
		pstmt.setString(10, Madvt);
		int a=pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
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
	return false;
}
@Override
public boolean update(SanPham key) {
	String  MaMh = key.getMaMH();
	String Ten = key.getTenMH();
	double  giamua = key.getGiaMua();
	double  giaban = key.getGiaBan();
	int  soluongnhap = key.getSlNhap();
	int  soluongban = key.getSlBan();
	String Malh = key.getLoaihang().getMaLh();
	String Madvt = key.getDvt().getMaDvt();
	
	try {
		pstmt=conn.prepareStatement("update MatHang set Ten=?,giamua=?,giaban=?,SLnhap=?,slban=?,Malh=?,Madvt=? where  MaMH=?");
		
		pstmt.setString(1, Ten);
		pstmt.setDouble(2, giamua);
		pstmt.setDouble(3, giaban);
		
		pstmt.setInt(4, soluongnhap);
		pstmt.setInt(5, soluongban);
		pstmt.setString(6, Malh);
		pstmt.setString(7, Madvt);
		pstmt.setString(8, MaMh);
	
		int a=pstmt.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
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
	return false;
}
@Override
public boolean delete(SanPham key) {
	String id_sanpham = key.getMaMH();
	try {
		pstmt = conn.prepareStatement("delete from MatHang where MaMH = ?");
		pstmt.setString(1, id_sanpham);
		int row = pstmt.executeUpdate();
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
	return false;
}
public void deleteAllProduct() {
	try {
		pstmt = conn.prepareStatement("delete from MatHang");
		pstmt.executeUpdate();
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
}
public static void main(String[] args) throws SQLException {
	SanPhamDao dao=new SanPhamDao();
//	ArrayList<SanPham> list=dao.getListProduct();
//	for (SanPham sanPham : list) {
//		System.out.println(sanPham);
//	}
	DonViTinh donViTinh=new DonViTinhDao().getByKey("VN");
	LoaiHang lh=new LoaiHangDao().getByKey("H1");
SanPham pham=new SanPham("sp66", "váy thời trang", 1.2, 2.2, 40, 30, lh, donViTinh);
dao.insert(pham);
}
}
