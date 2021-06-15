package model;

import java.util.Date;
import java.util.List;

public class DonHang {
	private String idDonHang;
	private Date ngayLap;
	private List<SanPham> danhSachSanPham;
	private double tongTien;
	private String idNhanVien;
	private String idKhachHang;

	public DonHang(String idDonHang, Date ngayLap, List<SanPham> danhSachSanPham, double tongTien, String idNhanVien,
			String idKhachHang) {
		super();
		this.idDonHang = idDonHang;
		this.ngayLap = ngayLap;
		this.danhSachSanPham = danhSachSanPham;
		this.tongTien = tongTien;
		this.idNhanVien = idNhanVien;
		this.idKhachHang = idKhachHang;
	}

	public String getIdDonHang() {
		return idDonHang;
	}

	public void setIdDonHang(String idDonHang) {
		this.idDonHang = idDonHang;
	}

	public Date getNgayLap() {
		return ngayLap;
	}

	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}

	public List<SanPham> getDanhSachSanPham() {
		return danhSachSanPham;
	}

	public void setDanhSachSanPham(List<SanPham> danhSachSanPham) {
		this.danhSachSanPham = danhSachSanPham;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public String getIdNhanVien() {
		return idNhanVien;
	}

	public void setIdNhanVien(String idNhanVien) {
		this.idNhanVien = idNhanVien;
	}

	public String getIdKhachHang() {
		return idKhachHang;
	}

	public void setIdKhachHang(String idKhachHang) {
		this.idKhachHang = idKhachHang;
	}

}
