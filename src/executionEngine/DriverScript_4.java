package executionEngine;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import config.ActionKeywords;
import config.Constants;
import utility.ExcelUtils;

public class DriverScript_4 {
	
	
	private static WebDriver driver = null; 
	public static ActionKeywords keyWordObj;
	public static String currentKeyword;
	public static Method[] actionMethods;
	public static Class actionClass;
	
	//adding OR stuff
	public static Properties OR;
	public static String currentPageObject;
	
	public static void main(String[] args) throws IOException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException {
		
		keyWordObj = new ActionKeywords();
		actionClass = keyWordObj.getClass();
		actionMethods = actionClass.getMethods();
		
		//load content of ObjectRepository file to properties 
		//path of ObjectREpository is added to Constants file
		OR = new Properties(System.getProperties());
		OR.load(new FileInputStream(Constants.path_OR));
		
		String filePath = Constants.path_testData;
		ExcelUtils.setExcelFile(filePath, Constants.sheet_testSteps);
		int methodFoundFlag;
		
		for(Method x:actionMethods)
		{
			System.out.println(x.getName());
		}
		
		for(int i=1;i<10;i++)
		{
			ActionKeywords.waitfor();
			methodFoundFlag =0;
			currentKeyword = ExcelUtils.getCellData(i, Constants.col_ActionKeyword);
			//adding variable to store page objects
			currentPageObject = ExcelUtils.getCellData(i, Constants.col_pageObject);
			for(int j=0;j<actionMethods.length;j++)
			{
				if(actionMethods[j].getName().equals(currentKeyword))
				{
					//passing page object as string to all the methods - now we need to go and update the ActionKeyWords.java to accommodate the page object
					actionMethods[j].invoke(keyWordObj,currentPageObject);
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
