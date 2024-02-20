package dataDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataPovider {
	
	@Test(dataProvider="drivetest")
	public void testCaseData(String greeting, String comm, int id)
	{
		System.out.println(greeting+comm+id);
		
		
	}
	
	@DataProvider(name="drivetest")
	public Object[][] getData() throws IOException
	{
		//Object[][] data= {{"Hello","Text","1"},{"Hello2","Text2","143"},{"Hello3","Text3","485"}};
		FileInputStream fis = new FileInputStream("C:\\Users\\oscar\\OneDrive\\excelDriver.xslx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		return null;
		
		
		//return data;
	}

}
