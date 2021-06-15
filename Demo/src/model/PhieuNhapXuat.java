package model;

import java.util.Date;

public class PhieuNhapXuat {
	private String idPhieu;
	private Date ngay;
	private SanPham sanPham;
	private int soLuong;

	public PhieuNhapXuat(String idPhieu, Date ngay, SanPham sanPham, int soLuong) {
		super();
		this.idPhieu = idPhieu;
		this.ngay = ngay;
		this.sanPham = sanPham;
		this.soLuong = soLuong;
	}

	public String getIdPhieu() {
		return idPhieu;
	}

	public void setIdPhieu(String idPhieu) {
		this.idPhieu = idPhieu;
	}

	public Date getNgay() {
		return ngay;
	}

	public void setNgay(Date ngay) {
		this.ngay = ngay;
	}

	public SanPham getSanPham() {
		return sanPham;
	}

	public void setSanPham(SanPham sanPham) {
		this.sanPham = sanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	private void capNhatPhieu() {

	}
}
