
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class AutoIt {
	public void main() throws IOException {
		
	ChromeOptions option = new ChromeOptions();
	option.addArguments("--disable-notifications");
	System.setProperty("webdriver.chrome.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver.exe");

	WebDriver driver = new ChromeDriver(option);
	driver.get("https://testpoint.com.au/contact-us/careers/");
	driver.findElement(By.xpath("//input[@type=file]")).click();
	Runtime.getRuntime().exec("C:\\selenium\\fileupload.exe");
	
}
}
