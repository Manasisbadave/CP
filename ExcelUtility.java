package Erp.Automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static XSSFWorkbook getFileHandle() throws IOException {
		String excelFile = System.getProperty("user.dir");
		File fileName = new File(excelFile + "/src/test/resources/testdata/LoginData.xlsx");
		System.out.println(fileName);
		FileInputStream fis = new FileInputStream(fileName);
		XSSFWorkbook book = new XSSFWorkbook(fis);
		return book;

	}

	public static Object[][] readDataFromExcel(XSSFSheet sheetname) throws EncryptedDocumentException, IOException {

		int rowCount = sheetname.getLastRowNum();
		// int columnCount =2;
		int columnCount = sheetname.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][columnCount];

		for (int r = 0; r < rowCount; r++) {
			XSSFRow row = sheetname.getRow(r + 1);

			if (row == null) {
				throw new RuntimeException("Row not found");
			}

			for (int c = 0; c < columnCount; c++) {
				XSSFCell cell = row.getCell(c);

				if (cell == null) {
					throw new RuntimeException("Cell not found");
				}
				String cellValue = ExcelUtility.getCellValueAsString(cell);
				data[r][c] = cellValue;
			}
		}
		return data;
	}

	public static String getCellValueAsString(Cell cell) {

		String cellValue = "";

		if (cell != null) {
			switch (cell.getCellType()) {
			case STRING:
				cellValue = cell.getStringCellValue();
				break;
			case NUMERIC:
				cellValue = Integer.toString((int) cell.getNumericCellValue());
				break;
			case BOOLEAN:
				cellValue = String.valueOf(cell.getBooleanCellValue());
				break;
			default:
				break;
			}
		}
		return cellValue;
	}
}
