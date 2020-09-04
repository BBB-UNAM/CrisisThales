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

public class TrasladosPorAlcaldiaViewLayer {
	
	WebDriver driver;
	WebElement mapLoaded;
	WebElement infoversion;
	String version;
	EsentialUserSteps basicSteps;
	MapObjects elements;
	
	@Given("the user opens a chrome browser and login with valid credentials")
	public void givenStep() throws IOException {
		
		this.basicSteps = new EsentialUserSteps(); // crate object named "basic Steps"
		
		this.driver = this.basicSteps.chromeDriverConfig(this.driver); //initialize basic explorer config [this returns "new ChromeDriver"]
		this.basicSteps.initWaitConfig(50, 10, this.driver);//method to initialize wait config (time to load page, time to wait a general webelement, Webdriver)
		
		LoginPageObjects access = new LoginPageObjects(this.driver); //object to set a credentials webelemnts and actions 
		access.setUser();
		access.setPass();
		access.clickOnLoginButton();
		
		this.basicSteps.waitTimeoutMapAndVersion(this.driver, this.mapLoaded, this.infoversion, 20); // timeout to define the time to wait to version webelement and map flag
		this.version = this.basicSteps.getInfoVersion(this.driver); // with this method we can get the current Crisis version
		
	}
	
	@When("the crisis map is displayed in the web browser")
	public void whenStep() throws IOException {
		this.basicSteps.waitTimeoutMapAndVersion(this.driver, this.mapLoaded, this.infoversion, 20); // timeout to define the time to wait to version webelement and map flag
		this.version = this.basicSteps.getInfoVersion(this.driver); // with this method we can get the current Crisis version
	}
	
	@And("the user opens layer menu and clicks in TRASLADOS POR ALCALDIA layer")
	public void andStep() throws IOException, InterruptedException {
		
		this.elements = new MapObjects();// start the instance of elements object
		this.elements.clickOnMapButtons(this.driver, 1);// click on layers buttons (option 1)
		
		this.elements.clickOnTrasladosPorAlcalidaLayer(driver);
		Thread.sleep(4000);
	}
	
	@Then("the user close crisis map")
	public void thenStep() {
		
		this.basicSteps.finalTestActions(this.driver); //stoeps to finish the case
		System.out.print("This test case is OK in Crisis system "+ this.version + " .");
		
	}

}
