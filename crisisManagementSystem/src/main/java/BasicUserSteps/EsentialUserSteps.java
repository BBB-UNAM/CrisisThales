package BasicUserSteps;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

public class EsentialUserSteps {
	
	public void configImplicitPageLoadWait(int time,WebDriver driver) {
		driver.manage().timeouts().pageLoadTimeout(time, TimeUnit.SECONDS);
	}
	
	public void configImplicitWebElementsWait(int time,WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public void initConfig(int waitLoadPage, int waitElement, WebDriver driver) {
		
		driver.manage().timeouts().pageLoadTimeout(waitLoadPage, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(waitElement, TimeUnit.SECONDS);
	}

}
