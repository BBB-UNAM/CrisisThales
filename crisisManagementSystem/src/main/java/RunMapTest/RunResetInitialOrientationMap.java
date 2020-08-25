package RunMapTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/MapFeatures/ResetInitialOrientationMap.feature",glue="map")
public class RunResetInitialOrientationMap extends AbstractTestNGCucumberTests{

}
