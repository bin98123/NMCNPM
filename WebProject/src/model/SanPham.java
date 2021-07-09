package model;

public class SanPham {
	private String maMH;
	private String tenMH;
	private double giaMua;
	private double giaBan;
	private int slNhap;
	private int slBan;
	private LoaiHang loaihang;
	private DonViTinh Dvt;
	public SanPham(String maMH, String tenMH, double giaMua, double giaBan, int slNhap, int slBan, LoaiHang loaihang,
			DonViTinh dvt) {
		super();
		this.maMH = maMH;
		this.tenMH = tenMH;
		this.giaMua = giaMua;
		this.giaBan = giaBan;
		this.slNhap = slNhap;
		this.slBan = slBan;
		this.loaihang = loaihang;
		Dvt = dvt;
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
	
	
	
	public LoaiHang getLoaihang() {
		return loaihang;
	}
	public void setLoaihang(LoaiHang loaihang) {
		this.loaihang = loaihang;
	}
	public DonViTinh getDvt() {
		return Dvt;
	}
	public void setDvt(DonViTinh dvt) {
		Dvt = dvt;
	}
	@Override
	public String toString() {
		return "SanPham [maMH=" + maMH + ", tenMH=" + tenMH + ", giaMua=" + giaMua + ", giaBan=" + giaBan + ", slNhap="
				+ slNhap + ", slBan=" + slBan + ", loaihang=" + loaihang + ", Dvt=" + Dvt + "]";
	}


}
