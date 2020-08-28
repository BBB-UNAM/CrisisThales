package map;

import java.io.IOException;
import java.util.List;

import java.util.concurrent.TimeUnit;

import javax.crypto.KeyAgreementSpi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import BasicUserSteps.EsentialUserSteps;
import PageObjects.*;

public class ElementsWithoutData {
	
	WebDriver driver;
	WebElement mapLoaded;
	WebElement infoversion;
	String version;
	EsentialUserSteps basicSteps;
	
	@Given("The user opens Crisis Map portal and login in")
	public void givenStep() throws IOException {
		
		basicSteps = new EsentialUserSteps(); // crate object named "basic Steps"
		
		this.driver = basicSteps.chromeDriverConfig(this.driver); //initialize basic explorer config [this returns "new ChromeDriver"]
		basicSteps.initWaitConfig(50, 10, this.driver);//method to initialize wait config (time to load page, time to wait a general webelement, Webdriver)
		
		LoginPageObjects access = new LoginPageObjects(this.driver); //object to set a credentials webelemnts and actions 
		access.setUser();
		access.setPass();
		access.clickOnLoginButton();
		
		basicSteps.waitTimeoutMapAndVersion(this.driver, this.mapLoaded, this.infoversion, 20); // timeout to define the time to wait to version webelement and map flag
		this.version = basicSteps.getInfoVersion(driver); // with this method we can get the current Crisis version
	}
	
	@When("The user test that CAMAS GENERALES hospitals with any data is not vissible")
	public void whenStep() throws InterruptedException {
		driver.findElement(By //click on map layes button
				.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div/sdp-map-tools/div/div[2]/mat-icon[@title='Capas del mapa']"))
		.click();
		
		List<WebElement> switchesOn = driver.findElements(By.xpath("//*[contains(@id,'mat-slide-toggle-') and @class='mat-slide-toggle mat-accent mat-checked']"));//click on switch to disable hospitals without data
		switchesOn.get(0).click();
		
		Thread.sleep(2000);
		
		//driver.findElement(By.xpath("//*[contains(@id,'mat-input-')]")).sendKeys("imss" + Keys.ENTER);
		
		//driver.findElement(By.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav/div/sdp-crisis-details-ui/mat-sidenav-content/sdp-crisis-search-results/sdp-caption-panel/div/div[2]/div/sdp-scrollable/div/ng-scrollbar/div/div/div/div/div/div[1]/div[2]/div[1]/div/sdp-poi-result-item/div/div[1]/img")).click();
		
		//List<WebElement> switchesOff = driver.findElements(By.xpath("//*[contains(@id,'mat-slide-toggle-') and @class='mat-slide-toggle mat-accent']"));//click on switch to enable hospitals without data
		//switchesOff.get(0).click();
	}
	
	@And("The user test that CAMAS UCI hospitals with any data is not vissible")
	public void andStep() throws InterruptedException {
		Thread.sleep(2000);
		driver.findElement(By.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div/sdp-switch-data-type/div/label")).click();
		Thread.sleep(2000);
		//switchOn camas UCI
		//List<WebElement> switchesOn = driver.findElements(By.xpath("//*[contains(@id,'mat-slide-toggle-') and @class='mat-slide-toggle mat-accent mat-checked']"));//click on switch to disable hospitals without data
		//switchesOn.get(0).click();
		//Thread.sleep(2000);
		//List<WebElement> switchesOff = driver.findElements(By.xpath("//*[contains(@id,'mat-slide-toggle-') and @class='mat-slide-toggle mat-accent']"));//click on switch to disable hospitals without data
		//switchesOff.get(0).click();
	}
	
	@Then("The user closes Crisis SDP portal and this test is finished")
	public void thenStep() {
		driver.close(); //Close webexplorer
		driver.quit();//Close java Thread
		System.out.print("This test case is OK in Crisis system "+ version + " .");
	}

}
