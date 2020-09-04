package PageObjects;

import java.io.IOException;
import java.util.List;
import org.testng.Assert;

import BasicUserSteps.EsentialUserSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import utils.getFileProperties;

public class MapObjects {
	
	WebElement mapArea;
	WebDriver driver;
	public List<WebElement> mapButton; //list of main map buttons
	public List<WebElement> institutions; //list of institutions 
	public List<WebElement> geografia; //list of geografia layer buttons
	
	/* 
	 * this below class allow us to click on some map options
	 * 0 - click on "Restablecer centro del mapa"
	 * 1 - click on "Capas del mapa"
	 * 2 - click on "Ir a vista 2D"
	 * 3 - click on "Resetear rotación del mapa"
	 * */
	public void clickOnMapButtons(WebDriver driver, int option) throws IOException {
		Assert.assertFalse(driver.findElements(By.xpath(getFileProperties.getByElementsProperties("XPATHmapBUTTONSlist"))).isEmpty(), "Los botones del mapa no son reconocidos");
		this.mapButton = driver.findElements(By.xpath(getFileProperties.getByElementsProperties("XPATHmapBUTTONSlist")));
		this.mapButton.get(option).click();
	}
	
	//this method clicks on camas generales, camas UCI Switch
	public void clickCamasGeneralesUCISwitch(WebDriver driver) throws IOException {
		Assert.assertTrue(driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHcamasUCIgeneralesSWITCH"))).isDisplayed(), "El switch de mamas Generales/UCI no es reconocido");
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHcamasUCIgeneralesSWITCH"))).click();
	}
	
	// this method clicks on switch named "Elementos sin datos" in layes menu
	public void clickOnElementosSinDatosSwitch(WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHverELEMENTOSsinDATOSswith"))).click();
	}
	
	
	public void clickOnLugaresDeInterez(WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHLugaresDeInteres"))).click();
	}
	
	//this methos clicks on drop drop down list institutions
	public void clickOnHospitalesDropDown (WebDriver driver) throws IOException {
		driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHhospitalesDropDown"))).click();
	}
	
	/* 
	 * 0  - SSA
	 * 1  - SEDESA 
	 * 2  - IMSS
	 * 3  - ISSTE
	 * 4  - SEDENA
	 * 5  - CAMI
	 * 6  - SEMAR
	 * 7  - PRIVADO
	 * 8  - PEMEX
	 * 9 - EDOMEX
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
	
	public void clickOnGeografiaButtons (WebDriver driver, List<WebElement> lista , int flag) {
		lista.get(flag).click();
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
	
	//with this method we can move the main orientation of map
	public void moveMapLocation(WebDriver driver) throws IOException, InterruptedException {
		Actions builder = new Actions(driver);
		
		WebElement map = driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHmap")));
		
		Action mauseOverMap = builder //we use action class to make action to drag and drop click over map
				.moveToElement(map, 0, 0)
				.clickAndHold()
				.moveByOffset(-410,-410)
				.release()
				.build();
		mauseOverMap.perform();
		Thread.sleep(2000);
	}
	
	//with this method we can 
	public void searchAHospital (WebDriver driver, String hosp) throws IOException, InterruptedException {
		
		WebElement buscarBarXp = driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHbarraDeBusqueda")));
		
		Actions builder = new Actions(driver);
		
		Action buscaBarOp = builder
				.sendKeys(buscarBarXp, hosp)
				.sendKeys(Keys.ESCAPE) //presionamos ESC para que no salga el menu de sugerencias 
				.sendKeys(Keys.ENTER)
				.click()
				.build();
		
		buscaBarOp.perform();
		Thread.sleep(2000);
	}
	
	//With this class we can click on search result
	public void clickOnSearchResult(WebDriver driver) throws IOException, InterruptedException {
		WebElement firstResultSearch = driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XpathResultadoBusqueda")));
		
		Actions builder= new Actions(driver);
		
		Action clickOnSearchResult = builder
				.moveToElement(firstResultSearch)
				.click()
				.moveByOffset(10, -10)
				.click()
				.build();
		
		clickOnSearchResult.perform();
		
	}
	
	//with this class we can focus on map center and click on the element focuses (flag=0 not click, flag=1 click on element)
	public void focusedOnMapCenter(WebDriver driver , int flag) throws IOException, InterruptedException {
		
		WebElement centerOfMap = driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHmap")));
		Actions builder= new Actions(driver);
		
		if(flag == 0) {
			//Actions builder= new Actions(driver);
			
			Action openHospitalDetails = builder
					.moveToElement(centerOfMap)//click on hospital when it is located in the map
					//.click()
					.build();
			
			openHospitalDetails.perform();
		} 
		
		if(flag == 1) {
			//Actions builder= new Actions(driver);
			Action openHospitalDetails = builder
					.moveToElement(centerOfMap)//click on hospital when it is located in the map
					.click()
					.build();
			
			openHospitalDetails.perform();
		}
		
		Thread.sleep(1000);
	}
	
	public void waitToolTip (WebDriver driver) throws IOException {
		
		EsentialUserSteps basicSteps = new EsentialUserSteps();
			//Boolean flag = driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHToolTip"))).isDisplayed()
			
			try {
				driver.findElement(By.xpath(getFileProperties.getByElementsProperties("XPATHToolTip")));
			}
			catch(NoSuchElementException excepcion) {
				basicSteps.finalTestActions(driver);
				Assert.assertFalse(true, "The tooltip isn't displayed");
			}
	
	}
}
