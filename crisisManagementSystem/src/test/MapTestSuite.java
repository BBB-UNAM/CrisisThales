package test;

import org.testng.annotations.Test;
import java.io.IOException;

import map.*;

public class MapTestSuite {
  
  @Test
  public void ElementsWithoutData () throws InterruptedException, IOException {
	  ElementsWithoutData testCase1 = new ElementsWithoutData();
	  
	  testCase1.givenStep();
	  testCase1.whenStep();
	  testCase1.andStep();
	  testCase1.thenStep();
  }
  
  @Test
  public void LugaresDeInteresLayerGroupVisualizationOneByOne() throws IOException, InterruptedException {
	  LugaresDeInteresLayerGroupVisualizationOneByOne testCase2 = new LugaresDeInteresLayerGroupVisualizationOneByOne();
	  testCase2.givenStep();
	  testCase2.whenStep();
	  testCase2.andStep();
	  testCase2.andAndStep();
	  testCase2.thenStep();
  }
  
  @Test
  public void LugaresDeInteresLayerVisualization() throws IOException, InterruptedException {
	  LugaresDeInteresLayerVisualization testCase3 = new LugaresDeInteresLayerVisualization();
	  testCase3.givenStep();
	  testCase3.whenStep();
	  testCase3.andStep();
	  testCase3.thenStep();
  }
  
  @Test
  public void OpenLayerControlMenu() throws IOException, InterruptedException {
	  OpenLayerControlMenu testCase4 = new OpenLayerControlMenu();
	  testCase4.givenStep();
	  testCase4.whenStep();
	  testCase4.thenStep();
  }
  @Test
  public void ResetInicialPositionMap () throws IOException, InterruptedException {
	  ResetInicialPositionMap testCase5 = new ResetInicialPositionMap();
	  testCase5.givenStep();
	  testCase5.whenStep();
	  testCase5.andStep();
	  testCase5.thenStep();
  }
  
  @Test
  public void ResetInitialOrientationMap () throws InterruptedException {
	  ResetInitialOrientationMap testCase6 = new ResetInitialOrientationMap();
	  testCase6.givenStep();
	  testCase6.whenStep();
	  testCase6.andStep();
	  testCase6.thenStep();
	  
  }
  
  @Test
  public void ViewHospitalDetails () throws IOException, InterruptedException {
	  ViewHospitalDetails testCase7 = new ViewHospitalDetails();
	  testCase7.givenStep();
	  testCase7.whenStep();
	  testCase7.andStep();
	  testCase7.thenStep();
  }
  
  @Test
  public void viewHospitalMenuDetails () throws IOException, InterruptedException {
	  ViewHospitalMenuDetails testCase8 = new ViewHospitalMenuDetails();
	  testCase8.givenStep();
	  testCase8.whenStep();
	  testCase8.andStep();
	  testCase8.thenStep();
  }
  

}
