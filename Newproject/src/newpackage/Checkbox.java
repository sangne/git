package newpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Checkbox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  System.setProperty("webdriver.chrome.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		    WebDriver driver = new ChromeDriver();
		    driver.get("https://rahulshettyacademy.com/AutomationPractice");
		    driver.findElement(By.id("checkBoxOption1")).click();
		    driver.findElement(By.id("checkBoxOption1")).click();
		    driver.findElement(By.id("checkBoxOption1")).isSelected();
		  int e= driver.findElements(By.xpath("//input[@type='checkbox']")).size();
		   System.out.println(e);
	}

}
