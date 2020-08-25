package RunMapTest;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/resources/MapFeatures/ViewHospitalDetails.feature", glue="map")
public class RunViewHospitalDetails extends AbstractTestNGCucumberTests {

}
