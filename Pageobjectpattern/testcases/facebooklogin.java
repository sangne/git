package testcases;

import objectrepository.loginepage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class facebooklogin {

	public facebooklogin(WebDriver driver) {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
	    
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.get("http://www.facebook.com");
		loginepage fb= new loginepage(driver);
		fb.emailid().sendKeys("nsangeethaselvi@yahoo.com");
		fb.password().sendKeys("myman#123");
		fb.login().click();
	}

}
