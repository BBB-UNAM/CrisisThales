package PageObjects;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utils.getFileProperties;

public class LoginPageObjects {
	
	WebDriver driver;

	@FindBy(how = How.ID, using="username") //set field element to insert the user
	public WebElement webElementUser;
	
	@FindBy(how = How.ID, using="password") //set field element to insert the pass
	public WebElement webElementPass;
	
	@FindBy(how = How.ID, using="kc-login")
	public WebElement loginButton;
	
	//The contructor of this class initialize webElementUser and webElementPass
	public LoginPageObjects(WebDriver driver) {
		PageFactory.initElements(driver, this); 
	}
	
	//Public method to click on logn button
	public void clickOnLoginButton() {
		loginButton.click(); //click on logn button to login in crisis portal
	}
	
	//Public method to set a user
	public void setUser() throws IOException {
		this.webElementUser.sendKeys(getFileProperties.getProperties("USER02"));
	}
	
	//Public method to set password
	public void setPass() throws IOException {
		this.webElementPass.sendKeys(getFileProperties.getProperties("PASSU02"));
	}
}
