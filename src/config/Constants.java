package config;

public class Constants {

	//Base URL strings
	public static final String baseURL = System.getProperty("user.dir") + "\\TestWebpage\\index.html";
	
	//Several paths used within the code
	public static final String path_testData = System.getProperty("user.dir") + "\\src\\dataEngine\\DataEngine.xlsx";
	public static final String file_testData = "DataEngine.xlsx";
	public static final String path_chromeDriver = System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";
	public static final String path_OR = System.getProperty("user.dir") + "\\src\\config\\ObjectRepository.txt";
	
	
	//column numbers for different fields
	public static final int col_testcaseID = 0;
	public static final int col_testStepID = 1;
	public static final int col_ActionKeyword = 4;
	public static final int col_pageObject = 3;
	public static final int col_runMode = 2;
	
	//Test sheet name
	public static final String sheet_testSteps = "TestSteps";
	public static final String sheet_testCases = "TestCases";
	
}
