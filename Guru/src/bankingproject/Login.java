package bankingproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {

	public static  void main(String[] args) {
		System.setProperty("webdriver.gecko.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver_win32\\geckodriver-v0.24.0-win64\\geckodriver.exe ");
		WebDriver driver=new FirefoxDriver();
		// TODO Auto-generated method stub
		driver.get("http://www.demo.guru99.com/V4");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("uid")).sendKeys("mngr206811");
		driver.findElement(By.name("password")).sendKeys("sYjEdam");
		driver.findElement(By.cssSelector("input[value='LOGIN']")).click();
		System.out.println("Login successful");
		
		}

}
