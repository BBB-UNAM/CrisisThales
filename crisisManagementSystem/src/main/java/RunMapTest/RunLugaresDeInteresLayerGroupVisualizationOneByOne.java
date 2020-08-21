package RunMapTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/MapFeatures/lugares _de_interes_LayerGroupVisualizationOneByOne.feature", glue="map")
public class RunLugaresDeInteresLayerGroupVisualizationOneByOne extends AbstractTestNGCucumberTests {
	
}
