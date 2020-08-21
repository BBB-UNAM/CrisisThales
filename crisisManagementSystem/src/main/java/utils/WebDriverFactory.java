package utils;

import java.io.File;

/*import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;*/

public class WebDriverFactory {
	
    /*public static void main (String args[]) {
    	System.out.println("hola");
    	firefoxinit();
    	WebDriver driver = new FirefoxDriver();
    	driver.get("https://www.google.com");
    	
    }*/
	
	public void chromeinit() {
		File rootPath = new File("src/main/resources/chromeDriver");
		File chromeFilePath = new File(rootPath,"chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", chromeFilePath.getPath());
		
	}
	
	public static void firefoxinit() {
		File rootPath = new File("src/main/resources/firefoxDriver");
		File chromeFilePath = new File(rootPath,"geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", chromeFilePath.getPath());
		
	}
}
