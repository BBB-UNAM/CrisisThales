package map;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BasicUserSteps.EsentialUserSteps;
import PageObjects.LoginPageObjects;
import PageObjects.MapObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class geographyLayerDisplayedInMap {
	
	WebDriver driver;
	WebElement mapLoaded;
	WebElement infoversion;
	String version;
	EsentialUserSteps basicSteps;
	MapObjects elements;
	
	@Given("The user go to open chrome we explorer")
	public void givenStep () throws IOException {
		this.basicSteps = new EsentialUserSteps(); // crate object named "basic Steps"
		
		this.driver = this.basicSteps.chromeDriverConfig(this.driver); //initialize basic explorer config [this returns "new ChromeDriver"]
		this.basicSteps.initWaitConfig(50, 10, this.driver);//method to initialize wait config (time to load page, time to wait a general webelement, Webdriver)
		
		LoginPageObjects access = new LoginPageObjects(this.driver); //object to set a credentials webelemnts and actions 
		access.setUser();
		access.setPass();
		access.clickOnLoginButton();
		
		
	}
	@When("The crisis map is visible to the user")
	public void whenStep () throws IOException {
		this.basicSteps.waitTimeoutMapAndVersion(this.driver, this.mapLoaded, this.infoversion, 20); // timeout to define the time to wait to version webelement and map flag
		this.version = this.basicSteps.getInfoVersion(this.driver); // with this method we can get the current Crisis version
		
		this.elements = new MapObjects();
		this.elements.clickOnMapButtons(this.driver, 1);// click on layers buttons (option 1)
	}
	
	@And("Each geography layer is enabled")
	public void andStep () throws IOException, InterruptedException {
		

		List<WebElement> buttons = this.elements.geografiaButtonsList(driver);
		
		for(int i = 0; i < 3; i++) {
			this.elements.clickOnGeografiaButtons(driver, buttons, i);
			Thread.sleep(1000);
		}
		
		
	}
	
	@And("Each geography layer is disabled")
	public void andAndStep () throws IOException, InterruptedException {
		
		List<WebElement> buttons = this.elements.geografiaButtonsList(driver);
		
		for(int i = 0; i < 3; i++) {
			this.elements.clickOnGeografiaButtons(driver, buttons, i);
			Thread.sleep(1000);
		}
	}
	
	@Then("The chrome web browser is closed")
	public void thenStep () {
		this.basicSteps.finalTestActions(this.driver); //stoeps to finish the case
		System.out.print("This test case is OK in Crisis system "+ this.version + " .");	
	}

}
