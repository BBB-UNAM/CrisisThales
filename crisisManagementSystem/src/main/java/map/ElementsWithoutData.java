package map;

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

public class ElementsWithoutData {
	
	WebDriver driver;
	String version;
	
	@Given("The user opens Crisis Map portal and login in")
	public void givenStep() {
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
