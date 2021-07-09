package model;

public class DonViTinh {
private String MaDvt;
private String ten;
public DonViTinh(String maDvt, String ten) {
	super();
	MaDvt = maDvt;
	this.ten = ten;
}
public String getMaDvt() {
	return MaDvt;
}
public void setMaDvt(String maDvt) {
	MaDvt = maDvt;
}
public String getTen() {
	return ten;
}
public void setTen(String ten) {
	this.ten = ten;
}
@Override
public String toString() {
	return "DonViTinh [MaDvt=" + MaDvt + ", ten=" + ten + "]";
}

}
