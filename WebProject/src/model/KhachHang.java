package model;

public class KhachHang {
	private String diaChi;
	private String soDienThoai;

	public KhachHang(String diaChi, String soDienThoai) {
		super();
		this.diaChi = diaChi;
		this.soDienThoai = soDienThoai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSoDienThoai() {
		return soDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}

}
