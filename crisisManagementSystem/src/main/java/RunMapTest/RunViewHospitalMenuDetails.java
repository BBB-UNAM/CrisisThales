package RunMapTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/MapFeatures/ViewHospitalMenuDetails.feature", glue="map")
public class RunViewHospitalMenuDetails extends AbstractTestNGCucumberTests {

}
