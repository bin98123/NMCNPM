package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.NhanVien;
import model.ThanhVien;

public class ThanhVienDAO {
//	private Connection conn = null;
//	private PreparedStatement pstmt = null;
//	private ResultSet rs = null;
	static String connectionUrl = "jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6418049";
	static String name = "sql6418049";
	static String pass = "gV4INX5cWB";
	static String driver = "com.mysql.jdbc.Driver";

	public ThanhVienDAO() throws SQLException {
//		conn = Connect.getConnection();
	}

	public static NhanVien login(NhanVien currentUser) throws SQLException, ClassNotFoundException {
//		currentCon = Connect.getConnection();
//		currentCon = DBCPDataSource.getConnection();
		// preparing some objects for connection

		String username = currentUser.getUserName();
		String password = currentUser.getPassword();

		try {
			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl, name, pass);
			// connect to DB
			PreparedStatement ps = con
					.prepareStatement("Select * from NhanVien where TenDangNhap = ? and MatKhau = ? ");
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			boolean more = rs.next();

			// if user does not exist set the isValid variable to false
//			if (!more) {
//				currentUser.setValid(false);
//			}

			// if user exists set the isValid variable to true
			if (more) {
//				int ID = rs.getInt("ID");
//				String quyen = rs.getString("quyen");
//				currentUser.setID(ID);
//				currentUser.setQuyen(quyen);
//				new CartDao().createNewCartWhenUserDontHave(1);
//				new WishListDao().createNewWishListIfUserDontHave(1);
//				new OrderDao().createNewDonHangWhenUserDontHave(1);
				currentUser.setHoVaTen(rs.getString("HoTen"));
//				currentUser.setValid(true);
			}
		}

		catch (SQLException e) {
			e.printStackTrace();
		}

		// some exception handling

		return currentUser;

	}

	public static boolean login(String userName, String userPassword) {
		int available = 0;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl, name, pass);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select TenDangNhap, MatKhau from NhanVien where TenDangNhap='" + userName
					+ "' and MatKhau='" + userPassword + "'");
			while (rs.next()) {
				available++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		if (available != 0) {
			return true;
		}
		return false;

	}

	public static void main(String[] args) throws SQLException {
		ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
//		NhanVien thanhVien = new NhanVien() 
//		System.out.println(thanhVienDAO.getLogin("anh123", "vananh"));
	}
}
