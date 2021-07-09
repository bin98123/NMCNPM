package model;

public class LoaiHang {
private String MaLh;
private String Ten;
public LoaiHang(String maLh, String ten) {
	super();
	MaLh = maLh;
	Ten = ten;
}
public String getMaLh() {
	return MaLh;
}
public void setMaLh(String maLh) {
	MaLh = maLh;
}
public String getTen() {
	return Ten;
}
public void setTen(String ten) {
	Ten = ten;
}
@Override
public String toString() {
	return "LoaiHang [MaLh=" + MaLh + ", Ten=" + Ten + "]";
}

}
