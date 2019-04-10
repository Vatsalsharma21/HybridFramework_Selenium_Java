//package executionEngine;
//
//import java.io.IOException;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import config.ActionKeywords;
//import utility.ExcelUtils;
//
//public class DriverScript_2 {
//	// Declare webdriver variable
//	private static WebDriver driver = null;
//
//	public static void main(String[] args) throws IOException {
//		// TODO Auto-generated method stub
//		//This is an upgrade to the previous DriverScript where we ran the code directly
//		//now we will be using the ActionKeyword class to do the same and also we will be reading the steps from ExcelSheet using ExcelUtils
//		//1. Setting up Excelsheet file path
//		String filePath = System.getProperty("user.dir") + "\\src\\dataEngine\\DataEngine.xlsx";
//		//2. Setting up the SheetName for processing(to be read)
//		ExcelUtils.setExcelFile(filePath, "TestSteps");
//
//		//3. reading the teststeps for our testcase, currently we have just once case so we are having hard coded values
//		for(int i=1;i<10;i++)
//		{
//			String currentAction = ExcelUtils.getCellData(i, 3);
//			if(currentAction.equals("open_browser"))
//			{
//				ActionKeywords.open_browser();
//			}
//			else if(currentAction.equals("navigate"))
//			{
//				ActionKeywords.navigate();
//			}
//			else if(currentAction.equals("enter_empName"))
//			{
//				ActionKeywords.enter_empName();
//			}
//			else if(currentAction.equals("enter_empNumber"))
//			{
//				ActionKeywords.enter_empNumber();
//			}
//			else if(currentAction.equals("enter_Password"))
//			{
//				ActionKeywords.enter_Password();
//			}
//			else if(currentAction.equals("enter_rePassword"))
//			{
//				ActionKeywords.enter_rePassword();
//			}
//			else if(currentAction.equals("click_submit"))
//			{
//				ActionKeywords.click_submit();
//			}
//			else if(currentAction.equals("capture_msg"))
//			{
//				ActionKeywords.capture_msg();
//			}
//			else if(currentAction.equals("close_broswer"))
//			{
//				ActionKeywords.close_broswer();
//			}
//			else
//			{
//				System.out.println("Action Method Mentioned in the steps is not defined in the ActionKeyword File.");
//			}
//
//		}
//	}
//
//}
