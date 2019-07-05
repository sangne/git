package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestivedropdown {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub

	    System.setProperty("webdriver.chrome.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://ksrtc.in/oprs-web/");
	    driver.findElement(By.id("fromPlaceName")).sendKeys("ben");
	    driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ARROW_DOWN);
	    driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ARROW_DOWN);driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ARROW_DOWN);
	    driver.findElement(By.id("fromPlaceName")).sendKeys(Keys.ENTER);
	}

}
