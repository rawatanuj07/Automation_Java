package test;
import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.Login_Page_Objects;

public class Login_Test {
	private static final TimeUnit SECONDS = null;
	WebDriver driver = null;
	

	@BeforeTest
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
	
	}
	
	@Test
	public void a_test() {
		Login_Page_Objects obj= new Login_Page_Objects(driver);
	
		driver.get("https://www.inuvest.tech/auth");
		obj.enter_email("wrong_email");
		obj.enter_password("Internshala@123");
		obj.click_login();
		String expectedUrl = "https://inuvest.tech";
		String actualUrl = "https://inuvest.tech/dashboard/liveStrategies";
		assertEquals(actualUrl, expectedUrl, "Url is mismatched");
		
		}
	
	
	@Test
	public void b_test() {
		Login_Page_Objects obj= new Login_Page_Objects(driver);
	
		driver.get("https://www.inuvest.tech/auth");
		obj.enter_email("testprofile@inuvest.tech");
		obj.enter_password("wrong password");
		obj.click_login();
		String expectedUrl = "https://inuvest.tech";
		String actualUrl = "https://inuvest.tech/dashboard/liveStrategies";
		assertEquals(actualUrl, expectedUrl, "Url is mismatched");
		}
	
	
	@Test
	public void c_test() {
		Login_Page_Objects obj= new Login_Page_Objects(driver);
	
		driver.get("https://www.inuvest.tech/auth");
		obj.enter_email("wrong_email");
		obj.enter_password("wrong_password");
		obj.click_login();
		String expectedUrl = "https://inuvest.tech";
		String actualUrl = "https://inuvest.tech/dashboard/liveStrategies";
		assertEquals(actualUrl, expectedUrl, "Url is mismatched");
		}
	
	@Test
	public void d_test() {
		Login_Page_Objects obj= new Login_Page_Objects(driver);
	
		driver.get("https://www.inuvest.tech/auth");
		obj.enter_email("testprofile@inuvest.tech");
		obj.enter_password("Internshala@123");
		obj.click_login();
		
		String actualUrl = driver.getCurrentUrl();

		String expectedUrl = "https://inuvest.tech/dashboard/liveStrategies";
		
		assertEquals(actualUrl, expectedUrl, "Url is mismatched");
	}
	
	@Test
	public void e_test() {
		
		driver.get("https://inuvest.tech");
		driver.findElement(By.xpath("/html/body/app-root/nb-layout/nb-layout-column/div/div/app-home/div/div[3]/button[3]")).click();
		

		WebElement element = driver.findElement(By.xpath("/html/body/app-root/nb-layout/nb-layout-column/div/div/app-home/div/div[3]/button[3]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	@AfterTest
	public void teardown() {
//		
//		driver.close();
	}
}