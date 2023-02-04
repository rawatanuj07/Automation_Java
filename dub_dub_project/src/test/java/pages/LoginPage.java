package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver= null;
	
	By locate_email = By.xpath("//*[@id=\"root\"]/div/div/div[1]/input");
	By locate_password = By.xpath("//*[@id=\"root\"]/div/div/div[2]/input");
	By locate_submit = By.xpath("//*[@id=\"root\"]/div/div/button");
	
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
}


public void enter_email(String text) {
	driver.findElement(locate_email).sendKeys(text);
		
}

public void enter_password(String text1) {
	driver.findElement(locate_password).sendKeys(text1);
		
}

public void click_login() {
	driver.findElement(locate_submit).click();
		
}
}
