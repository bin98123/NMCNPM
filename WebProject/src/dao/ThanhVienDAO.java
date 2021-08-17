package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

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
	static String register = "INSERT INTO NhanVien" + "  (MaNV,maCv,tendangnhap,matkhau) VALUES ";

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

	public static int register(String userName, String userPassword) throws ClassNotFoundException, SQLException {
		int result = 0;
		Class.forName(driver);
//			try (Connection connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/examples", "sa", ""))
		try (Connection con = DriverManager.getConnection(connectionUrl, name, pass))

		{

			// Step 3: Execute the query or update query
			try {
				Statement statement = con.createStatement();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if (new ThanhVienDAO().checkAccount(userName) == 0) {
				try (PreparedStatement insert = con.prepareStatement(register + " (?, ?,?,?);")) {
					// 1private String accountID;
//				2private String accountName;
//				3private String password;
//				4private String fullName;
//				5private Date birthday;
//				6private String email;
//				7private String phoneNumber;
//				insert.setString(1, account.getPassword() + account.getAccountName());
					insert.setString(1, "nv" + (new ThanhVienDAO().countNV()));
					insert.setString(2, "cv3");
					insert.setString(3, userName);
					insert.setString(4, userPassword);
//				insert.executeUpdate();
					result = insert.executeUpdate();

				}
			}
		}
		return result;

	}

	public int countNV() throws ClassNotFoundException, SQLException {
		int result = 0;

		Class.forName(driver);

		Connection con = DriverManager.getConnection(connectionUrl, name, pass);

		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select count(MaNV) as totalRow from NhanVien");
		while (rs.next()) {

			result = rs.getInt("totalRow") + 1;
		}

		return result;
	}

	public int checkAccount(String userName) {
		int available = 0;
		try {

			Class.forName(driver);

			Connection con = DriverManager.getConnection(connectionUrl, name, pass);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from NhanVien where tendangnhap='" + userName + "'");
			while (rs.next()) {
				available++;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Can't running this process!!!");
		}
		return available;

	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
		System.out.println(thanhVienDAO.register("khanh", "khanh"));
//		NhanVien thanhVien = new NhanVien() 
//		System.out.println(thanhVienDAO.getLogin("anh123", "vananh"));
	}
}
