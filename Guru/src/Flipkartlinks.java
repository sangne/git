import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Flipkartlinks {


public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		WebDriver driver=new ChromeDriver(option);
		driver.get("https://www.flipkart.com");
		List<WebElement> elements=driver.findElements(By.tagName("a"));
		System.out.println(elements.size());
		for(int i= 0;i<elements.size();i++)
		{
			System.out.println(elements.get(i).getText());
		}
		
		WebElement e=driver.findElement(By.className("LM6RPg"));
		e.sendKeys("apple watches");
		driver.findElement(By.className("_1QZ6fC _3Lgyp8")).click();
		driver.findElement(By.cssSelector("button[type='submit']")).click();
				
	}

}
