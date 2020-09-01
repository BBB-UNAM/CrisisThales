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

public class ViewHospitalMenuDetails {
	
	WebDriver driver = null;
	WebElement mapLoaded = null;
	WebElement infoversion = null;
	String version = null;
	EsentialUserSteps basicSteps = null;
	MapObjects elements = null;
	
	@Given("The user statr chrome and log in crisis map")
	public void given() throws IOException {
		
		/*WebDriverManager.chromedriver().setup();//Auto setup chromedriver 
		driver = new ChromeDriver(); //Create a object named driver
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicity wait of 10 seconds 
		driver.manage().window().maximize();//maximize browser window
		driver.get("https://mexico02.sdp.thalesdigital.io/sdp-crisis-mx");//load mex02 webpage
		driver.findElement(By.id("username")).sendKeys("operador02");//Send username to user field 
		driver.findElement(By.id("password")).sendKeys("WEhk7Nv:_+");//send password to pass field
		driver.findElement(By.id("kc-login")).click();//click in login button 
		
		WebElement infoVersion;//Webelement object type
		WebDriverWait wait = new WebDriverWait(driver, 30);//implicity wait 0f 30 seconds to see Crisis version
		infoVersion = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div[@class='container']/div[@class='version']")));
		
		version = driver.findElement(By //save current version of Crisis test
				.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div[@class='container']/div[@class='version']")).getText();
		
		WebElement mapLoaded;
		WebDriverWait waitmap = new WebDriverWait(driver, 30);//implicity wait 0f 30 seconds to see map
		mapLoaded = waitmap.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/iframe[@id=\"angular-oauth-oidc-silent-refresh-iframe\"]")));*/
		
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
	
	@When("The user search some hospital")
	public void when() throws IOException, InterruptedException {
		
		/*WebElement buscarBarXp = driver.findElement(By.xpath("//*[contains(@id,'mat-input-')]"));//find webelement "barra de busqueda" using xpath
		//WebElement firstResultSearch = driver.findElement(By.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav/div/sdp-crisis-details-ui/mat-sidenav-content/sdp-crisis-search-results/sdp-caption-panel/div/div[2]/div/sdp-scrollable/div/ng-scrollbar/div/div/div/div/div/div[1]"));
		
		
		builder= new Actions(driver);
		
		Action buscaBarOp = builder
				.sendKeys(buscarBarXp, "belisario")
				.sendKeys(Keys.ESCAPE) //presionamos ESC para que no salga el menu de sugerencias 
				.sendKeys(Keys.ENTER)
				.click()
				.build();
		
		buscaBarOp.perform();	*/
		
		this.elements = new MapObjects();//start intance named elements 
		this.elements.searchAHospital(this.driver); // this method search a hospital
		this.elements.clickOnSearchResult(driver); //this method clicks on search result
		
	}

	@And("The user find a hospital and click on it to see options")
	public void and() throws InterruptedException, IOException {
		
		/*WebElement firstResultSearch = driver.findElement(By.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav/div/sdp-crisis-details-ui/mat-sidenav-content/sdp-crisis-search-results/sdp-caption-panel/div/div[@class='content']/div/sdp-scrollable/div/ng-scrollbar/div/div/div/div/div/div[1]"));
		
		Action clickOnSearchResult = builder
				.moveToElement(firstResultSearch)
				.click()
				.moveByOffset(10, -10)
				.click()
				.build();
		
		clickOnSearchResult.perform();
		
		//Weblement focused of map center 
		WebElement centerOfMap = driver.findElement(By.xpath("//*[@id='map']/div[@class='mapboxgl-canvas-container mapboxgl-interactive mapboxgl-touch-drag-pan mapboxgl-touch-zoom-rotate']/canvas"));
		
		Action openHospitalDetails = builder
				.moveToElement(centerOfMap)//click on hospital when it is located in the map
				.click()
				.build();
		
		openHospitalDetails.perform();
		
		Thread.sleep(3000);*/
		
		this.elements.focusedOnMapCenter(driver, 1);
		Thread.sleep(1000);	
		
	}

	@Then("The user closes chrome web explorer")
	public void then() {
		/*driver.close();
		driver.quit();*/
		//Thread.sleep(1000);
		
		this.basicSteps.finalTestActions(this.driver);// actions to close the map and java Thread
		System.out.print("This test case is OK in Crisis system "+ this.version + " .");
		
	}


}
