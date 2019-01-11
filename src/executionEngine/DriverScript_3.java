package executionEngine;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;

import config.ActionKeywords;
import utility.ExcelUtils;

public class DriverScript_3 {
	// Declare webdriver variable
	private static WebDriver driver = null; 
	//1. declare an object for ActionKeywordClass
	public static ActionKeywords keyWordObj;
	public static String currentKeyword;
	
	//2. declare an array of methods to store all the methods present in ActionKeywordClass
	public static Method[] actionMethods;
	public static Class actionClass;
	
	public static void main(String[] args) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException {
		//Creating an object of ActionKeyWords Class
		keyWordObj = new ActionKeywords();
		// TODO Auto-generated method stub
		//upgrade for DriverScript_2
		//We will try to execute the methods using reflections class
		//3. We get the class from the class object of ActionKeyword
		actionClass = keyWordObj.getClass();
		
		//4. Store all the methods present in this class in an array
		actionMethods = actionClass.getMethods();
		
		//5.Setting path for excel Sheet
		String filePath = System.getProperty("user.dir") + "\\src\\dataEngine\\DataEngine.xlsx";
		ExcelUtils.setExcelFile(filePath, "TestSteps");
		int methodFoundFlag;
		
		for(Method x:actionMethods)
		{
			System.out.println(x.getName());
		}
		
		//now we read the excel sheet for methods and then invoke them manually as and when found
		for(int i=1;i<10;i++)
		{
			ActionKeywords.waitfor();
			methodFoundFlag =0;
			currentKeyword = ExcelUtils.getCellData(i, 3);
			for(int j=0;j<actionMethods.length;j++)
			{
				if(actionMethods[j].getName().equals(currentKeyword))
				{
					actionMethods[j].invoke(keyWordObj);
					methodFoundFlag =1;
					continue;
				}
			}
			if(methodFoundFlag == 0)
			{
				System.out.println("Method Mentioned : " + currentKeyword + " is not defined in the ActionKeywords.java");
			}
		}
		
	}

}
