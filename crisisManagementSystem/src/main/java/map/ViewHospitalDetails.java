package map;

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

public class ViewHospitalDetails {
	
	WebDriver driver;
	String version;
	Actions builder;
	
	@Given("The final user open explorer and login")
	public void Given() {
		
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
	
	@When("The user search the name of one hospital")
	public void When() {
		
		WebElement buscarBarXp = driver.findElement(By.xpath("//*[contains(@id,'mat-input-')]"));//find webelement "barra de busqueda" using xpath
		//WebElement firstResultSearch = driver.findElement(By.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav/div/sdp-crisis-details-ui/mat-sidenav-content/sdp-crisis-search-results/sdp-caption-panel/div/div[2]/div/sdp-scrollable/div/ng-scrollbar/div/div/div/div/div/div[1]"));
		builder= new Actions(driver);
		
		Action buscaBarOp = builder
				.sendKeys(buscarBarXp, "belisario")
				.sendKeys(Keys.ESCAPE) //presionamos ESC para que no salga el menu de sugerencias 
				.sendKeys(Keys.ENTER)
				.click()
				.build();
		
		buscaBarOp.perform();
		
	}
	
	@And("The user find a hospital")
	public void And() {
		
		WebElement firstResultSearch = driver.findElement(By.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav/div/sdp-crisis-details-ui/mat-sidenav-content/sdp-crisis-search-results/sdp-caption-panel/div/div[@class='content']/div/sdp-scrollable/div/ng-scrollbar/div/div/div/div/div/div[1]"));
		
		Action clickOnSearchResult = builder
				.moveToElement(firstResultSearch)
				.click()
				.moveByOffset(10, -10)
				.click()
				.build();
		
		clickOnSearchResult.perform();
		
		
		
	}
	
	@Then("The user closes the crisis page and the browser")
	public void Then() throws InterruptedException {
		
		//Weblement focused of map center 
		WebElement centerOfMap = driver.findElement(By.xpath("//*[@id='map']/div[@class='mapboxgl-canvas-container mapboxgl-interactive mapboxgl-touch-drag-pan mapboxgl-touch-zoom-rotate']/canvas"));
		
		Action openHospitalDetails = builder
				.moveToElement(centerOfMap)//click on hospital when it is located in the map
				//.click()
				.build();
		
		openHospitalDetails.perform();
		
		Thread.sleep(4000);
		
		driver.close(); //closes webexplorer
		driver.quit(); //closes Thread
		
	}

}
