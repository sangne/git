package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebookvalidlogin {

//private static final String actualTitle = null;

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String baseurl="https://www.facebook.com/";
		
		driver.get(baseurl);
		
		// WebElement actualTitle =driver.findElement(By.name("create your account"));
		if ( driver.findElement(By.id("registration_container")) != null){
	            System.out.println("Test Passed!");
	        } else {
	            System.out.println("Test Failed");
	            System.exit(0);
	        }
	    
		WebElement Email= driver.findElement(By.id("email"));
		
		Email.sendKeys("nsangeethaselvi@yahoo.com");
		
		WebElement password= driver.findElement(By.id("pass"));
		
		password.sendKeys("myman#123");
		WebElement Login= driver.findElement(By.id("u_0_2"));
		
		Login.click();
		WebElement search= driver.findElement(By.name("q"));
		
		if(search.isDisplayed())
		{
		
		System.out.println("test case is passed");
		}		
		else 
		{
		
			System.out.println("test case is failed");
		
		}
		
		
		
		

	}

	}
