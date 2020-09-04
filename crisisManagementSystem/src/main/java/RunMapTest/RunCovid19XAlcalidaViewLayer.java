package RunMapTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/MapFeatures/Covid19XAlcalidaViewLayer.feature", glue="map")
public class RunCovid19XAlcalidaViewLayer extends AbstractTestNGCucumberTests {

}
