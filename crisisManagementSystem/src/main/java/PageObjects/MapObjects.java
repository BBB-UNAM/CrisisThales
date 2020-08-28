package PageObjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.getFileProperties;

public class MapObjects {
	WebElement mapArea;
	WebDriver driver;
	public List<WebElement> mapButton;
	
	
	/* 
	 * this below class allow us to click on some map options
	 * 1 - click on "Restablecer centro del mapa"
	 * 2 - click on "Capas del mapa"
	 * 3 - click on "Ir a vista 2D"
	 * 4 - click on "Resetear rotación del mapa"
	 * */
	public void clickOnMapButtons(WebDriver driver, int option) throws IOException {
		this.mapButton = driver.findElements(By.xpath(getFileProperties.getByElementsProperties("XPATHmapBUTTONSlist")));
		this.mapButton.get(option).click();
	}
	
	//this method clicks on camas generales, camas UCI Switch
	public void clickCamasGeneralesUCISwitch(WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHcamasUCIgeneralesSWITCH"))).click();
	}
	
	// this method clicks on switch named "Elementos sin datos" in layes menu
	public void clickOnElementosSinDatosSwitch(WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHverELEMENTOSsinDATOSswith"))).click();
	}
	
	
}
