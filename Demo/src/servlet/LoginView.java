package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.User;
import dao.loginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login View")
public class LoginView extends HttpServlet {
	private User user;
	private loginDAO userDAO;
	private static final long serialVersionUID = 1L;
	private String connectionUrl = "jdbc:sqlserver://localhost:1433;" + "databaseName=Shop;user=sa;password=root";
	private String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";

	public LoginView() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean ok = false;
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("Password");
		user = new User();
		userDAO = new loginDAO();
		userDAO.setUserName(userName);
		userDAO.setUserPassword(userPassword);

		if (userName != null && userPassword != null || userName != "" && userPassword != "") {
			ok = true;
		}
		try {
			if (ok == true) {
				boolean login = user.getLogin(userDAO.getUserName(), userDAO.getUserPassword());

				if (login == true) {
					request.getRequestDispatcher("/WelcomeUser.jsp").forward(request, response);
				} else {
					// username: 'Khanh'
					// password: '12345'
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
