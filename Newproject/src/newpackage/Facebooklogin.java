package newpackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import multiScreenShot.MultiScreenShot;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Facebooklogin {

	@Test
	@SuppressWarnings("resource")
	public void mainmethod() throws IOException, InterruptedException, TimeoutException, NoAlertPresentException,
			ClassNotFoundException {
		MultiScreenShot multiscreens = new MultiScreenShot("C:\\selenium\\", "isAlertPresent");

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\praga\\Downloads\\selenium-java-3.13.0\\chromedriver.exe ");

		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		// TODO Auto-generated method stub

		// Open MyDataSheet.xls file from given location.
		FileInputStream fileinput = new FileInputStream("D:\\Test.xlsx");
		// Access first data sheet. getSheet(0) describes first sheet.
		Workbook BOOK = new XSSFWorkbook(fileinput);
		Sheet sheet = BOOK.getSheetAt(0);
		int totalRows = sheet.getPhysicalNumberOfRows();
		int noOfColumns = sheet.getRow(0).getLastCellNum();
		System.out.println(totalRows);
		System.out.println(noOfColumns);
// Type data in first name and last name text box from array.
		for (int i = 1; i <= totalRows; i++) {
			Cell cell = sheet.getRow(i).getCell(0);
			driver.findElement(By.name("email")).clear();
			driver.findElement(By.name("email")).sendKeys(cell.getStringCellValue());
			cell = sheet.getRow(i).getCell(1);
			driver.findElement(By.name("pass")).sendKeys(cell.getStringCellValue());
			driver.findElement(By.xpath("//input[@value='Log In']")).click();

			if (isAlertPresent(driver, multiscreens)) {
				driver.get("https://www.facebook.com/");
				String message = "pass";
				sheet.getRow(i).createCell(2).setCellValue(message);
				FileOutputStream fileOutput = new FileOutputStream("D:\\Test.xlsx");
				BOOK.write(fileOutput);
				fileOutput.close();
				continue;
			}
			driver.findElement(By.id("userNavigationLabel")).click();

			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log Out"))).click();
			String message = "pass";
			sheet.getRow(i).createCell(2).setCellValue(message);
			FileOutputStream fileOutput = new FileOutputStream("D:\\Test.xlsx");
			BOOK.write(fileOutput);
			fileOutput.close();
		}
	}

	@Test
	private static boolean isAlertPresent(WebDriver driver, MultiScreenShot multiscreens) {

		// TODO Auto-generated method stub
		try {
			if ((driver.findElement(By.xpath("//div[@role='alert']")).isDisplayed())) {
				System.out.println("Alert is Displayed");

				try {

					multiscreens.multiScreenShot(driver);

				}

				catch (IOException e) {
					System.out.println(e.getMessage());

				}
				return true;

			}
		} catch (NoSuchElementException n) {
			System.out.println("Alert is NOT Displayed");
		} finally {
		}
		return false;
	}
}
