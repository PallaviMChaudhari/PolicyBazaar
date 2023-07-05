package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility {
	public static void implicitWait(WebDriver driver,long time) {
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(time));
		Reporter.log("Wait for sometimes...",true);
		
	}
	
	public static void screenshotCapture(WebDriver driver,String myFile) throws IOException {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("D:\\Selenium\\Screenshot\\"+myFile+".png");
		FileHandler.copy(src, dest);
		
		Reporter.log("Screenshot is capture...",true);
		
	}
	public static void methodForSscroll(WebDriver driver, WebElement element) {
	JavascriptExecutor js = ((JavascriptExecutor)driver);
	js.executeScript("arguments[0].scrollIntoView(true)", element);
	Reporter.log("Scrolling...",true);
	}
	
	public static String excelRead(int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream myFile=new FileInputStream("D:\\Selenium\\ExcelSheetReading\\testing.xlsx");
		String value = WorkbookFactory.create(myFile).getSheet("sheet1").getRow(rowNum).getCell(cellNum).getStringCellValue();
		Reporter.log("take input from excel...",true);
		return value;
		
	}
	public static String readDataPropertyFile(String key) throws IOException {
		Properties obj=new Properties();
		FileInputStream myFile=new FileInputStream("C:\\Users\\Palya\\eclipse-workspace\\PolicyBazaar\\test-output\\Abc.properties");
		obj.load(myFile);
		String value = obj.getProperty(key);
		Reporter.log("reading "+key+"from propertyFile", true);
		return value;
		
		
	}

}