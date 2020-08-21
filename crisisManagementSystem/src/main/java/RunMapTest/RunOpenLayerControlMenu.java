package RunMapTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/MapFeatures/OpenLayerControlMenu.feature", glue="map")
public class RunOpenLayerControlMenu extends AbstractTestNGCucumberTests{

}
