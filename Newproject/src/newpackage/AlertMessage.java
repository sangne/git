package newpackage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
public class AlertMessage {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("http://demo.guru99.com/test/delete_customer.php");
	    WebElement element =driver.findElement(By.name("cusid"));
	    element.sendKeys("1234");
	    WebElement submit=driver.findElement(By.name("submit"));
	    submit.click();
	    
	    //switch to alert
	    Alert alert=driver.switchTo().alert();
	    //capturing alert message
	    String alertmessage=driver.switchTo().alert().getText();
	    //displaying alert message
	    System.out.println(alertmessage);
	    alert.accept();
	    Alert alert1=driver.switchTo().alert();
	    alert1.accept();
	    
	    
	    
	}

}
