package dataDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataPovider {
	
	DataFormatter formatter = new DataFormatter();
	
	@Test(dataProvider="drivetest")
	public void testCaseData(String greeting, String comm, String id)
	{
		System.out.println(greeting+comm+id);		
		
	}
	
	@DataProvider(name="drivetest")
	public Object[][] getData() throws IOException
	{
		
		FileInputStream fis = new FileInputStream("C:\\Users\\oscar\\OneDrive\\Documents\\excelDriven.xlsx");
													//C:\\Users\\oscar\\OneDrive\\Documents\\excelDriven.xlsx
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row = sheet.getRow(0);
		int colcount = row.getLastCellNum();
		Object data[][]= new Object[rowCount-1][colcount];
		
		for (int i=0 ; i<rowCount-1;i++) 
		{
			row= sheet.getRow(i+1);
			for (int j=0; j<colcount;j++)
			{
				XSSFCell cell = row.getCell(j);
				formatter.formatCellValue(cell);
				data[i][j]= formatter.formatCellValue(cell);
				//System.out.println(row.getCell(j));
				
			}
			
		}
		
		
		return data;
		
		
		//return data;
	}

}
