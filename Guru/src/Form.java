import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Form {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
		driver.findElement(By.name("firstname")).sendKeys("san");
		driver.findElement(By.name("lastname")).sendKeys("geetha");
		driver.findElement(By.id("sex-1")).click();
		driver.findElement(By.id("exp-2")).click();
		driver.findElement(By.id("photo")).click();
		WebElement c=driver.findElement(By.id("continents"));
		Select s= new Select(c);
		s.selectByValue("Asia");
		Runtime.getRuntime().exec("C:\\selenium\\fileupload.exe");
		driver.findElement(By.partialLinkText("Click here to Download File")).click();
	}

}
