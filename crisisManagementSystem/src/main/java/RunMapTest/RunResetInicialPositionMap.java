package RunMapTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/MapFeatures/ResetInicialPositionMap.feature", glue="map")
public class RunResetInicialPositionMap extends AbstractTestNGCucumberTests {

}
