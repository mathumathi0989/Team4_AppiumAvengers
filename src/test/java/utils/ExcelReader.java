package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

	   public static String getCellData(String sheetName, int row, int col) throws IOException {
		   FileInputStream fis = new FileInputStream("src/main/resources/testdata.xlsx");
	        Workbook workbook = new XSSFWorkbook(fis);
	        Sheet sheet = workbook.getSheet(sheetName);
	        String data = sheet.getRow(row).getCell(col).getStringCellValue();
	        workbook.close();
	        return data;
	    }
	   
}
