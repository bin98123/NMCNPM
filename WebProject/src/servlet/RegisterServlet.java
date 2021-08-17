package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ThanhVienDAO;
import model.NhanVien;
import model.ThanhVien;

//import beans.User;
//import database.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		String user = request.getParameter("user");
		String psw = request.getParameter("psw");
		String pswrepeat = request.getParameter("psw-repeat");
		if (user.length() > 6) {
			try {
				ThanhVien thanhVien = new NhanVien();
//				User user = new User();
				ThanhVienDAO thanhVienDAO = new ThanhVienDAO();
				if (psw.equals(pswrepeat)) {
					thanhVien.setUserName(request.getParameter("user"));
					thanhVien.setPassword(request.getParameter("psw"));
					if (thanhVienDAO.register(user, psw) > 0) {
						response.sendRedirect("http://localhost:8080/WebProject/admin/login.jsp");
					} else {
						request.setAttribute("err", "this username has already used");
						request.getRequestDispatcher("/admin/register.jsp").forward(request, response);
					}
				} else {
					request.setAttribute("err", "That password doesn't match. Try again");
					request.getRequestDispatcher("/admin/register.jsp").forward(request, response);
				}
			} catch (Throwable theException) {
				response.sendRedirect("http://localhost:8080/WebProject/admin/404.jsp"); // error page
				System.out.println(theException);
			}
		} else {
			request.setAttribute("err", "invalid username");
			request.getRequestDispatcher("/admin/register.jsp").forward(request, response);
		}
	}
}
