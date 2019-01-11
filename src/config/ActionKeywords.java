package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//adding this import to get the static properties loaded in the driver script
import static executionEngine.DriverScript_4.OR;

public class ActionKeywords {

	public static WebDriver driver;
	
	public static void open_browser(String Object) {
		System.setProperty("webdriver.chrome.driver", Constants.path_chromeDriver);
		driver = new ChromeDriver();
	}
	
	public static void navigate(String Object) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.baseURL);
	}
	
	public static void enter_empName(String Object) {
		driver.findElement(By.xpath(OR.getProperty(Object))).sendKeys("Vatsal");
	}
	
	public static void enter_empNumber(String Object) {
		driver.findElement(By.xpath(OR.getProperty(Object))).sendKeys("7219219940");
	}
	
	public static void enter_Password(String Object) {
		driver.findElement(By.xpath(OR.getProperty(Object))).sendKeys("Password");
	}
	
	public static void enter_rePassword(String Object) {
		driver.findElement(By.xpath(OR.getProperty(Object))).sendKeys("Pasword");
	}
	
	public static void click_submit(String Object) {
		driver.findElement(By.xpath(OR.getProperty(Object))).click();
	}
	
	public static void capture_msg(String Object) {
		String resultMsg = driver.findElement(By.xpath(OR.getProperty(Object))).getText();
		System.out.println(resultMsg);
	}
	
	public static void close_broswer(String Object) {
		driver.quit();
	}
	
	public static void waitfor() throws InterruptedException {
		Thread.sleep(3000);
	}
}
