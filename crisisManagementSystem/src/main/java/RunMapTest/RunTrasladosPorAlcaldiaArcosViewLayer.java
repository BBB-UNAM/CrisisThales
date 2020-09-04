package RunMapTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/MapFeatures/TrasladosPorAlcaldiaArcosViewLayer.feature", glue="map")
public class RunTrasladosPorAlcaldiaArcosViewLayer extends AbstractTestNGCucumberTests {

}
