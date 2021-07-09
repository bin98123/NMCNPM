package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.LoaiHang;


public class LoaiHangDao implements IDAO<LoaiHang> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	public LoaiHangDao() throws SQLException {
		conn=Connect.getConnection();
	}

	@Override
	public boolean insert(LoaiHang key) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(LoaiHang key) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(LoaiHang key) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public LoaiHang getByKey(String key) {
		LoaiHang LoaiHang=null;
		try {
			pstmt=conn.prepareStatement("select * from LoaiHang where Malh=? ");
			pstmt.setString(1, key);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String Malh=rs.getString("Malh");
				String TEN=rs.getString("Ten");
			LoaiHang=new LoaiHang(Malh, TEN);
			}
		} catch (Exception e) {
			// TODO: handle exception
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
		return LoaiHang;
	}

	@Override
	public LoaiHang getByKeyS(List<String> key) {
		// TODO Auto-generated method stub
		return null;
	}
public static void main(String[] args) throws SQLException {
	LoaiHangDao hangDao=new LoaiHangDao();
	LoaiHang hang=hangDao.getByKey("h1");
	System.out.println(hang);
}		
}
