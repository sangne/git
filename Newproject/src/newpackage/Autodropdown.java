package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Autodropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		    
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			WebDriver driver=new ChromeDriver(option);
			driver.get("http://qaclickacademy.com/practice.php");
			driver.findElement(By.id("autocomplete")).sendKeys("ind");
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);
			driver.findElement(By.id("autocomplete")).sendKeys(Keys.ARROW_DOWN);
			System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));
	}

}
