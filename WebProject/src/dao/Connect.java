package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Connect {
	 static String connectionUrl = "jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6418049";
	 static String name = "sql6418049";
 static String pass = "gV4INX5cWB";
	 String driver = "com.mysql.jdbc.Driver";
	 public static Connection connection = null;

		public static Connection getConnection() throws SQLException {
			if (connection == null || connection.isClosed()) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connection = DriverManager.getConnection(connectionUrl, name, pass);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				return connection;
			} else {
				return connection;
			}
		}
public static void main(String[] args) {
	try {
		PreparedStatement preparedStatement=getConnection().prepareStatement("select * from NhanVien");
		ResultSet resultSet=preparedStatement.executeQuery();
		while(resultSet.next()) {
			String taikhoan=resultSet.getString("tendangnhap");
			String matkhau=resultSet.getString("matkhau");
			System.out.println(taikhoan+ matkhau);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
