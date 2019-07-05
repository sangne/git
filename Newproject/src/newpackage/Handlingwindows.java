package newpackage;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlingwindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	    System.setProperty("webdriver.chrome.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
	    WebDriver driver = new ChromeDriver();
	    driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.linkText("Multiple Windows")).click();
        driver.findElement(By.linkText("Click Here")).click();
        Set<String> Set= driver.getWindowHandles();
        Iterator<String> id=Set.iterator();
        String Parentwindow=id.next();
        String Childwindow=id.next();
        driver.switchTo().window(Childwindow);
        String Windowname=driver.getTitle();
        System.out.println(Windowname);
        driver.switchTo().window(Parentwindow);
       System.out.println(driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText());
        
        
        
	}

}
