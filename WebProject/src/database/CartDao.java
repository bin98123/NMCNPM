package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Cart;
import beans.CartItem;
import beans.Product;
import beans.User;
import model.SanPham;

public class CartDao {
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String connectionUrl = "jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6418049";
	private String name = "sql6418049";
	private String pass = "gV4INX5cWB";

	// private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String driver = "com.mysql.jdbc.Driver";

	public CartDao() throws SQLException {
//		conn = DBCPDataSource.getConnection();
		conn = Connect.getConnection();
	}

	// TODO CREATE NEW CART IF USER DONT HAVE
	public void createNewCartWhenUserDontHave(int userID) {
		if (findCartByUserID(userID) == -1) {
			try {
				pstmt = conn.prepareStatement("insert into cart (ID) values (?)");
				pstmt.setInt(1, userID);
				pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			return;
		}
	}

	// TODO FIND CART USER BY ID (RETURN BOOLEAN)
	public int findCartByUserID(int idUser) {
		try {
			pstmt = conn.prepareStatement("select * from cart where ID = ?");
			pstmt.setInt(1, idUser);
			rs = pstmt.executeQuery();
			boolean more = rs.next();
			if (more) {
				return 1;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	// TODO GET CART BY USER ID
	public Cart getCartByUserID(int idUser) {
		Cart cart = null;
		try {
			pstmt = conn.prepareStatement("select * from cart where ID = ?");
			pstmt.setInt(1, idUser);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt("ID");
				ArrayList<CartItem> list = this.getListCartItemByCartID(ID);
				User user = new UserDAO().getUserByID(ID);
				int total = this.caculateTotalInCart(ID);
				cart = new Cart(ID, user, list, total);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cart;
	}

	// TODO GET LIST CART ITEM BY CART ID
	public ArrayList<CartItem> getListCartItemByCartID(int idCart) {
		ArrayList<CartItem> list = new ArrayList<CartItem>();
		try {
			pstmt = conn.prepareStatement("select * from cartItem where cart_id = ?");
			pstmt.setInt(1, idCart);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int ID = rs.getInt("ID");
				int product_id = rs.getInt("product_id");
				int soLuong = rs.getInt("soluong");
				Product product = new ProductDao().getProductByID(product_id);
				int price = product.getPrice() * soLuong;
				CartItem cartItem = new CartItem(ID, product, soLuong, price);
				list.add(cartItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	// TODO CACULATE TOTAL IN CART
	public int caculateTotalInCart(int cartID) {
		int sum = 0;
		ArrayList<CartItem> list = this.getListCartItemByCartID(cartID);
		for (CartItem cartItem : list) {
			sum = sum + cartItem.getPrice();
		}
		return sum;
	}

	// TODO UPDATE QUANTITY ABOUT PRODUCT IN CART ITEM
	public void updateQuantityAboutProductInCartItem(int cartitemID, int quantity, int cartID) {
		try {
			pstmt = conn.prepareStatement("update cartItem set soluong = ? where ID = ? and cart_id = ?");
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, cartitemID);
			pstmt.setInt(3, cartID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// TODO FIND PRODUCT IN CART ITEM
	public int findProductInCartItem(int productID, int cartID) {
		try {
			pstmt = conn.prepareStatement("select * from cartItem where product_id = ? and cart_id = ?");
			pstmt.setInt(1, productID);
			pstmt.setInt(2, cartID);
			rs = pstmt.executeQuery();
			boolean more = rs.next();
			if (more) {
				return 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return -1;
	}

	// TODO INSERT NEW PRODUCT INTO CART ITEM
	public void insertProductIntoCartitem(int cartitemID, int productID, int quantity, int cartID) {
		try {
			pstmt = conn.prepareStatement("insert into cartItem (ID,product_id,soluong,cart_id) values (?,?,?,?)");
			pstmt.setInt(1, cartitemID);
			pstmt.setInt(2, productID);
			pstmt.setInt(3, quantity);
			pstmt.setInt(4, cartID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// TODO DELETE PRODUCT FROM CART ITEM
	public void deleteProductFromCartItem(int productID, int cartID) {
		try {
			pstmt = conn.prepareStatement("delete from cartItem where product_id = ? and cart_id = ?");
			pstmt.setInt(1, productID);
			pstmt.setInt(2, cartID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// TODO DELELTE CART ITEM BY CART ID
	public void deleteCartItemByCartID(int cartID) {
		try {
			pstmt = conn.prepareStatement("delete from cartItem where cart_id = ?");
			pstmt.setInt(1, cartID);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// TODO DELETE CART BY USER ID
	public void deleteCartByUserID(int user_id) {
		try {
			pstmt = conn.prepareStatement("delete from cart where ID = ?");
			pstmt.setInt(1, user_id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// TODO COUNT CART ITEM BY CART ID
	public int countCartItemByCartID(int cartID) {
		int count = 0;
		try {
			pstmt = conn.prepareStatement("select TOP(1) ID from cartItem where cart_id = ? order by ID DESC; ");
			pstmt.setInt(1, cartID);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	// Code Nhập hàng
	public void insertProduct(String maLoaiHang, String donViTinh, SanPham sp) throws ClassNotFoundException {
//		try {
		try {

			Class.forName(driver);
//				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			Connection con = DriverManager.getConnection(connectionUrl, name, pass);

			// Statement stmt = con.createStatement();

			try (PreparedStatement insert = con.prepareStatement(
					"insert into MatHang (MaMH,Ten,giamua,giaban,NgaySX,SLnhap,slban,ngaynhap, Malh,Madvt) values (?,?,?,?,?,?,?,?,?,?)")) {
				insert.setString(1, sp.getIdSanPham());
				insert.setString(2, sp.getTenSanPham());
				insert.setDouble(3, sp.getDonGia());
				insert.setDouble(4, sp.getDonGia() + 20000);
				insert.setDate(5, null);
				insert.setDate(6, null);
				insert.setInt(7, 100);
				insert.setDate(8, null);
				insert.setString(9, maLoaiHang);
				insert.setString(10, donViTinh);

				insert.executeUpdate();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		CartDao cartDao = new CartDao();
//		Cart cart = cartDao.getCartByUserID(1);
//		ArrayList<CartItem> list = cart.getList();
//		System.out.println(list.size());
		SanPham sanPham = new SanPham("sp2", "Quan thoi trang", 12.3, "Good");
		new CartDao().insertProduct("H2", "USA", sanPham);
//		System.out.println(cartDao.countCartItemByCartID(1));
	}
}
