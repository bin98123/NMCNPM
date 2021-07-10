package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DonViTinhDao;
import dao.LoaiHangDao;
import dao.SanPhamDao;
import model.DonViTinh;
import model.LoaiHang;
import model.SanPham;

/**
 * Servlet implementation class QuanLiSanPham
 */
@WebServlet("/QuanLiSanPham")
public class QuanLiSanPham extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public QuanLiSanPham() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sumbit=request.getParameter("sumbit");
		if(sumbit.equalsIgnoreCase("delete")) {
			String id=request.getParameter("productID");
			SanPham sanPham=null;
			 SanPhamDao sanPhamDao=null;
			try {
				sanPhamDao=new SanPhamDao();
				 sanPham=new SanPhamDao().getByKey(id);
				
				 sanPhamDao.delete(sanPham);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			response.sendRedirect("http://localhost:8080/WebProject/admin/SanPham.jsp");
			
		}else if(sumbit.equalsIgnoreCase("edit")) {
			String id=request.getParameter("productID");
			SanPham sanPham=null;
			try {
				 sanPham=new SanPhamDao().getByKey(id);
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("sanpham", sanPham);
			request.getRequestDispatcher("/admin/SuaSanPham.jsp").forward(request, response);
		}else if(sumbit.equalsIgnoreCase("deleteall")) {
			
			
			try {
				 SanPhamDao sanPhamDao=new SanPhamDao();
				 sanPhamDao.deleteAllProduct();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			request.getRequestDispatcher("/admin/SanPham.jsp").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String action =request.getParameter("action");
	
	if(action.equalsIgnoreCase("continue")) {
		String MaMh = request.getParameter("productName");
		String Ten = request.getParameter("productType");
		String giamua = request.getParameter("thuocnhom");
		String giaban = request.getParameter("productPrice");
		String soluongnhap = request.getParameter("tonkho");
		String soluongban = request.getParameter("description");
		String Malh = request.getParameter("malh");
		String Madvt = request.getParameter("madvt");
		
		try {
			LoaiHang loaiHang
			=new LoaiHangDao().getByKey(Malh);
			DonViTinh donViTinh=new DonViTinhDao().getByKey(Madvt);
			SanPham sanPham=new SanPham(MaMh, Ten, Double.parseDouble(giamua),  Double.parseDouble(giaban),Integer.parseInt(soluongnhap) ,Integer.parseInt(soluongban), loaiHang, donViTinh);
			SanPhamDao sanPhamDao=new SanPhamDao();
			sanPhamDao.insert(sanPham);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		response.sendRedirect("http://localhost:8080/WebProject/admin/SanPham.jsp");
	}else if(action.equalsIgnoreCase("edittext")) {
		String id=request.getParameter("id");
		
		String Ten = request.getParameter("productType");
		String giamua = request.getParameter("thuocnhom");
		String giaban = request.getParameter("productPrice");
		String soluongnhap = request.getParameter("tonkho");
		String soluongban = request.getParameter("description");
		
		
		try {
			SanPhamDao sanPhamDao=new SanPhamDao();
			SanPham sanPham=sanPhamDao.getByKey(id);
			String Malh = sanPham.getLoaihang().getMaLh();
			String Madvt = sanPham.getDvt().getMaDvt();
			LoaiHang loaiHang
			=new LoaiHangDao().getByKey(Malh);
			DonViTinh donViTinh=new DonViTinhDao().getByKey(Madvt);
			SanPham sanPham2=new SanPham(id, Ten, Double.parseDouble(giamua),  Double.parseDouble(giaban),Integer.parseInt(soluongnhap) ,Integer.parseInt(soluongban), loaiHang, donViTinh);
			sanPhamDao.update(sanPham2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("http://localhost:8080/WebProject/admin/SanPham.jsp");
	}

			
	
	}
	}
