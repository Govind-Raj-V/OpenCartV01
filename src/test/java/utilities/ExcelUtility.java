package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	public FileInputStream  fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cel;
	public CellStyle style;
	String path;
	
	public ExcelUtility(String path){
		this.path=path;
	}
	
	public int getRowCount(String sheetname) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		int rowCount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;
		
	}
	
	public int getCellCount(String sheetname, int rownum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		int cellCount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;
		
	}
	
	public String getCellData(String sheetname,int rownum,int cellnum) throws IOException {
		fi=new FileInputStream(path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetname);
		row=sheet.getRow(rownum);
		cel=row.getCell(cellnum);
		
		DataFormatter formatter=new DataFormatter();
		String data;
		
		try {
			data=formatter.formatCellValue(cel); 
			//This line of code return the cell value in the form of string
		}
		catch (Exception e){
			data=" ";
		}
		
		workbook.close();
		fi.close();
		return data;
		
	}
	
	public void setCellData(String sheetname, int rownum, int cellnum, String data) throws IOException {

		File xlFile = new File(path);

		if (!xlFile.exists()) {
			workbook = new XSSFWorkbook();
			fo = new FileOutputStream(path);
			workbook.write(fo);
		} else {

			fi = new FileInputStream(path);
			workbook = new XSSFWorkbook(fi);
		}

		if (workbook.getSheetIndex(sheetname) == -1)
			// If sheet not exist then it will create a new sheet
			workbook.createSheet(sheetname);

		sheet = workbook.getSheet(sheetname);

		if (sheet.getRow(rownum) == null)
			// If row not exist then it will create a new row
			sheet.createRow(rownum);

		row = sheet.getRow(rownum);

		cel = row.createCell(cellnum);
		cel.setCellValue(data);

		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();

	}

}


