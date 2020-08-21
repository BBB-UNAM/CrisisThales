package map;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ResetInicialPositionMap {
	
	WebDriver driver;
	String version;
	
	@Given("The user opens the web browser")
	public void given() {
		WebDriverManager.chromedriver().setup();//Auto setup chromedriver 
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
		mapLoaded = waitmap.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/iframe[@id=\"angular-oauth-oidc-silent-refresh-iframe\"]")));
	} 
	
	@When("The user move the position of crisis map")
	public void when() throws InterruptedException {
Actions builder = new Actions(driver);
		
		///html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content
		///html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div
        //We select a map area as a WebElement
		WebElement map = driver.findElement(By.xpath("//*[@id='map']/div[@class='mapboxgl-canvas-container mapboxgl-interactive mapboxgl-touch-drag-pan mapboxgl-touch-zoom-rotate']/canvas"));
		
		//System.out.print(driver.findElement(By.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div")).getText());
		Action mauseOverMap = builder //we use action class to make action to drag and drop click over map
				.moveToElement(map, 0, 0)
				.clickAndHold()
				.moveByOffset(-410,-410)
				.release()
				.build();
		mauseOverMap.perform();
		Thread.sleep(2000);
	} 
	
	@And("The user press button to reset the default position of map")
	public void and() throws InterruptedException {
		List<WebElement> mapOptions = driver //a javalist to gef webelement of each map buttons
				.findElements(By.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div/sdp-map-tools/div/div[@class='menuButton ng-star-inserted']/mat-icon"));
		mapOptions.get(0).click();//click in buton to reset map default position
		Thread.sleep(500); //stop java thread for 0.5 seconds 
	} 
	
	@Then("The user closes the web browser")
	public void then() {
		driver.close(); //close webbrowser
		driver.quit();//close webdriver thred
		System.out.println("This test is OK in Crisis " + version); //print version of test
	} 

}
