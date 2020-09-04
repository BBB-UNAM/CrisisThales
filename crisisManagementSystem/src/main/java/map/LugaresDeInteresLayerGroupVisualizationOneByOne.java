package map;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasicUserSteps.EsentialUserSteps;
import JavaTestOfTest.testObjectClases;
import PageObjects.LoginPageObjects;
import PageObjects.MapObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LugaresDeInteresLayerGroupVisualizationOneByOne {
	
	WebDriver driver = null;
	WebElement mapLoaded = null;
	WebElement infoversion = null;
	String version = null;
	EsentialUserSteps basicSteps = null;
	MapObjects elements = null;
	
	@Given("The user opens Crisis login webpage and login in")
	public void givenStep() throws IOException {
		/*WebDriverManager.chromedriver().setup();//Auto setup chromedriver 
		driver = new ChromeDriver(); //Create a object named driver
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicity wait of 10 seconds 
		driver.manage().window().maximize();//maximize browser window
		driver.get("https://mexico02.sdp.thalesdigital.io/sdp-crisis-mx");//load mex02 webpage
		driver.findElement(By.id("username")).sendKeys("operador02");//Send username to user field 
		driver.findElement(By.id("password")).sendKeys("WEhk7Nv:_+");//send password to pass field
		driver.findElement(By.id("kc-login")).click();//click in login button */
		
		this.basicSteps = new EsentialUserSteps(); // crate object named "basic Steps"
		
		this.driver = this.basicSteps.chromeDriverConfig(this.driver); //initialize basic explorer config [this returns "new ChromeDriver"]
		this.basicSteps.initWaitConfig(50, 10, this.driver);//method to initialize wait config (time to load page, time to wait a general webelement, Webdriver)
		
		LoginPageObjects access = new LoginPageObjects(this.driver); //object to set a credentials webelemnts and actions 
		access.setUser();
		access.setPass();
		access.clickOnLoginButton();
	}
		
	
	@When("The crisis main page map is displayed")
	public void whenStep() throws IOException {
		/*WebDriverWait wait = new WebDriverWait(driver, 30);//implicity wait 0f 30 seconds to see Crisis version
		version = driver.findElement(By //save current version of Crisis test
				.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div[@class='container']/div[@class='version']")).getText();
		
		WebElement mapLoaded;
		WebDriverWait waitmap = new WebDriverWait(driver, 30);//implicity wait 0f 30 seconds to see map
		mapLoaded = waitmap.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/iframe[@id=\"angular-oauth-oidc-silent-refresh-iframe\"]")));*/
		
		this.basicSteps.waitTimeoutMapAndVersion(this.driver, this.mapLoaded, this.infoversion, 20); // timeout to define the time to wait to version webelement and map flag
		this.version = this.basicSteps.getInfoVersion(this.driver); // with this method we can get the current Crisis version
		
	}
	
	@And("The user clicks on map Layers button menu")
	public void andStep() throws InterruptedException, IOException {
		/*driver.findElement(By //click on map layes button
				.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div/sdp-map-tools/div/div[2]/mat-icon[@title='Capas del mapa']"))
		.click();
		driver.findElement(By.xpath("//*[contains(@id,'mat-expansion-panel-header-')]")).click(); //click on intitution layers drop down list 
		//Thread.sleep(2000);*/
		this.elements = new MapObjects(); //iniclalizamos el objeto "Elements"
		this.elements.clickOnMapButtons(this.driver, 1); // click on button "Layers" option 1
		//Thread.sleep(200);
		this.elements.clickOnHospitalesDropDown(this.driver); //clicks on drop down of hospitals
		//Thread.sleep(500);
		//

		
			
	}
	
	@And("The user clicks in each layer institution to disable it")
	public void andAndStep() throws InterruptedException, IOException {
		
		List<WebElement> instituciones = this.elements.getInstitucionesLayerButtonList(this.driver);
		
		for(int i = 0; i < 9; i++) {
			this.elements.clickOnListElements(this.driver, instituciones, i);
			//Thread.sleep(100);
		}
		
		for(int i = 0; i < 9; i++) {
			this.elements.clickOnListElements(this.driver, instituciones, i);
			//Thread.sleep(100);
		}
		
		Thread.sleep(1000);
	}
	//gtgtgtgtgtgtgtrgtrgrtgtrgtrgrg
	@Then("The user clicks in each layer institution to enable it")
	public void thenStep() {
		this.basicSteps.finalTestActions(this.driver);// actions to close the map and java Thread
		System.out.print("This test case is OK in Crisis system "+ this.version + " .");
	}
}
