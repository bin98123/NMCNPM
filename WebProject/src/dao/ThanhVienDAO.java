package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ThanhVienDAO {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
public ThanhVienDAO() throws SQLException {
	conn=Connect.getConnection();
}
	public boolean getLogin(String userName, String userPassword) {
		boolean check=false;
		try {

		
			pstmt=conn.prepareStatement("select TenDangNhap, MatKhau from NhanVien where TenDangNhap=? and MatKhau=?");
			pstmt.setString(1, userName);
			pstmt.setString(2, userPassword);
			rs=pstmt.executeQuery();
			
			while (rs.next()) {
				String tk=rs.getString("tendangnhap");
				String mk=rs.getString("MatKhau");
				if(tk.equalsIgnoreCase(userName) && mk.equalsIgnoreCase(userPassword)) {
					check=true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
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
			}}
		
		return check;

	}
public static void main(String[] args) throws SQLException {
	ThanhVienDAO thanhVienDAO=new ThanhVienDAO();
	System.out.println(thanhVienDAO.getLogin("anh123", "vananh"));
}
}
