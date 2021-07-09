package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ThanhVienDAO;
import model.QuanLi;
import model.ThanhVien;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login View")
public class LoginView extends HttpServlet {
	private ThanhVienDAO thanhVienDAO;
	private ThanhVien thanhVien;

//	private loginDAO loginDAO;
	private static final long serialVersionUID = 1L;
//	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=Shop;user=sa;password=root";
	private String connectionUrl = "jdbc:mysql://sql6.freemysqlhosting.net:3306/sql6418049";
	private String name = "sql6418049";
	private String pass = "gV4INX5cWB";

	// private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private String driver = "com.mysql.jdbc.Driver";

	public LoginView() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean ok = false;
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("Password");
		thanhVienDAO = new ThanhVienDAO();
//		loginDAO = new loginDAO();
//		loginDAO.setUserName(userName);
//		loginDAO.setUserPassword(userPassword);
		thanhVien = new QuanLi();
		thanhVien.setUserName(userName);
		thanhVien.setPassword(userPassword);

		if (userName != null && userPassword != null || userName != "" && userPassword != "") {
			ok = true;
		}
		try {
			if (ok == true) {
				boolean login = thanhVienDAO.getLogin(thanhVien.getUserName(), thanhVien.getPassword());

				if (login == true) {
					request.getRequestDispatcher("/WelcomeUser.jsp").forward(request, response);
				} else {
					// username: 'bin98123'
					// password: 'quockhanh'
//					String userDetails = "Invalid Username or Password. Username and Password are case-sensitive.";
					String userDetails = "Invalid Username or Password.";
					request.setAttribute("Invalid", userDetails);
					request.getRequestDispatcher("/login.jsp").forward(request, response);

				}
			} else {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}
