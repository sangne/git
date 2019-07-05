package newpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class NewTest {
	WebDriver driver;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;
    
	 
    @BeforeTest
	public void TestSetup(){
	    // To set the path of the Chrome driver.
    	System.setProperty("webdriver.chrome.driver","C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver_win32\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();
	     
	    // To launch facebook
	    driver.get("http://www.facebook.com/");
	    // To maximize the browser
	    driver.manage().window().maximize();
	    // implicit wait
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
		  
	@Test
	public void ReadData() throws IOException{		
		
		// Import excel sheet.
		File src=new File("D:\\Test.xlsx");		  
		// Load the file.
		FileInputStream fis = new FileInputStream(src);
		// Load he workbook.
		workbook = new XSSFWorkbook(fis);
		// Load the sheet in which data is stored.
		sheet= workbook.getSheet("Sheet1");
		
		for(int i=1; i<=sheet.getLastRowNum(); i++){
			/*I have added test data in the cell A2 as "testemailone@test.com" and B2 as "password"
			Cell A2 = row 1 and column 0. It reads first row as 0, second row as 1 and so on 
			and first column (A) as 0 and second column (B) as 1 and so on*/ 
		
			// Import data for Email.
			cell = sheet.getRow(i).getCell(0);
			
			driver.findElement(By.xpath("//input[@type='email'][@name='email']")).clear();
			driver.findElement(By.xpath("//input[@type='email'][@name='email']")).sendKeys(cell.getStringCellValue());
			 
			// Import data for password.
			cell = sheet.getRow(i).getCell(1);
		
			driver.findElement(By.xpath("//input[@type='password'][@name='pass']")).clear();	         
			driver.findElement(By.xpath("//input[@type='password'][@name='pass']")).sendKeys(cell.getStringCellValue());
			// To click on Login button
			driver.findElement(By.xpath("//input[@type='submit'and @value='Log In']")).click();
			//To write data in the excel
			
			  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			  
			FileOutputStream fos=new FileOutputStream(src);
			// Message to be written in the excel sheet
		    String message = "Pass";
		    // Create cell where data needs to be written.
		    sheet.getRow(i).createCell(2).setCellValue(message);
		        
		    // finally write content
		    workbook.write(fos);
		    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					
			// close the file
			fos.close();
			
			 driver.findElement(By.id("userNavigationLabel")).click();
			 driver.findElement(By.className("_54ni navSubmenu _6398 _64kz __MenuItem")).click();
			 
		        
			}
	}
}