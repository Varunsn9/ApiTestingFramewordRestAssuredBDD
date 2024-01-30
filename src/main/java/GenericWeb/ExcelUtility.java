package GenericWeb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

public class ExcelUtility {
	
	public String readDatafromAStringCell(String sheet,int row,int cell) throws Throwable {
	
		FileInputStream fis=new FileInputStream(new File("C:\\Users\\1\\eclipse-workspace\\APITestingFrameWord\\src\\test\\resources\\ApiResources\\RMGproject.xlsx"));
		Workbook wb=WorkbookFactory.create(fis);
		Cell cel=wb.getSheet(sheet).getRow(row).getCell(cell);
		String cellValue=cel.getStringCellValue();
		return cellValue;
		
	}
	
	@Test 
	public void readData() throws Throwable {
		Workbook wb=new XSSFWorkbook();
        // Create a Sheet
        Sheet sheet = wb.createSheet("Sheet1");

        // Create a Row
        Row headerRow = sheet.createRow(0);

        // Create cells and set headers
        String[] headers = {"Name", "Age", "City"};
        for (int i = 0; i < headers.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(headers[i]);
        }

        // Create some data rows
        Object[][] data = {
                {"John Doe", 30, "New York"},
                {"Jane Smith", 25, "San Francisco"},
                {"Tom Johnson", 35, "Chicago"}
        };
        int rowIndex = 1;
        for (Object[] rowData : data) {
            Row row = sheet.createRow(rowIndex++);
            int cellIndex = 0;
            for (Object field : rowData) {
                Cell cell = row.createCell(cellIndex++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
                // You can add more conditions for different types as needed
            }
        }

        // Write the output to a file
        try (FileOutputStream fileOut = new FileOutputStream("workbook.xlsx")) {
            wb.write(fileOut);
            System.out.println("Excel file has been created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 
}
