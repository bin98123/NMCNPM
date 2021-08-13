package model;

public class MatHang {
	private String maMH;
	private String tenMH;
	private double giaMua;
	private double giaBan;
	private int slNhap;
	private int slBan;
	private String ngayNhap;
	private String ngaySX;
	public MatHang() {
		// TODO Auto-generated constructor stub
	}
	



	public MatHang(String maMH, String tenMH, double giaMua, double giaBan, int slNhap, int slBan, String ngayNhap,
			String ngaySX) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.giaMua = giaMua;
		this.giaBan = giaBan;
		this.slNhap = slNhap;
		this.slBan = slBan;
		this.ngayNhap = ngayNhap;
		this.ngaySX = ngaySX;
	}

	



	public String getNgaySX() {
		return ngaySX;
	}




	public void setNgaySX(String ngaySX) {
		this.ngaySX = ngaySX;
	}




	public String getMaMH() {
		return maMH;
	}

	public void setMaMH(String maMH) {
		this.maMH = maMH;
	}

	public String getTenMH() {
		return tenMH;
	}

	public void setTenMH(String tenMH) {
		this.tenMH = tenMH;
	}

	public double getGiaMua() {
		return giaMua;
	}

	public void setGiaMua(double giaMua) {
		this.giaMua = giaMua;
	}

	public double getGiaBan() {
		return giaBan;
	}

	public void setGiaBan(double giaBan) {
		this.giaBan = giaBan;
	}

	public int getSlNhap() {
		return slNhap;
	}

	public void setSlNhap(int slNhap) {
		this.slNhap = slNhap;
	}

	public int getSlBan() {
		return slBan;
	}

	public void setSlBan(int slBan) {
		this.slBan = slBan;
	}

	public String getNgayNhap() {
		return ngayNhap;
	}

	public void setNgayNhap(String ngayNhap) {
		this.ngayNhap = ngayNhap;
	}
	
	
}
