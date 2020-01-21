package bankingproject;
import java.io.File;
import org.apache.commons.io.FileUtils;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Skyscanner {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver",
				"C://Users//praga//Downloads//selenium-java-3.13.0//chromedriver_win32//geckodriver-v0.24.0-win64//geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.skyscanner.com.au");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='fsc-trip-type-selector-one-way']")).click();
		driver.findElement(By.id("fsc-origin-search")).sendKeys("syd");
		driver.findElement(By.id("react-autowhatever-fsc-origin-search--item-1")).click();
		WebElement destination = driver.findElement(By.id("fsc-destination-search"));
		destination.sendKeys("che");
		WebDriverWait expWait = new WebDriverWait(driver, 20);
		WebElement destinationLink = expWait.until(
				ExpectedConditions.elementToBeClickable(By.id("react-autowhatever-fsc-destination-search--item-0")));
		destinationLink.click();
		driver.findElement(By.id("depart-fsc-datepicker-button")).click();
		Select s = new Select(driver.findElement(By.id("depart-calendar__bpk_calendar_nav_select")));
		s.selectByValue("2019-12");
		driver.findElement(By.xpath("//button[@aria-label='Thursday, 26 December 2019']")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//Thread.sleep(20000);
		//driver.findElement(By.xpath("//input[@aria-label='2+ stops']")).click();
		File src= ((TakesScreenshot)driver). getScreenshotAs(OutputType. FILE);
		try {
			 // now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("C:/selenium/error.png"));
			}
			 
			catch (IOException e)
			 {
			  System.out.println(e.getMessage());
			 
	}

}
}
