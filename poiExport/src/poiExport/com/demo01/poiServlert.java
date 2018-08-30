package poiExport.com.demo01;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.util.IOUtils;


/**
 * Servlet implementation class poiServlert
 */
public class poiServlert extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String realPath = request.getServletContext().getRealPath("/");
		System.out.println("realPath --> "+realPath);
		String fileName = request.getParameter("fileName");
		if(fileName==null)
			return ;
		fileName = new String(fileName.getBytes("iso-8859-1"),"utf-8");
		System.out.println(fileName);
		
		ServletContext servletContext = this.getServletContext();
		String mimeType = servletContext.getMimeType(fileName);
		System.out.println("mimeType --> "+mimeType);
		// 获取文件路径
		
		String filePath = servletContext.getRealPath("/")+"down\\"+fileName;
		System.out.println(filePath);
		response.setHeader("Content-Disposition", "attachment;filename="+URLEncoder.encode(fileName, "utf-8")); 
		
		FileInputStream is = new FileInputStream(filePath);
		ServletOutputStream os = response.getOutputStream();
		
		//对copy
		IOUtils.copy(is, os);
		os.flush();
		if(is !=null)
		{
			is.close();
		}
		
		if(os !=null)
		{
			os.close();
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
