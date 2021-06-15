package model;

public class SanPham {
	private String idSanPham;
	private String tenSanPham;
	private double donGia;
	private String tinhTrang;

	public SanPham(String idSanPham, String tenSanPham, double donGia, String tinhTrang) {
		super();
		this.idSanPham = idSanPham;
		this.tenSanPham = tenSanPham;
		this.donGia = donGia;
		this.tinhTrang = tinhTrang;
	}

	public String getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(String idSanPham) {
		this.idSanPham = idSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(String tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	private void hienThiThongTin() {
		// TODO Auto-generated method stub

	}

	private void capNhatThongTin() {
		// TODO Auto-generated method stub

	}
}
