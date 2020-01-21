package newpackage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 System.setProperty("webdriver.chrome.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		    
			ChromeOptions option = new ChromeOptions();
			option.addArguments("--disable-notifications");
			WebDriver driver=new ChromeDriver(option);
			driver.get("http://qaclickacademy.com/practice.php");
			WebElement b=driver.findElement(By.id("checkBoxOption1"));
			b.click();
			WebElement z=driver.findElement(By.xpath("//input[@value='option1']//parent::label"));
			String a = z.getText();
			System.out.println(a);
			WebElement q=driver.findElement(By.id("dropdown-class-example"));
			q.click();
			Select s= new Select(q);
			s.selectByVisibleText(a);
			WebElement c =driver.findElement(By.id("name"));
			c.sendKeys(a);
			driver.findElement(By.id("alertbtn")).click();
			System.out.println(driver.switchTo().alert().getText());
			
		
			
			
	}

}
