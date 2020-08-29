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
	public List<WebElement> mapButton; //list of main map buttons
	public List<WebElement> institutions; //list of institutions 
	public List<WebElement> geografia; //list of geografia layer buttons
	
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
	
	
	public void clickOnHospitalesDropDown (WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHhospitalesDropDown"))).click();
	}
	
	/* With this class we can click on each institution layer (inst var is the instiotution to do click)
	 * 1  - SSA
	 * 2  - SEDESA 
	 * 3  - IMSS
	 * 4  - ISSTE
	 * 5  - SEDENA
	 * 6  - CAMI
	 * 7  - SEMAR
	 * 8  - PRIVADO
	 * 9  - PEMEX
	 * 10 - EDOMEX
	 * We need to get a list of elements 
	 * */
	public List<WebElement> getInstitucionesLayerButtonList(WebDriver driver) throws IOException{
		return driver.findElements(By.xpath(getFileProperties.getByElementsProperties("XPATHinstitucioneslist"))); 
	}
	public void clickOnInstitucionesLayer (WebDriver driver, List<WebElement> institutions, int inst) throws IOException {
		
		//this.institutions =  driver.findElements(By.xpath(getFileProperties.getByElementsProperties("XPATHinstitucioneslist")));
		institutions.get(inst).click();
	}
	
	/*With this class we can click on geografia options
	 * 1 - ALCALDIAS 
	 * 2 - CLONIAS
	 * 3 - SECTORES
	 * */
	public void clickOnGegrafiaOptionButtons (WebDriver driver, int prop) throws IOException {
		this.geografia =  driver.findElements(By.xpath(getFileProperties.getByElementsProperties("XPATHgeografilaLAYERSlist")));
		this.geografia.get(prop).click();
	}
	
	public void clickOnTrasladosPorAlcalidaLayer (WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHtrasladosPorAlcadiaBUTTON"))).click();
	}
	
	public void clickOnTrasladosArcosButton (WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHtrasladosArcosBUTTON"))).click();
	}
	
	public void clickOnCovid19PorAlcaldiaButton (WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHcovid19PorAlcaldiaButton"))).click();
	}
	
	public void clickOnllamadasButton (WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHllamadasBUTTON"))).click();
	}
	
	public void clickOnaccidentesVialesGridButton (WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHaccidentesVialesGridButton"))).click();
	}
	
	public void clickOnAccidentesVialesSWITH (WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("//mat-slide-toggle[2]"))).click();
	}
	
	public void clickOnCovid19XalcaldiaSWITH (WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHcovid19XalcaldiaSWITH"))).click();
	}
}
