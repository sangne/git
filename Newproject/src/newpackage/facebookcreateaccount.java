package newpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class facebookcreateaccount {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		String baseurl="https://www.facebook.com/";
		
		driver.get(baseurl);
		
		WebElement  F_Name= driver.findElement(By.id("u_0_j"));
		F_Name.sendKeys("prama");
		WebElement  S_Name= driver.findElement(By.name("lastname"));
		S_Name.sendKeys("prama");
		// TODO Auto-generated method stub
		WebElement  email= driver.findElement(By.id("u_0_o"));
		email.sendKeys("abc123@gmail.com");
		WebElement  email1 = driver.findElement(By.id("u_0_r"));
		email1.sendKeys("abc123@gmail.com");
		WebElement  password= driver.findElement(By.id("u_0_v"));
		password.sendKeys("12345qwer");
		Select  day=  new Select(driver.findElement(By.id("day")));	
		day.selectByValue("1");
		Select  month= new Select(driver.findElement(By.id("month")));
		month.selectByValue("6");
		Select year= new Select(driver.findElement(By.id("year")));
		year.selectByValue("1994");
		WebElement female= driver.findElement(By.id("u_0_a"));
		female.click();
		WebElement submit= driver.findElement(By.id("u_0_11"));
		submit.click();
		
		
		
		
	}

}
