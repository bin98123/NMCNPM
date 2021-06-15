package model;

public abstract class ThanhVien {
	protected String maThanhVien;
	protected String hoVaTen;
	protected String userName;
	protected String password;

	public ThanhVien(String maThanhVien, String hoVaTen, String userName, String password) {
		super();
		this.maThanhVien = maThanhVien;
		this.hoVaTen = hoVaTen;
		this.userName = userName;
		this.password = password;
	}

	public ThanhVien() {

	}

	public String getMaThanhVien() {
		return maThanhVien;
	}

	public void setMaThanhVien(String maThanhVien) {
		this.maThanhVien = maThanhVien;
	}

	public String getHoVaTen() {
		return hoVaTen;
	}

	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// phýõng thýìc
	protected abstract void hienThiThongTin();

	protected abstract void capNhatThongTin();

}
