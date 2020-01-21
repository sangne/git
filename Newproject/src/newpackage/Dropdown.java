package newpackage;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Dropdown {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		    
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			WebDriver driver=new ChromeDriver(option);
		    driver.get("https://www.cleartrip.com/");
		    driver.findElement(By.id("DepartDate")).click();
		    driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight.ui-state-active ")).click();
		    driver.findElement(By.xpath("//option[@value='2']")).click();
		    driver.findElement(By.id("MoreOptionsLink")).click();
		    driver.findElement(By.id("AirlineAutocomplete")).sendKeys("quantas");
		    driver.findElement(By.id("SearchBtn")).click();
		    System.out.println(driver.findElement(By.id("homeErrorMessage")).getText());
		
	}

}
