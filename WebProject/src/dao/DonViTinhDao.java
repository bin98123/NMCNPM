package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.DonViTinh;
import model.LoaiHang;

public class DonViTinhDao implements IDAO<DonViTinh> {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	public DonViTinhDao() throws SQLException {
		conn=Connect.getConnection();
	}
	@Override
	public DonViTinh getByKey(String key) {
		DonViTinh donViTinh=null;
		try {
			pstmt=conn.prepareStatement("select * from DonViTinh where Madvt=? ");
			pstmt.setString(1, key);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				String Madvt=rs.getString("Madvt");
				String TEN=rs.getString("Ten");
				donViTinh=new DonViTinh(Madvt, TEN);
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
		return donViTinh;
	}
	@Override
	public DonViTinh getByKeyS(List<String> key) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean insert(DonViTinh key) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean update(DonViTinh key) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(DonViTinh key) {
		// TODO Auto-generated method stub
		return false;
	}
	public ArrayList<String> getListMadvt() {
		ArrayList<String> listdvt = new ArrayList<String>();
		
		try {
			pstmt = conn.prepareStatement("SELECT * FROM DonViTinh");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String  Madvt = rs.getString("MaDvt");
				
				listdvt.add(Madvt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listdvt;
	}	
}
