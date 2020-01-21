package newpackage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Autoit1 {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(option);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://testpoint.com.au/contact-us/careers/");
		driver.findElement(By.id("hs-eu-confirmation-button")).click();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		driver.findElement(By.xpath("//span[@class='wpcf7-form-control-wrap file-800']")).click();
		Thread.sleep(3000);
	    Runtime.getRuntime().exec("C:\\selenium\\fileupload.exe");
	}

}
