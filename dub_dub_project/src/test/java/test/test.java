package test;

import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPage;

public class test {
	
	WebDriver driver = null;

	
// Email = x. 

	static String x= "xyz@gmail.com";
	
//Password =y	
// Valid Password should contain:
//	1. at least 8 characters and at most 20 characters.
//	2. at least one digit.
//	3. at least one upper case alphabet.
//	4. at least one lower case alphabet.
//	5. at least one special character which includes !@#$%&*()-+=^.
//	6. doesn’t contain any white space.
	
	static String y= "Qwerty@312";

		@BeforeTest
		public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		
		
		
		@Test
		public void testa() {
		LoginPage obj= new LoginPage(driver);
		//enter Url
		driver.get("https://z3t0c9.csb.app/");
		//adding wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//enter email
		obj.enter_email(x);
	    
		
		//validating email type
	    Pattern p = Pattern.compile("\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b");
		Matcher m = p.matcher(x);
		if (m.find()) {
		    System.out.println("Correct Email!");
		}
		else {
		    System.out.println("Incorrect Email!");
		}
		}
		
		
		@Test
		public void testb() {
		LoginPage obj= new LoginPage(driver);

	    //enter password
		obj.enter_password(y);
	    
	    //validate password type
	    Pattern k = Pattern.compile("^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$%^&+=])"  + "(?=\\S+$).{8,20}$");
        Matcher s = k.matcher(y);
		if (s.find()) {
			    System.out.println("Correct Password!");
			}
		else {
			    System.out.println("Incorrect Password!");

			}
		
		//adding wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		}
		
		
		
		@Test
		public void testc() {
		LoginPage obj= new LoginPage(driver);

       //click submit button only if correct type of email and email is entered.

		WebElement Wb= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[1]/input"));
        String CLbox =Wb.getAttribute("value");
        if(CLbox.isEmpty())
        {
               System.out.println("Email field is empty");
        }
        else
        {
        	WebElement Wbb= driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/input"));
            
            String CLbbox =Wbb.getAttribute("value");
            if(CLbbox.isEmpty())
            {
                   System.out.println("Password field is empty");
            }
            
            else
            {
            	obj.click_login();
            }
        }
		
}
}
