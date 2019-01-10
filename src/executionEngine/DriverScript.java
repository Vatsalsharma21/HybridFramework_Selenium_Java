package executionEngine;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverScript {
	// Declare webdriver variable
	private static WebDriver driver = null; 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1. Assign value to webdriver variable
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//2. Open Sample Website
		driver.get(System.getProperty("user.dir") + "\\TestWebPage\\index.html");
		driver.manage().window().maximize();
		//3. Enter Employee Name
		driver.findElement(By.id("empName")).sendKeys("Vatsal");
		//4. Enter Employee Mobile Number
		driver.findElement(By.id("empNumber")).sendKeys("7219219940");
		//5. Enter Password
		driver.findElement(By.id("empPass")).sendKeys("Password");
		//6. Enter the password again 
		driver.findElement(By.id("empRePass")).sendKeys("Password");
		//7. Click on submit button
		driver.findElement(By.id("submit")).click();
		//8. Verify Employee registered successfully message is displayed
		//9. Close the browser
		driver.quit();
		
	}

}
