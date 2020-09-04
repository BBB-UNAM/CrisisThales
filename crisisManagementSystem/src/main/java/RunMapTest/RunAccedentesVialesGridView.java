package RunMapTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/MapFeatures/AccedentesVialesGridView.feature", glue="map")
public class RunAccedentesVialesGridView extends AbstractTestNGCucumberTests  {

}
