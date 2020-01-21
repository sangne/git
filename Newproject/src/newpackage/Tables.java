package newpackage;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Tables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		    
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			WebDriver driver=new ChromeDriver(option);
			driver.get("http://qaclickacademy.com/practice.php");
			WebElement table=driver.findElement(By.id("product"));



			System.out.println(table.findElements(By.tagName("tr")).size());



			System.out.println(table.findElements(By.tagName("tr")).get(0).findElements(By.tagName("th")).size());



			List<WebElement> secondrow=table.findElements(By.tagName("tr")).get(2).findElements(By.tagName("td"));



			System.out.println(secondrow.get(0).getText());



			System.out.println(secondrow.get(1).getText());



			System.out.println(secondrow.get(2).getText());

			}
	}


