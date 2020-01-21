import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class draganddrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
	WebDriver driver=new ChromeDriver(option);
		driver.get(" http://jqueryui.com/droppable");
		WebElement e=driver.findElement(By.cssSelector("iframe[src='/resources/demos/droppable/default.html']"));
		driver.switchTo().frame(e);
		WebElement drag= driver.findElement(By.id("draggable"));
		WebElement drop=driver.findElement(By.id("droppable"));
		Actions a =new Actions(driver);
		a.dragAndDrop(drag, drop).build().perform();
		
		if(driver.findElement(By.linkText("Dropped!")).isDisplayed())
		{
			System.out.println("success");
		}
		else
		{
			System.out.println("fail");
		}
	}


	}


