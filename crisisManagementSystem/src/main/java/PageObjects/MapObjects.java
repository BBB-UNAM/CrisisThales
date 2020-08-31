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
	
	
	
	//this methos clicks on drop drop down list institutions
	public void clickOnHospitalesDropDown (WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHhospitalesDropDown"))).click();
	}
	
	/* 
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
	 */
	//With this method we can get the list of institutions buttons
	public List<WebElement> getInstitucionesLayerButtonList(WebDriver driver) throws IOException{
		return driver.findElements(By.xpath(getFileProperties.getByElementsProperties("XPATHinstitucioneslist"))); 
	}
	
	/*
	 * 0 - ALCALDIAS 
	 * 1 - CLONIAS
	 * 2 - SECTORES
	 * */
	//this mothod returns a list of buttons named geografia
	public List<WebElement> geografiaButtonsList(WebDriver driver) throws IOException{
		return driver.findElements(By.xpath(getFileProperties.getByElementsProperties("XPATHgeografilaLAYERSlist")));
	}
	
	//this class clicks on traslados por alcaldia layers
	public void clickOnTrasladosPorAlcalidaLayer (WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHtrasladosPorAlcadiaBUTTON"))).click();
	}
	
	//this mothod clicks on traslados arcos button
	public void clickOnTrasladosArcosButton (WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHtrasladosArcosBUTTON"))).click();
	}
	
	//this method clicks on Covid 19 por alcaldia button
	public void clickOnCovid19PorAlcaldiaButton (WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHcovid19PorAlcaldiaButton"))).click();
	}
	
	//this method clicks on llamdas button
	public void clickOnllamadasButton (WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHllamadasBUTTON"))).click();
	}
	
	
	public void clickOnaccidentesVialesGridButton (WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHaccidentesVialesGridButton"))).click();
	}
	
	//this method returns all list of switch buttons 
	public List<WebElement> getSwitchMenuButtons(WebDriver driver) throws IOException{
		return driver.findElements(By.xpath(getFileProperties.getByElementsProperties("XPATHaccidentesVialesSWITHList")));
	}
	
	// with this method we can click on any list options
	public void clickOnListElements (WebDriver driver, List<WebElement> swithcbutton, int option) throws IOException {
		swithcbutton.get(option).click();
	}
	
}
