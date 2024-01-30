package APITesting;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class H_PostingUsingDataProviderFromExcel {


	@Test(dataProvider = "excelData")
	public void postDataFromExcel(String createdBy,String projectName,String status,String teamSize) {
		System.out.print(createdBy);
		System.out.print(projectName);
		System.out.print(status);
		System.out.print(teamSize);
	}

	public static int ConvertingStringToInt(String numbers) {
		String number=numbers;
		String n="";
		for(int i=0;i<number.length();i++) {
			if(number.charAt(i)>='0' && number.charAt(i)<='9') {
				n+=number.charAt(i);
			}
			else{
				break;
			}
		}
		int conv=Integer.parseInt(n);
		return conv;
	}

	@DataProvider
	public static Object[][] excelData() throws Throwable{
		FileInputStream fis=new FileInputStream("C:\\Users\\1\\Desktop\\Api\\ApiResources\\RMGproject.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet= wb.getSheet("Projects");
		int row =sheet.getLastRowNum();
		System.out.println(row);
		int col=sheet.getRow(1).getLastCellNum();

		Object[][] data=new Object[row][col];
		for(int i=1;i<19;i++) {
			for(int j=0;j<col;j++) {
				try {
				data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				}
				catch(Exception e) {
					data[i][j]=sheet.getRow(i).getCell(j).getNumericCellValue();
				}
			}	
		}
		return data;
	}
}
