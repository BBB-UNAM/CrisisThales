package JavaTestOfTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import PageObjects.LoginPageObjects;
import utils.getFileProperties;//static class
import BasicUserSteps.EsentialUserSteps;

public class login {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();//Auto setup chromedriver 
		WebDriver driver = new ChromeDriver(); //Create a object named driver
		
		LoginPageObjects credentials = new LoginPageObjects(driver);
		
		EsentialUserSteps timeOuts = new EsentialUserSteps();
		
		timeOuts.configImplicitPageLoadWait(20, driver);
		//driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.NANOSECONDS);//implicity wait of 10 seconds 
		driver.manage().window().maximize();
		driver.get(getFileProperties.getProperties("URLMEX02"));
		//driver.getTitle()
		String url = driver.getCurrentUrl();
		
		credentials.setUser();
		credentials.setPass();
		//driver.findElement(By.id("username")).sendKeys("operador02");//Send username to user field
		//driver.findElement(By.id("password")).sendKeys("WEhk7Nv:_+");//send password to pass field
		
		//System.out.println(driver.getTitle());
		credentials.clickOnLoginButton();//click in login button 
		WebElement bedsSwitch;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		bedsSwitch = wait.until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div[@class='container']/div[@class='version']")));
		
		String test = driver.findElement(By.xpath("/html/body/sdp-root/sdp-crisis-page/div/mat-sidenav-container/mat-sidenav-content/div/sdp-crisis-map/div[@class='container']/div[@class='version']")).getText();
		driver.close();
		driver.quit();
		System.out.println(url);
		//assertEquals(test, "V 1.2.19", "This version isn't expected to test");
		//assertEquals(url, "https://mexico02.sdp.thalesdigital.io/auth/realms/sdp-ui/protocol/openid-connect/auth?acr_values=&approval_prompt=force&client_id=oidc-proxy&redirect_uri=https%3A%2F%2Fmexico02.sdp.thalesdigital.io%2Foauth2%2Fcallback&response_type=code&scope=api&state=fd41dcacbf10f782a5baaf6426ddad2d%3A%2Fsdp-crisis-mx", "This url Isn't the expected to this test ");

	}

}
