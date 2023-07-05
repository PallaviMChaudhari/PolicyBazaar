package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class PolicyBazaarUserAcc {
	@FindBy(xpath="//div[@class='textCapitalize sc-ckVGcZ kWpXlQ']")private WebElement profileName;
	@FindBy(className = "h_l")private WebElement logout;
	
	public PolicyBazaarUserAcc(WebDriver driver){
		PageFactory.initElements(driver,this);
	}
	public String getProfiletext() {
		Reporter.log("get User Name...", true);
		String actualText = profileName.getText();
		return actualText;
	}
	
	public void clickOnLogout() {
		Reporter.log("Logout Applications..", true);
		logout.click();
	}

}
