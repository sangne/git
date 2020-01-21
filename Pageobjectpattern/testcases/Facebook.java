package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import objectrepository.loginepage;

public class Facebook {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.setProperty("webdriver.chrome.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
	    
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(option);
		driver.get("http://www.facebook.com");
		loginepage fs= new loginepage(driver);
		fs.forgottenaccount().click();
		fs.mailid().sendKeys("nsangeethaselvi@yahoo.com");;
		fs.search().click();
		
	}

}
