package utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFWorkbook testBook;
	private static XSSFSheet testSheet;
	private static XSSFCell dataCell;
	
	public static void setExcelFile(String path, String sheetName) throws IOException {
		FileInputStream testStream = new FileInputStream(path);
		testBook = new XSSFWorkbook(testStream);
		testSheet = testBook.getSheet(sheetName);
	}
	
	public static String getCellData(int rowNum,int colNum) {
		dataCell = testSheet.getRow(rowNum).getCell(colNum);
		String tempData = dataCell.getStringCellValue();
		return tempData;
	}
}
