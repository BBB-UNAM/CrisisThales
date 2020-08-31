package JavaTestOfTest;
import utils.getFileProperties;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import BasicUserSteps.EsentialUserSteps;
import PageObjects.*;

public class testObjectClases {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = null;
		WebElement mapLoaded = null;
		WebElement infoversion = null;
		String version;
		EsentialUserSteps basicSteps;
		MapObjects elements;
		

		basicSteps = new EsentialUserSteps(); // crate object named "basic Steps"
		
		driver = basicSteps.chromeDriverConfig(driver); //initialize basic explorer config [this returns "new ChromeDriver"]
        basicSteps.initWaitConfig(50, 10, driver);//method to initialize wait config (time to load page, time to wait a general webelement, Webdriver)
		
		LoginPageObjects access = new LoginPageObjects(driver); //object to set a credentials webelemnts and actions 
		access.setUser();
		access.setPass();
		access.clickOnLoginButton();
		
		basicSteps.waitTimeoutMapAndVersion(driver, mapLoaded, infoversion, 20); // timeout to define the time to wait to version webelement and map flag
		version = basicSteps.getInfoVersion(driver); // with this method we can get the current Crisis version
		
		MapObjects mapa = new MapObjects();
		
		
		for(int i=0; i < 4; i++) {
			mapa.clickOnMapButtons(driver, i);
		}
		
		for(int i=0; i < 4; i++) {
			mapa.clickCamasGeneralesUCISwitch(driver);
			Thread.sleep(200);
		}
		
		mapa.clickOnElementosSinDatosSwitch(driver);
		Thread.sleep(200);
		
		mapa.clickOnHospitalesDropDown(driver);
		Thread.sleep(200);
		
		List<WebElement> bootonesInst = mapa.getInstitucionesLayerButtonList(driver);
		for(int i=0; i < 10; i++) {
			mapa.clickOnListElements(driver, bootonesInst, i);
			Thread.sleep(100);
		}
		
		
		List<WebElement> bootonesGeog = mapa.geografiaButtonsList(driver);
		
		for(int i=0; i < 3; i++) {
			mapa.clickOnListElements(driver, bootonesGeog, i);
			Thread.sleep(200);
		}
		
		mapa.clickOnHospitalesDropDown(driver);
		Thread.sleep(200);
		
		mapa.clickOnTrasladosPorAlcalidaLayer(driver);
		
		Thread.sleep(900);
		
		mapa.clickOnTrasladosPorAlcalidaLayer(driver);
		
		Thread.sleep(900);
		
		
		mapa.clickOnTrasladosArcosButton(driver);
		Thread.sleep(900);
		
		mapa.clickOnTrasladosArcosButton(driver);
		Thread.sleep(900);
		
		
		mapa.clickOnCovid19PorAlcaldiaButton(driver);
		Thread.sleep(900);
		mapa.clickOnCovid19PorAlcaldiaButton(driver);
		Thread.sleep(900);
		
		mapa.clickOnllamadasButton(driver);
		Thread.sleep(900);
		mapa.clickOnllamadasButton(driver);
		Thread.sleep(900);
		
		mapa.clickOnaccidentesVialesGridButton(driver);
		Thread.sleep(900);
		mapa.clickOnaccidentesVialesGridButton(driver);
		Thread.sleep(900);
		
		List<WebElement> switchButtonsoptions = mapa.getSwitchMenuButtons(driver);
		
		for(int i = 0; i < 3; i++) {
			mapa.clickOnListElements(driver, switchButtonsoptions, i);
			Thread.sleep(200);
		}
		
		version = basicSteps.getInfoVersion(driver);
		System.out.println(version);
		basicSteps.finalTestActions(driver);
		
	}

}
