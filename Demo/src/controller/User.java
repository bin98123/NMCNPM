package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class User {
//	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=Shop;user=sa;password=root";
	private String connectionUrl = "jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6418049";
	private String name = "sql6418049";
	private String pass = "gV4INX5cWB";

	// private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String driver = "com.mysql.jdbc.Driver";

	public boolean getLogin(String userName, String userPassword) {
		int available = 0;
		try {

			Class.forName(driver);
//			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl, name, pass);

			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select TenDangNhap, MaKhau from MatHang where TenDangNhap='" + userName
					+ "' and MaKhau='" + userPassword + "'");
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
}
