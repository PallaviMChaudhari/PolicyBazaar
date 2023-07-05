package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PolicyBazaarLogin {
	
	//variable 
	@FindBy(xpath = "//a[text()='Sign in']") private WebElement signInButtonOnHomePage;
	
	@FindBy(xpath = "(//input[@type='number'])[2]") private WebElement mobileNumField;
	
	@FindBy(xpath ="(//span[text()='Sign in with Password'])[2]") private WebElement loginWithPasswordButton;
	
	@FindBy(name = "password") private WebElement passwordField;
	
	@FindBy(xpath ="//span[text()='Sign in']") private WebElement signInButton; 
	
	@FindBy(xpath ="//div[text()='My Account']")private WebElement myAccountButton;
	
	@FindBy(xpath ="//span[text()= ' My profile ']") private WebElement myProfileButton;
	
	
	
	public PolicyBazaarLogin(WebDriver driver){
		PageFactory.initElements(driver,this);
		
		
			
	}
	
	//method
	
	public void clickOnSignInButtonOnHomePage() {
		signInButtonOnHomePage.click();
		Reporter.log("click on Signin..", true);
	}
	
	public void enterInMobileNumFeild(String UserId) {
		mobileNumField.sendKeys(UserId);
		Reporter.log("enter mobile number...", true);
		
	}
	
	public void clickOnLoginWithPasswordField() {
		loginWithPasswordButton.click();
		
	}
	
	public void enterPasswordIntoPassField(String pass) {
		passwordField.sendKeys(pass);
		Reporter.log("enter password..", true);
	}
	
	public void clickOnSignInButton() {
		signInButton.click();
		Reporter.log("click on sign button..", true);
	}
	
	public void clickOnMyAccountButton() {
		myAccountButton.click();
		Reporter.log("click on MyAccount", true);
	}
	
	public void clickOnMyProfileButton() {
		myProfileButton.click();
		Reporter.log("Click on my Profile", true);
	}
	
	

}
