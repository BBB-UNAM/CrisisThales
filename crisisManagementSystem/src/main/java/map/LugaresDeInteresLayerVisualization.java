package map;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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

public class LugaresDeInteresLayerVisualization {
	WebDriver driver;
	String version;

	@Given("The user opens Crisis login webpage and insert a valid credentials to login")
	public void openAndLoginCrisis() {
		WebDriverManager.chromedriver().setup();//Auto setup chromedriver 
		driver = new ChromeDriver(); //Create a object named driver
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicity wait of 10 seconds 
		driver.manage().window().maximize();//maximize browser window
		driver.get("https://mexico02.sdp.thalesdigital.io/sdp-crisis-mx");//load mex02 webpage
		driver.findElement(By.id("username")).sendKeys("operador02");//Send username to user field 
		driver.findElement(By.id("password")).sendKeys("WEhk7Nv:_+");//send password to pass field
		driver.findElement(By.id("kc-login")).click();//click in login button 
	}
	
	@When("The crisis main page with the map is displayed")
	public void mapOperations() {
		
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
	
	@And("The user clicks on map Layers button")
	public void layerOperations() throws InterruptedException {
		driver.findElement(By //click on map layes button
				.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div/sdp-map-tools/div/div[2]/mat-icon[@title='Capas del mapa']"))
		.click();
		
		for(int i=0; i < 5;i++) {
			driver.findElement(By //Click to disable the LUGARES DE INTERES layer
					.xpath("//*[@id='cdk-overlay-0']/sdp-portal-host/div/div[@class='container portal-panel']/sdp-crisis-map-layers/div[@class='container']/div[@class='setting']/div[@class='setting-header']/mat-icon"))
			.click();
			Thread.sleep(1500); //Sleep thread for 1.5 seconds 
			driver.findElement(By//Click to enable the LUGARES DE INTERES layer
					.xpath("//*[@id='cdk-overlay-0']/sdp-portal-host/div/div[@class='container portal-panel']/sdp-crisis-map-layers/div[@class='container']/div[@class='setting']/div[@class='setting-header disabled-item']/mat-icon"))
			.click();
		}
		
	}
	
	@Then("The user can disable and enable LUGARES DE INTERES layer")
	public void enableDisableOperations() {
		driver.close();//Close explorer
		driver.quit();// Close Thread
		System.out.print("This test case is OK in Crisis system "+ version + " .");
	}
}
