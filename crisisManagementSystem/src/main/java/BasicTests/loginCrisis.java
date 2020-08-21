package BasicTests;

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


public class loginCrisis {
	
	//WebDriverManager getBrowser;
	WebDriver driver;
	
	@Given("The user opens the web browser")
	public void openWebBrowser () {
		WebDriverManager.chromedriver().setup();//Auto setup chromedriver 
		driver = new ChromeDriver(); //Create a object named driver
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //implicity wait of 10 seconds 
		driver.manage().window().maximize();//Maximize web browser
		driver.get("https://mexico02.sdp.thalesdigital.io/sdp-crisis-mx");//navigate to Crisis url
	}
	
	@When("The user set username")
	public void setCrisiswebPage () {	
		driver.findElement(By.id("username")).sendKeys("operador02");//Send username to user field 
	}
	
	@And("The user set a password")
	public void setcredentials () {
		driver.findElement(By.id("password")).sendKeys("WEhk7Nv:_+");//send password to pass field
	}
	
	@Then("The Crisis main page is displayed")
	public void checkMapPage () {
		driver.findElement(By.id("kc-login")).click();//click in login button 
		WebElement bedsSwitch;//Webelement object type
		WebDriverWait wait = new WebDriverWait(driver, 30);//implicity wait 0f 30 seconds to see Crisis version
		bedsSwitch = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div[@class='container']/div[@class='version']")));
		driver.close();//Close explorer
		driver.quit();// Close Thread
	}
	
}