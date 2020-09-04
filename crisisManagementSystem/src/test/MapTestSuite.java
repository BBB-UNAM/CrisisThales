package test;

import org.testng.annotations.Test;

import io.qameta.allure.Attachment;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

import java.io.IOException;
import map.*;


public class MapTestSuite {
  
  @Test(priority=0)
  @Feature("Crisis MAP")
  @Description("Display elements without data")
  @Attachment
  @Severity(SeverityLevel.BLOCKER)
  public void ElementsWithoutData () throws InterruptedException, IOException {
	  ElementsWithoutData testCase1 = new ElementsWithoutData();
	  
	  testCase1.givenStep();
	  testCase1.whenStep();
	  testCase1.andStep();
	  testCase1.thenStep();
  }
  
  @Test(priority=1)
  @Feature("Crisis MAP")
  @Description("Enable and disable Elements without data")
  @Attachment
  @Severity(SeverityLevel.BLOCKER)
  public void LugaresDeInteresLayerGroupVisualizationOneByOne() throws IOException, InterruptedException {
	  LugaresDeInteresLayerGroupVisualizationOneByOne testCase2 = new LugaresDeInteresLayerGroupVisualizationOneByOne();
	  testCase2.givenStep();
	  testCase2.whenStep();
	  testCase2.andStep();
	  testCase2.andAndStep();
	  testCase2.thenStep();
  }
  
  @Test(priority=2)
  @Feature("Crisis MAP")
  @Description("Display drop down \"Lugares de Interes\"")
  @Attachment
  @Severity(SeverityLevel.BLOCKER)
  public void LugaresDeInteresLayerVisualization() throws IOException, InterruptedException {
	  LugaresDeInteresLayerVisualization testCase3 = new LugaresDeInteresLayerVisualization();
	  testCase3.givenStep();
	  testCase3.whenStep();
	  testCase3.andStep();
	  testCase3.thenStep();
  }
  
  @Test(priority=3)
  @Feature("Crisis MAP")
  @Description("Open Layer menu")
  @Attachment
  @Severity(SeverityLevel.BLOCKER)
  public void OpenLayerControlMenu() throws IOException, InterruptedException {
	  OpenLayerControlMenu testCase4 = new OpenLayerControlMenu();
	  testCase4.givenStep();
	  testCase4.whenStep();
	  testCase4.thenStep();
  }
  @Test(priority=4)
  @Feature("Crisis MAP")
  @Description("Reset the inicial position in the map")
  @Attachment
  @Severity(SeverityLevel.BLOCKER)
  public void ResetInicialPositionMap () throws IOException, InterruptedException {
	  ResetInicialPositionMap testCase5 = new ResetInicialPositionMap();
	  testCase5.givenStep();
	  testCase5.whenStep();
	  testCase5.andStep();
	  testCase5.thenStep();
  }
  
  @Test(priority=5)
  @Feature("Crisis MAP")
  @Description("Reset orientation of the map")
  @Attachment
  @Severity(SeverityLevel.BLOCKER)
  public void ResetInitialOrientationMap () throws InterruptedException {
	  ResetInitialOrientationMap testCase6 = new ResetInitialOrientationMap();
	  testCase6.givenStep();
	  testCase6.whenStep();
	  testCase6.andStep();
	  testCase6.thenStep();
	  
  }
  
  @Test(priority=6)
  @Feature("Crisis MAP")
  @Description("View details tooltip map")
  @Attachment
  @Severity(SeverityLevel.BLOCKER)
  public void ViewHospitalDetails () throws IOException, InterruptedException {
	  ViewHospitalDetails testCase7 = new ViewHospitalDetails();
	  testCase7.givenStep();
	  testCase7.whenStep();
	  testCase7.andStep();
	  testCase7.thenStep();
  }
  
  @Test(priority=7)
  @Feature("Crisis MAP")
  @Description("View details window hospital")
  @Attachment
  @Severity(SeverityLevel.BLOCKER)
  public void viewHospitalMenuDetails () throws IOException, InterruptedException {
	  ViewHospitalMenuDetails testCase8 = new ViewHospitalMenuDetails();
	  testCase8.givenStep();
	  testCase8.whenStep();
	  testCase8.andStep();
	  testCase8.thenStep();
  }
  
  @Test(priority=8)
  @Feature("Crisis MAP")
  @Description("Do a search with Quotation Marks")
  @Attachment
  @Severity(SeverityLevel.BLOCKER)
  public void searchWithQuotationMarks() throws IOException, InterruptedException {
	  searchWithQuotationMarks testCase9 = new searchWithQuotationMarks();
	  testCase9.givenStep();
	  testCase9.whenStep();
	  testCase9.andStep();
	  testCase9.thenStep();
  }
  
  @Test(priority=9)
  @Feature("Crisis MAP")
  @Description("Enable and disable geagraphy layers in the map")
  @Attachment
  @Severity(SeverityLevel.BLOCKER)
  public void geographyLayerDisplayedInMap() throws IOException, InterruptedException {
	  geographyLayerDisplayedInMap testCase10 = new geographyLayerDisplayedInMap();
	  testCase10.givenStep();
	  testCase10.whenStep();
	  testCase10.andStep();
	  testCase10.thenStep();
  }

}
