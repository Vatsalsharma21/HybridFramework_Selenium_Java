package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionKeywords {

	public static WebDriver driver;
	
	public static void open_browser() {
		System.setProperty("webdriver.chrome.driver", Constants.path_chromeDriver);
		driver = new ChromeDriver();
	}
	
	public static void navigate() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.baseURL);
	}
	
	public static void enter_empName() {
		driver.findElement(By.id("empName")).sendKeys("Vatsal");
	}
	
	public static void enter_empNumber() {
		driver.findElement(By.id("empNumber")).sendKeys("7219219940");
	}
	
	public static void enter_Password() {
		driver.findElement(By.id("empPass")).sendKeys("Password");
	}
	
	public static void enter_rePassword() {
		driver.findElement(By.id("empRePass")).sendKeys("Pasword");
	}
	
	public static void click_submit() {
		driver.findElement(By.id("submit")).click();
	}
	
	public static void capture_msg() {
		String resultMsg = driver.findElement(By.id("result")).getText();
		System.out.println(resultMsg);
	}
	
	public static void close_broswer() {
		driver.quit();
	}
	
	public static void waitfor() throws InterruptedException {
		Thread.sleep(3000);
	}
}
