package map;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class ResetInitialOrientationMap {
	
	WebDriver driver;
	String version;
	
	@Given("The user opens chrome and login in Crisis")
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
		
	}
	
	@When("The crisis map is displayed")
	public void when() {
		
		WebElement mapLoaded;
		WebDriverWait waitmap = new WebDriverWait(driver, 30);//implicity wait 0f 30 seconds to see map
		mapLoaded = waitmap.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//html/body/iframe[@id=\"angular-oauth-oidc-silent-refresh-iframe\"]")));
		
	}
	
	@And("The user move orientation of crisis map")
	public void and() throws InterruptedException {
		
		//Identify map WebElement across xpah
		WebElement centerMap = driver.findElement(By.xpath("//*[@id='map']/div[@class='mapboxgl-canvas-container mapboxgl-interactive mapboxgl-touch-drag-pan mapboxgl-touch-zoom-rotate']/canvas"));
						
		Actions builder = new Actions(driver);
				
		Action modifyMapRotation = builder
				.moveToElement(centerMap, 0, 0)
				.keyDown(Keys.CONTROL)
				.clickAndHold()
				.moveByOffset(-100, 100)
				.release()
				.build();
				
		Thread.sleep(4000);
				
		modifyMapRotation.perform();
		
	}
	
	@Then("The user reset the map orientation")
	public void then() throws InterruptedException {
		//locate the button and click on it reset position
		List<WebElement> mapOptions = driver.findElements(By.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div/sdp-map-tools/div/div[@class='menuButton ng-star-inserted']/mat-icon"));
		mapOptions.get(3).click();
		
		Thread.sleep(4000);//stop thread for 4 seconds 
		
		driver.close();//close webbrowser 
		driver.quit();//close java thread 
		
	}

}
