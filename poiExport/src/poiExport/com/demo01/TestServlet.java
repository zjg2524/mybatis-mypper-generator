package poiExport.com.demo01;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 * Servlet implementation class TestServlet
 */
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("进入 test servlet.........................");
//		byte[] createExcel = Test.createExcel();
		ByteArrayOutputStream temlateExcel =null;
		try {
			temlateExcel = Test.temlateExcel(request);
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String fileName = "elong酒店映射"+dateToString(new Date())+".xlsx";
//		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "utf-8")); 
//		ServletOutputStream outputStream = response.getOutputStream();
//		outputStream.write(createExcel);
		
		new DownloadUtil().download(temlateExcel, response, request, fileName);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public String dateToString(Date date)
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd_HHmm");
		return format.format(date);
	}

}
