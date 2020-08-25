package map;

import java.util.List;
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

public class LugaresDeInteresLayerGroupVisualizationOneByOne {
	
	WebDriver driver;
	String version;
	
	@Given("The user opens Crisis login webpage and login in")
	public void crisisOpenAndLogin() {
		WebDriverManager.chromedriver().setup();//Auto setup chromedriver 
		driver = new ChromeDriver(); //Create a object named driver
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicity wait of 10 seconds 
		driver.manage().window().maximize();//maximize browser window
		driver.get("https://mexico02.sdp.thalesdigital.io/sdp-crisis-mx");//load mex02 webpage
		driver.findElement(By.id("username")).sendKeys("operador02");//Send username to user field 
		driver.findElement(By.id("password")).sendKeys("WEhk7Nv:_+");//send password to pass field
		driver.findElement(By.id("kc-login")).click();//click in login button 
	}
	
	@When("The crisis main page map is displayed")
	public void crisisOpenMainPage() {
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
	
	@And("The user clicks on map Layers button menu")
	public void crisisOpenLayerMenu() throws InterruptedException {
		driver.findElement(By //click on map layes button
				.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div/sdp-map-tools/div/div[2]/mat-icon[@title='Capas del mapa']"))
		.click();
		driver.findElement(By.xpath("//*[@id='mat-expansion-panel-header-0']")).click(); //click on intitution layers drop down list 
		//Thread.sleep(2000);
			
	}
	
	@And("The user clicks in each layer institution to disable it")
	public void crisisEnabeLayers() throws InterruptedException {
		//this list contains all buttons with the folowing xpat: $x("//*[contains(@id,'cdk-accordion-child-')]/div/div[@class='sub-setting ng-star-inserted']/mat-icon")
		List<WebElement> instButtons = driver.findElements(By.xpath("//*[contains(@id,'cdk-accordion-child-')]/div/div[@class='sub-setting ng-star-inserted']/mat-icon"));
		
		//click in each button to disable layers of institute
		for(int i = 0; i< instButtons.size(); i++) {
			instButtons.get(i).click();
			Thread.sleep(200);
		}
		//click in each button to enable layers of institute
		for(int i = 0; i< instButtons.size(); i++) {
			instButtons.get(i).click();
			Thread.sleep(200);
		}
		
	}
	//gtgtgtgtgtgtgtrgtrgrtgtrgtrgrg
	@Then("The user clicks in each layer institution to enable it")
	public void crisisDisableLayer() {
		driver.close(); //Close webexplorer
		driver.quit();//Close java Thread
		System.out.print("This test case is OK in Crisis system "+ version + " .");
	}
}
