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

public class ResetInicialPositionMap {
	
	WebDriver driver = null;
	WebElement mapLoaded = null;
	WebElement infoversion = null;
	String version = null;
	EsentialUserSteps basicSteps = null;
	MapObjects elements = null;
	
	@Given("The user opens the web browser")
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
	
	@When("The user move the position of crisis map")
	public void when() throws InterruptedException, IOException {
		//Actions builder = new Actions(driver);
		
		///html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content
		///html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div
        //We select a map area as a WebElement
		/*WebElement map = driver.findElement(By.xpath("//*[@id='map']/div[@class='mapboxgl-canvas-container mapboxgl-interactive mapboxgl-touch-drag-pan mapboxgl-touch-zoom-rotate']/canvas"));
		
		//System.out.print(driver.findElement(By.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div")).getText());
		Action mauseOverMap = builder //we use action class to make action to drag and drop click over map
				.moveToElement(map, 0, 0)
				.clickAndHold()
				.moveByOffset(-410,-410)
				.release()
				.build();
		mauseOverMap.perform();
		Thread.sleep(2000);*/
		
		this.elements = new MapObjects(); //initialize the elements object
		
		this.elements.moveMapLocation(this.driver);
		
		
		
	} 
	
	@And("The user press button to reset the default position of map")
	public void and() throws InterruptedException, IOException {
		/*List<WebElement> mapOptions = driver //a javalist to gef webelement of each map buttons
				.findElements(By.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div/sdp-map-tools/div/div[@class='menuButton ng-star-inserted']/mat-icon"));
		mapOptions.get(0).click();//click in buton to reset map default position
		Thread.sleep(500); //stop java thread for 0.5 seconds */
		this.elements.clickOnMapButtons(this.driver,0);
		Thread.sleep(1000);
	} 
	
	@Then("The user closes the web browser")
	public void then() {
		/*driver.close(); //close webbrowser
		driver.quit();//close webdriver thred
		System.out.println("This test is OK in Crisis " + version); //print version of test*/
		this.basicSteps.finalTestActions(this.driver);// actions to close the map and java Thread
		System.out.print("This test case is OK in Crisis system "+ this.version + " .");
	} 

}
