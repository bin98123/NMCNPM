package ImportFileEX;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.StringTokenizer;

import dao.DonViTinhDao;
import dao.LoaiHangDao;
import dao.SanPhamDao;
import model.DonViTinh;
import model.LoaiHang;
import model.SanPham;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelProduct {
	public static String FormatID(String s) {
		return s.substring(1, s.length() - 1);
	}

	public static String FormatNumber(String s) {
		StringTokenizer st = new StringTokenizer(s, ".");
		return st.nextToken();
	}

	public static String FormatDate(String s) {
		String[] s2 = s.split("/");
		String day = s2[0];
		String month = s2[1];
		String year = s2[2];
		return year + "-" + month + "-" + day;
	}

	public  void InsertByExcel() throws IOException, SQLException {
	SanPhamDao sanPhamDao=new SanPhamDao();
		// obtaining input bytes from a file
//		FileInputStream fis = new FileInputStream(new File("WebContent\\file\\importEX.xlsx"));
		FileInputStream fis = new FileInputStream(new File("E:\\LTW\\projectCNPM\\NMCNPM\\WebProject\\WebContent\\file\\importEX.xlsx"));
		// creating workbook instance that refers to .xls file
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		// creating a Sheet object to retrieve the object
		XSSFSheet sheet = wb.getSheetAt(0);
		// evaluating cell type
		for (int i = 0; i <= sheet.getLastRowNum(); i++) // iteration over row using for each loop
		{
			Row row = sheet.getRow(i);
			if (row.getRowNum() == 0) {
				continue;
			} else {
				String  MaMh = row.getCell(0).getStringCellValue();
				String Ten = row.getCell(1).getStringCellValue();
				double  giamua =row.getCell(2).getNumericCellValue();
				double  giaban =row.getCell(3).getNumericCellValue();
				int  soluongnhap =(int) row.getCell(4).getNumericCellValue();
				int  soluongban =(int) row.getCell(5).getNumericCellValue();
				String Malh =row.getCell(6).getStringCellValue();
				String Madvt = row.getCell(7).getStringCellValue();
				LoaiHang loaiHang
				=new LoaiHangDao().getByKey(Malh);
				DonViTinh donViTinh=new DonViTinhDao().getByKey(Madvt);
				SanPham sanPham=new SanPham(MaMh, Ten, giamua, giaban,soluongnhap ,soluongban, loaiHang, donViTinh);
				
				sanPhamDao.insert(sanPham);
				
				System.out.println(MaMh + "\t" + Ten + "\t" + giamua + "\t" + giaban);
			}
		}
		wb.close();
	}
public static void main(String[] args) throws IOException, SQLException {
	ExcelProduct excelProduct=new ExcelProduct();
	
	excelProduct.InsertByExcel();
}
}
