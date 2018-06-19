package com.w2a.testcases;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;		
import org.openqa.selenium.WebDriver;		
import org.openqa.selenium.firefox.FirefoxDriver;
public class testngexmp {
        String driverPath="C:/Usb/";
		WebDriver driver;
		String baseUrl;
		@BeforeTest
		public void setUp() throws Exception {
			System.out.println("Launching Firefox browser..");
			System.setProperty("webdriver.gecko.driver",driverPath+"geckodriver.exe"); 
			driver = new FirefoxDriver();
			baseUrl = "http://letskodeit.teachable.com/";
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		@Test
		public void test() {
			driver.get(baseUrl);
			driver.findElement(By.xpath("//div[@id='navbar']//a[@href='/sign_in']")).click();
			System.out.println("Clicked on login");
			driver.findElement(By.id("user_email")).sendKeys("test@email.com");
			System.out.println("Sending keys to username field");
			driver.findElement(By.id("user_password")).sendKeys("test");
			System.out.println("Sending keys to password field");
			driver.findElement(By.id("user_email")).clear();
			System.out.println("Clearing the username field");
		}
		@AfterTest
		public void tearDown() throws Exception {
			 driver.quit();
		}
}