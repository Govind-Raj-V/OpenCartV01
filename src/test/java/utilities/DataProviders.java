package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String path=".\\testData\\logindata.xlsx"; //taking xlFile from testData
		
		ExcelUtility xlUtils=new ExcelUtility(path);
		
		int totalRows=xlUtils.getRowCount("Sheet1");
		int totalCells=xlUtils.getCellCount("Sheet1", 1);
		
		String[][] data=new String[totalRows][totalCells];
		
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCells;j++) {
				data[i-1][j]=xlUtils.getCellData("Sheet1", i, j);
			}
		}
		
		return data;
	}
}
