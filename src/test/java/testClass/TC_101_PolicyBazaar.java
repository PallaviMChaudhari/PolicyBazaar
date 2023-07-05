package testClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.TestNgBaseClass;
import pom.PolicyBazaarLogin;
import pom.PolicyBazaarUserAcc;
import utility.Utility;
public class TC_101_PolicyBazaar extends TestNgBaseClass{
  PolicyBazaarLogin login;
  PolicyBazaarUserAcc myAccount;
  @BeforeClass
  public void lanuchPolicyBazaar() throws IOException {
	 
	  launchBrowserProp();
	  Utility.implicitWait(driver, 3000);
	  login=new PolicyBazaarLogin(driver);
	  
	  myAccount=new PolicyBazaarUserAcc(driver);
	    
  }
  @BeforeMethod
  public void loginProcess() throws EncryptedDocumentException, IOException {
	  Utility.implicitWait(driver, 3000);
	  login.clickOnSignInButtonOnHomePage();
	  Utility.implicitWait(driver, 3000);
	  login.enterInMobileNumFeild(Utility.readDataPropertyFile("MoNum"));
	  Utility.implicitWait(driver, 3000);
	  login.clickOnLoginWithPasswordField();
	  Utility.implicitWait(driver, 3000);
	  login.enterPasswordIntoPassField(Utility.readDataPropertyFile("PWD"));
	  Utility.implicitWait(driver, 3000);
	  login.clickOnSignInButton();
	  Utility.implicitWait(driver, 3000);
	  login.clickOnMyAccountButton();
	  Utility.implicitWait(driver, 3000);
	  login.clickOnMyProfileButton();
	  Utility.implicitWait(driver, 3000);
	  
	  Set<String> allId = driver.getWindowHandles();
	  ArrayList<String> al=new ArrayList<>(allId);
	  driver.switchTo().window(al.get(1));
	  Reporter.log("Focus change to child window", true);
	  Utility.implicitWait(driver, 3000);
	  
  } 
	
  @Test
  public void verifyUN() throws EncryptedDocumentException, IOException {
	  String actText = myAccount.getProfiletext();
	  Utility.implicitWait(driver, 3000);
	  String expText = Utility.readDataPropertyFile("UN");
	  Assert.assertEquals(actText, expText,"TC Fail String not match");
	  Utility.screenshotCapture(driver, actText);
	  
  }
  @AfterMethod
  public void logoutApp() {
	  myAccount.clickOnLogout();
  }
  @AfterClass
  public void CloseBrow() {
	  closeBrowser();
  }
}
