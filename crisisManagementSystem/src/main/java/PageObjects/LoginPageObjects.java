package PageObjects;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.How;
//import org.openqa.selenium.support.PageFactory;
import utils.getFileProperties;

public class LoginPageObjects {
	
	WebDriver driver;

	//@FindBy(how = How.ID, using="username") //set field element to insert the user
	public WebElement webElementUser;
	
	//@FindBy(how = How.ID, using="password") //set field element to insert the pass
	public WebElement webElementPass;
	
	//@FindBy(how = How.ID, using="kc-login")
	public WebElement loginButton;
	
	//The contructor of this class initialize webElementUser and webElementPass
	public LoginPageObjects(WebDriver driver) throws IOException {
		//PageFactory.initElements(driver, this); 
		this.webElementUser = driver.findElement(By.id(getFileProperties.getByElementsProperties("IDloginELEMENT")));
		
		//@FindBy(how = How.ID, using="password") //set field element to insert the pass
		this.webElementPass = driver.findElement(By.id(getFileProperties.getByElementsProperties("IDpassELEMENT")));
		
		//@FindBy(how = How.ID, using="kc-login")
		this.loginButton = driver.findElement(By.id(getFileProperties.getByElementsProperties("IDloginBUTTON")));
	}
	
	//Public method to click on logn button
	public void clickOnLoginButton() {
		loginButton.click(); //click on logn button to login in crisis portal
	}
	
	//Public method to set a user
	public void setUser() throws IOException {
		this.webElementUser.sendKeys(getFileProperties.getTestProperties("USER02"));
	}
	
	//Public method to set password
	public void setPass() throws IOException {
		this.webElementPass.sendKeys(getFileProperties.getTestProperties("PASSU02"));
	}
}
