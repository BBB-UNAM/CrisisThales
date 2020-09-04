package RunMapTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/MapFeatures/TrasladosPorAlcaldiaViewLayer.feature", glue="map")
public class RunTrasladosPorAlcaldiaViewLayer extends AbstractTestNGCucumberTests {

}
