package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page_Objects {
	WebDriver driver= null;

	By locate_email = By.name("userEmail");
	By locate_password = By.name("userPassword");
	By locate_login = By.xpath("//*[@id=\"first\"]/div[3]/button");


	public void enter_email(String text) {
		driver.findElement(locate_email).sendKeys(text);
			
	}

	public void enter_password(String text1) {
		driver.findElement(locate_password).sendKeys(text1);
			
	}
	
	public void click_login() {
		driver.findElement(locate_login).click();
			
	}
	
}
