package map;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BasicUserSteps.EsentialUserSteps;
import PageObjects.LoginPageObjects;
import PageObjects.MapObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchWithQuotationMarks {
	
	WebDriver driver;
	WebElement mapLoaded;
	WebElement infoversion;
	String version;
	EsentialUserSteps basicSteps;
	MapObjects elements;
	
	@Given("The user opens a web browser")
	public void givenStep () throws IOException {
		this.basicSteps = new EsentialUserSteps(); // crate object named "basic Steps"
		
		this.driver = this.basicSteps.chromeDriverConfig(this.driver); //initialize basic explorer config [this returns "new ChromeDriver"]
		this.basicSteps.initWaitConfig(50, 10, this.driver);//method to initialize wait config (time to load page, time to wait a general webelement, Webdriver)
		
		LoginPageObjects access = new LoginPageObjects(this.driver); //object to set a credentials webelemnts and actions 
		access.setUser();
		access.setPass();
		access.clickOnLoginButton();
		
		
	}
	
	@When("The user wait to crisis map is loaded")
	public void whenStep () throws IOException {
		this.basicSteps.waitTimeoutMapAndVersion(this.driver, this.mapLoaded, this.infoversion, 20); // timeout to define the time to wait to version webelement and map flag
		this.version = this.basicSteps.getInfoVersion(this.driver); // with this method we can get the current Crisis version
	}
	@And("The user searches a hospital in search bar")
	public void andStep () throws IOException, InterruptedException {
		this.elements = new MapObjects();
		
		this.elements.searchAHospital(this.driver, "\"belisario\"");
		
		this.elements.clickOnSearchResult(driver);
		
		this.elements.focusedOnMapCenter(driver, 0);
		
		this.elements.waitToolTip(driver);
		
		Thread.sleep(1000);	
	}
	
	@Then("The results are displayed")
	public void thenStep () {
		
		this.basicSteps.finalTestActions(this.driver);// actions to close the map and java Thread
		System.out.print("This test case is OK in Crisis system "+ this.version + " .");
		
	}

}
