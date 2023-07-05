package base;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

import utility.Utility;

public class TestNgBaseClass {
	static protected WebDriver driver;
	
	public void launchBrowser() {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.policybazaar.com/");
		Reporter.log("Browser Launch successfully.. ", true);
	}
	
	public void launchBrowserProp() throws IOException {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Utility.readDataPropertyFile("Url"));
		Reporter.log("Browser Launch successfully.. ", true);
	}
	
	public void closeBrowser() {
		Reporter.log("Close browser window....",true);
		driver.quit();
	}
	

}
