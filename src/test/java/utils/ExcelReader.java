package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelReader {

	private Workbook workbook;

	public String getCellData(String sheetName, int row, int col) throws IOException {
	    FileInputStream fis = new FileInputStream("src/test/resources/sauceLabsTestData.xlsx");
	    Workbook workbook = new XSSFWorkbook(fis);
	    Sheet sheet = workbook.getSheet(sheetName);

	    Row excelRow = sheet.getRow(row);
	    if (excelRow == null) {
	        workbook.close();
	        throw new RuntimeException("Row " + row + " does not exist in sheet: " + sheetName);
	    }

	    Cell cell = excelRow.getCell(col);
	    if (cell == null) {
	        workbook.close();
	        throw new RuntimeException("Cell at row " + row + " and column " + col + " is empty");
	    }

	    String cellValue;
	    switch (cell.getCellType()) {
	        case STRING:
	            cellValue = cell.getStringCellValue();
	            break;
	        case NUMERIC:
	            // Handle numbers as strings (e.g., 12345 → "12345")
	            cellValue = String.valueOf((long) cell.getNumericCellValue());
	            break;
	        case BOOLEAN:
	            cellValue = String.valueOf(cell.getBooleanCellValue());
	            break;
	        case FORMULA:
	            cellValue = cell.getCellFormula();
	            break;
	        case BLANK:
	            cellValue = "";
	            break;
	        default:
	            workbook.close();
	            throw new RuntimeException("Unsupported cell type at row " + row + ", column " + col);
	    }

	    workbook.close();
	    return cellValue;
	}
}
