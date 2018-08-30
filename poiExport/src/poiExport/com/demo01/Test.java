package poiExport.com.demo01;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import poiExport.com.demo01.entity.ElongHotelMappingEntity;


public class Test {
	
	
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		String sname = "中国china";
		bos.write(sname.getBytes());
		
		System.out.println("==================================");
		byte[] byteArray = bos.toByteArray();
		System.out.println(byteArray);
		System.out.println("***********************************");
		System.out.println(new String(byteArray));
	}
	
	public static byte[]  createExcel() throws IOException
	{
		// 创建Excel的工作书册 Workbook,对应到一个excel文档
//				HSSFWorkbook wb = new HSSFWorkbook();
				XSSFWorkbook wb = new XSSFWorkbook();
				// 创建Excel的工作sheet,对应到一个excel文档的tab
				XSSFSheet sheet = wb.createSheet("sheet1");
				XSSFRow header = sheet.createRow(0);
				header.createCell(0).setCellValue("酒店编码");
				header.createCell(1).setCellValue("酒店名称");
				header.createCell(2).setCellValue("房型编码");
				header.createCell(3).setCellValue("房型名称");
				
				
				for(int i=0;i<10000;i++)
				{
					XSSFRow row = sheet.createRow(i + 1);
					row.createCell(0).setCellValue("b000000001");
					row.createCell(1).setCellValue("北京天上人间");
					row.createCell(2).setCellValue("r0120");
					row.createCell(3).setCellValue("总统套间");
					
				}
				
				
				//表格自动宽度设置
				sheet.autoSizeColumn((short)0);
		        sheet.autoSizeColumn((short)1);
		        sheet.autoSizeColumn((short)2);
		        sheet.autoSizeColumn((short)3);
		        sheet.autoSizeColumn((short)4);
		        sheet.autoSizeColumn((short)5);
		        sheet.autoSizeColumn((short)6);
		        
		        
		        ByteArrayOutputStream output = new ByteArrayOutputStream();
		        wb.write(output);
				output.flush();
				byte[] byteArray = output.toByteArray();
				output.close();
				return byteArray;
	}
	
	public static ByteArrayOutputStream temlateExcel(HttpServletRequest request) throws IOException, InvalidFormatException
	{
		// 创建Excel的工作书册 Workbook,对应到一个excel文档
//				HSSFWorkbook wb = new HSSFWorkbook();
		ServletContext servletContext = request.getServletContext();
		String projectPath = servletContext.getRealPath("/");
		
		String filePath = projectPath+"down\\elong酒店映射模板.xlsx";
		FileInputStream is = new FileInputStream(filePath);
				XSSFWorkbook wb = new XSSFWorkbook(is);
				XSSFSheet sheet = wb.getSheetAt(0);
				
				// 单元格通用样式
				XSSFCellStyle styleTemplate = wb.createCellStyle();
				
				//下边框
				styleTemplate.setBorderBottom(HSSFCellStyle.BORDER_THIN); 
				
				//左边框
				styleTemplate.setBorderLeft(HSSFCellStyle.BORDER_THIN);
				
				//上边框
				styleTemplate.setBorderTop(HSSFCellStyle.BORDER_THIN);
				
				//右边框
				styleTemplate.setBorderRight(HSSFCellStyle.BORDER_THIN);
				
				// 居中
				styleTemplate.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				
				List<ElongHotelMappingEntity> createMappingData = createMappingData();
				for(int i=0;i<createMappingData.size();i++)
				{
					XSSFRow row = sheet.createRow(i + 1);
					ElongHotelMappingEntity entity = createMappingData.get(i);
					
					XSSFCell createCell0 = row.createCell(0);
					createCell0.setCellStyle(styleTemplate);
					createCell0.setCellValue(entity.getElongHotelId());
					
					XSSFCell createCell1 = row.createCell(1);
					createCell1.setCellStyle(styleTemplate);
					createCell1.setCellValue(entity.getElongHotelName());
					
					XSSFCell createCell2 = row.createCell(2);
					createCell2.setCellStyle(styleTemplate);
					createCell2.setCellValue(entity.getFcHotelId());
					
					XSSFCell createCell3 = row.createCell(3);
					createCell3.setCellStyle(styleTemplate);
					createCell3.setCellValue(entity.getFcHotelName());
					
					XSSFCell createCell4 = row.createCell(4);
					createCell4.setCellStyle(styleTemplate);
					createCell4.setCellValue(entity.getElongRoomId());
					
					XSSFCell createCell5 = row.createCell(5);
					createCell5.setCellStyle(styleTemplate);
					createCell5.setCellValue(entity.getElongRoomName());
					
					XSSFCell createCell6 = row.createCell(6);
					createCell6.setCellStyle(styleTemplate);
					createCell6.setCellValue(entity.getFcRoomId());
					
					XSSFCell createCell7 = row.createCell(7);
					createCell7.setCellStyle(styleTemplate);
					createCell7.setCellValue(entity.getFcRoomName());
					
					XSSFCell createCell8 = row.createCell(8);
					createCell8.setCellStyle(styleTemplate);
					createCell8.setCellValue(entity.getFcRatePlanId());
					
					XSSFCell createCell9 = row.createCell(9);
					createCell9.setCellStyle(styleTemplate);
					createCell9.setCellValue(entity.getFcRatePlanName());
					
				}
				
				
				//表格自动宽度设置
				sheet.autoSizeColumn(0);
		        sheet.autoSizeColumn(1);
		        sheet.autoSizeColumn(2);
		        sheet.autoSizeColumn(3);
		        sheet.autoSizeColumn(4);
		        sheet.autoSizeColumn(5);
		        sheet.autoSizeColumn(6);
		        sheet.autoSizeColumn(7);
		        sheet.autoSizeColumn(8);
		        sheet.autoSizeColumn(9);
		        
		        
		        ByteArrayOutputStream output = new ByteArrayOutputStream();
		        wb.write(output);
				output.flush();
//				byte[] byteArray = output.toByteArray();
//				output.close();
//				return byteArray;
				
				return output;
	}
	
	
	public static List<ElongHotelMappingEntity> createMappingData()
	{
		ArrayList<ElongHotelMappingEntity> list = new ArrayList<ElongHotelMappingEntity>();
		
		ElongHotelMappingEntity elongHotelMappingEntity1 = new ElongHotelMappingEntity("10001", "北京天上人间", "c889412", "北京天上人间", "0120", "总统套房", "496670", "超级豪华间", "rp12487", "super");
		ElongHotelMappingEntity elongHotelMappingEntity2 = new ElongHotelMappingEntity("10002", "华府酒店", "c4242422", "华府酒店", "4589", "大床房", "70", "大床房", "rp12487", "super");
		ElongHotelMappingEntity elongHotelMappingEntity3 = new ElongHotelMappingEntity("10008", "桔子酒店桔子酒店桔子酒店桔子酒店桔子酒店桔子酒店桔子酒店桔子酒店", "c7879875", "桔子酒店", "0120", "总统套房", "496670", "超级豪华间", "rp12487", "super");
		list.add(elongHotelMappingEntity1);
		list.add(elongHotelMappingEntity2);
		list.add(elongHotelMappingEntity3);
		return list;
	}

}
