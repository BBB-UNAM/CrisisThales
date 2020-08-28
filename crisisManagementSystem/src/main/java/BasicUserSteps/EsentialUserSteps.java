package BasicUserSteps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EsentialUserSteps {
	
	//config load timeout and implicity wait time in seconds 
	
	public WebDriver chromeDriverConfig(WebDriver driver) {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();		
	}
	
	public void initWaitConfig(int waitLoadPage, int waitElement, WebDriver driver) throws IOException {
		//WebDriverManager.chromedriver().setup();
		
		//driver = new ChromeDriver();
		driver.get(getFileProperties.getTestProperties("URLMEX02"));
		
		driver.manage().timeouts().pageLoadTimeout(waitLoadPage, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(waitElement, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
	}
	
	//this method is used to define the max time to wait of the info version and map flag to contnue the code execution
	public void waitTimeoutMapAndVersion (WebDriver driver, WebElement mapLoaded , WebElement infoversion, int timeToWait) throws IOException {
		infoversion = new WebDriverWait(driver, timeToWait).until(ExpectedConditions.visibilityOfElementLocated(By
				.xpath(getFileProperties.getByElementsProperties("XPATHinfoVERSION"))));
		
		mapLoaded = new WebDriverWait(driver, timeToWait).until(ExpectedConditions.presenceOfElementLocated(By.xpath(getFileProperties.getByElementsProperties("XPATHmapFLAG"))));
	}
	
	//method to return Crisis version
	public String getInfoVersion(WebDriver driver) throws IOException {
		return driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHinfoVERSION"))).getText();
	}
	
	//method to closes Web browser and current java tharead
	public void finalTestActions(WebDriver driver) {
		driver.close();
		driver.quit();
	}

}

