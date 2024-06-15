package com.comcast.crm.generic.fileUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	public String getDataFromExcel(String sheetNum,int rowNum,int cellNUm) throws Exception
	{
		FileInputStream fis=new FileInputStream("./Testdata/Sheet1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetNum).getRow(rowNum).getCell(cellNUm).getStringCellValue();
		return data;
		
	}
	public int getRowCount(String sheeName) throws Exception {
		FileInputStream fis=new FileInputStream("./Testdata/Sheet1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int rowCount = wb.getSheet(sheeName).getLastRowNum();
		return rowCount;
		
	}
	public void getDataIntoExcel(String sheetName,int rowNum,int cellNum,String data) throws Exception {
		FileInputStream fis=new FileInputStream("./Testdata/Sheet1.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		
		FileOutputStream fos=new FileOutputStream("./Testdata/Sheet1.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}
