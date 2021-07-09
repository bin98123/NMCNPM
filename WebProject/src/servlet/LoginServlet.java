package servlet;

import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.VerifyRecaptcha;
import database.UserDAO;
import model.NhanVien;
import model.ThanhVien;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns = { "/LoginServlet" })
public class LoginServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		String gRecaptchaResponse = request.getParameter("g-recaptcha-response");
		boolean verify = VerifyRecaptcha.verify(gRecaptchaResponse);
//		User user = new User();
		NhanVien user = new NhanVien();
		user.setUserName(request.getParameter("uname"));
		user.setPassword(request.getParameter("psw"));
//		user.getUserName()
		if (UserDAO.login(request.getParameter("uname"), request.getParameter("psw")) == true) {
			HttpSession session = request.getSession(true);
			UserDAO dao = new UserDAO();
			try {
				user = dao.login(user);
				System.out.println(user);
				session.setAttribute("currentSessionUser", user);
				response.sendRedirect("http://localhost:8080/WebProject/user/index.jsp"); // logged-in page
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			request.setAttribute("err", "wrong username or password");
			RequestDispatcher rd = request.getRequestDispatcher("/user/login.jsp");
			rd.include(request, response);
		}
	}
}
