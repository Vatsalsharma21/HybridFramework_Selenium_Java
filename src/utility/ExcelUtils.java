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
	
	public static void setExcelFile(String path) throws IOException {
		FileInputStream testStream = new FileInputStream(path);
		testBook = new XSSFWorkbook(testStream);
		
	}
	
	public static String getCellData(int rowNum,int colNum, String sheetName) {
		testSheet = testBook.getSheet(sheetName);
		dataCell = testSheet.getRow(rowNum).getCell(colNum);
		String tempData = dataCell.getStringCellValue();
		return tempData;
	}
	
	//function to get the row count in a sheet
	public static int getRowCount(String sheetName)
	{
		testSheet = testBook.getSheet(sheetName);
		int rowCount = testSheet.getLastRowNum() + 1;
		return rowCount;
	}
	
	//Method to get the row number of the Test case from the ** sheet
	//takes three arguments TC_name,colNum,SheetName
	public static int getRowContains(String testCaseName,int colNum,String sheetName) {
		int lastRow = ExcelUtils.getRowCount(sheetName);
		int i;
		for(i=0;i<lastRow;i++)
		{
			if(ExcelUtils.getCellData(i, colNum, sheetName).equalsIgnoreCase(testCaseName))
			break;
		}
		return i;
	}
	
	//Method to return the count of testSteps in a particular testcase
	//takes three arguments : sheetName,testCaseID,testcaseStart
	public static void getTestStepsCount(String sheetName,String testCaseID,int startRow)
	{
		
	}
}
